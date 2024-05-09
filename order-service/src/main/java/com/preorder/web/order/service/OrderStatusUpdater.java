package com.preorder.web.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  // 독립적으로 실행
@EnableScheduling   // 스프링 스케쥴러
@RequiredArgsConstructor
public class OrderStatusUpdater {

    private final OrderService orderService;

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void updateOrderStatuses() {
        orderService.updateOrderStatuses();
        System.out.println("Order statuses updated.");
    }
}