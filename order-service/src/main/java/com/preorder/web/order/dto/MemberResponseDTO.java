package com.preorder.web.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponseDTO {
    // 주문시 필요한 회원정보
    private long memberId;
    private String memberAddr;
    private String memberPhone;
}
