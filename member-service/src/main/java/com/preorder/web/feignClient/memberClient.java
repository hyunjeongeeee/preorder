//package com.preorder.web.feignClient;
//
//import com.preorder.web.member.dto.MemberRequestDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@FeignClient(name = "member-service" , url="http://localhost:8081/api/internal/members")
//public interface memberClient {
//    @PostMapping("/{memberId}")
//    MemberRequestDTO memberForOrder(@PathVariable("memberId") Long memberId);
//}
