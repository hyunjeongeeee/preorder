package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="order-service", url="http://localhost://8083")
public interface WishListClient {

    @GetMapping("/wishList/{memberNo}")
    List<Member> getWishList(@PathVariable("memberNo") long memberNo);

}
