//package com.preorder.web.feignCient;
//
//import com.preorder.web.order.dto.MemberResponseDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@FeignClient(name = "member-service" , url="http://localhost:8081/api/internal/members")
//public interface memberClient {
//    @PostMapping("/{memberId}")
//    MemberResponseDTO memberForOrder(@PathVariable("memberId") Long memberId);
//}
