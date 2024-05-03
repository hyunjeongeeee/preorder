package com.preorder.web.wishList.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-server", url = "http://localhost:8081")
public interface MemberClient {


}