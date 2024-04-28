package com.preorder.web.order.service;

import com.preorder.web.order.repository.OrderRepository;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * 주문
     * */
    public Order getOrder() {
        return  null;
    }

    /**
     * 주문목록
     * */
    public List<Order> findAll() {
    return null;
    }


}
