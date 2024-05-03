package com.preorder.web.order.service;

import com.preorder.domain.order.Orders;
import com.preorder.web.order.repository.OrderRepository;
import com.preorder.web.productClient.ProductClient;
import com.preorder.web.productClient.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    /**
     * 주문 조회
     * */
    public Optional<Orders> getOrderProcess(int orderId) {
        Optional<Orders> orders = orderRepository.findById(orderId);
        if(orders.isPresent()) return orders;
        else return Optional.empty();
    }

    /**
     * 회원번호로 검색한
     * 주문목록
     * */
    public List<ProductResponse> findAll(long memberNo) {
        List<Orders> list = orderRepository.findAll();
        List<ProductResponse> result = new ArrayList<>();
        for(Orders order : list) {
            if(order.getMemberNo() == memberNo) {
                ProductResponse productResponse =  productClient.getMemberOrderList(order.getPdId());
                result.add(productResponse);
            }
        }

        return result;
    }


}
