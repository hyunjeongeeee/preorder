//package com.preorder.web.wishList.service;
//
//import com.preorder.web.order.dto.MemberResponseDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@FeignClient(name = "member-server", url = "http://localhost:8081")
//public interface MemberClient {
//    @PostMapping("/{memberId}")
//    MemberRequestDTO memberForOrder(@PathVariable("memberId") Long memberId);
//
//}