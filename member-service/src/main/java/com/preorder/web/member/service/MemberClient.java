package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-service", url = "http://member-service/api")
public interface MemberClient {


    /**
     * 특정 사용자의 ID를 기반으로 사용자 정보를 조회한다.
     * GET 요청을 "/users/{userId}" 엔드포인트에 매핑한다.
     *
     * @param memberId 사용자의 ID
     * @return Member 도메인 객체
     */
    @GetMapping("/members/{member}")
    Member getMemberId(@PathVariable("memberId") String memberId);

}
