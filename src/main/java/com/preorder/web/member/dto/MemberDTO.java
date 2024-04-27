package com.preorder.web.member.dto;

import com.preorder.domain.member.Role;
import com.preorder.web.common.EncryptionUtils;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class MemberDTO {

    private long memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberAddr;
    private String memberEmail;
    private String memberPhone;
    private Role role;
    private EncryptionUtils encryptionUtils;

    public MemberDTO() {}




}
