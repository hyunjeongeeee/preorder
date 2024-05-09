package com.preorder.web.order.service;

import com.preorder.domain.order.OrderStatus;
import com.preorder.domain.order.Orders;
import com.preorder.web.order.dto.ProductResponseDTO;
import com.preorder.web.order.dto.OrdersResponseDTO;
import com.preorder.web.order.dto.ProductStockResponse;
import com.preorder.web.order.dto.StockResponseDTO;
import com.preorder.web.order.repository.OrderRepository;
import com.preorder.web.feignCient.ProductClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    /**
     * 주문 생성
     * */
    public void createOrder(List<Orders> ordersList) {

        for (Orders orders : ordersList) {
            int oneProductPrice = productClient.getProductById(orders.getProductId()).getProductPrice();
            Orders data = Orders.builder()
                    .productId(orders.getProductId())
                    .productCount(orders.getProductCount())
                    .memberId(orders.getMemberId())
                    .orderAddr(orders.getOrderAddr())
                    .orderPhone(orders.getOrderPhone())
                    .orderMemo(orders.getOrderMemo())
                    .orderPrice((oneProductPrice * orders.getProductCount()))
                    .build();
            orderRepository.save(data);

            // 주문 수량만큼 마이너스 후 재고 업데이트
            productClient.updateStock(orders.getProductId(), orders.getProductCount());
        }
    }



    /**
     * 주문 조회
     * */
    public Orders getOrderProcess(int orderId) {
        Orders orders = orderRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        return orders;
    }

    /**
     * 회원번호로 검색한 주문목록
     * */
    public List<OrdersResponseDTO> getAllOrdersWithProductInfo(long memberId) {
        // 주어진 memberId에 해당하는 주문만 조회
        List<Orders> ordersList = orderRepository.findByMemberId(memberId);
        List<OrdersResponseDTO> result = new ArrayList<>();

        for (Orders order : ordersList) {
            // Feign Client를 사용하여 상품 정보를 가져옴
            // 모든 주문 목록을 가져오면서 각 주문의 상품 이름과 가격을 추가
            ProductResponseDTO product = productClient.getProductById(order.getProductId());
            result.add(new OrdersResponseDTO(order, product));
        }
        return result;
    }

    /**
     * 특정 상품 정보
     * => productClient + orderRepository 활용
     * */
//    public StockResponseDTO updateOrderProcess(long orderId) {
//        Orders orders = orderRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
//        ProductStockResponse productStock = productClient.getProductStockById(orders.getProductId());
//        return new StockResponseDTO(orders, productStock);
//    }

    /**
     *  매일 자정에 업데이트하는 스케줄러를 설정
     * */
    @Transactional
    public void updateOrderStatuses() {
        LocalDate now = LocalDate.now();
        List<Orders> ordersShippingToday = orderRepository.findAllByOrderDateLessThanEqualAndOrderStatus(now.minusDays(1) , OrderStatus.배송전);
        ordersShippingToday.forEach(order -> {
            order.setOrderStatus(OrderStatus.배송중);
        });

        List<Orders> ordersDeliveredToday = orderRepository.findAllByOrderDateLessThanEqualAndOrderStatus(now.minusDays(2), OrderStatus.배송중);
        ordersDeliveredToday.forEach(order -> {
            order.setOrderStatus(OrderStatus.배송완료);
        });

        orderRepository.saveAll(ordersShippingToday);
        orderRepository.saveAll(ordersDeliveredToday);
    }




}
