package com.preorder.web.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {

    private Long memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private LocalDate memberBirth;
    private String memberEmail;
    private String memberPhone;
    private LocalDate memberSignDate;
    private LocalDate memberDelDate;
    private String memberStatus;


}
