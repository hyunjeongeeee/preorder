package com.preorder.web.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {

    // 테스트용 - > 컬럼 추가해야됨
    private Long memberNo;
    private String memberid;
    private String memberpassword;
}
