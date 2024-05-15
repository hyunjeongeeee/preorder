package com.preorder.web.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberRequestDTO {
    // 주문시 필요한 회원정보
    private long memberId;
    private String memberAddr;
    private String memberPhone;
}
