package com.preorder.web.order.service;

import com.preorder.domain.order.Orders;
import com.preorder.web.order.repository.OrderRepository;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 주문 조회
     * */
    public Optional<Orders> getOrderProcess(int orderId) {
        Optional<Orders> orders = orderRepository.findById(orderId);
        if(orders.isPresent()) return orders;
        else return Optional.empty();
    }

    /**
     * 주문목록
     * */
    public List<Order> findAll() {
    return null;
    }


}
