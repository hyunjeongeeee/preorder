package com.preorder.web.member.controller;

import com.preorder.domain.member.Member;
import com.preorder.web.member.dto.MemberDTO;
import com.preorder.web.member.dto.MemberRequestDTO;
import com.preorder.web.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internal/members")
public class MemberRestController {

    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }


    /**
     * 회원정보  => 암호화된것 복호화해서 보여줌
     * */
//    @PostMapping("/{memberId}")
//    public ResponseEntity<MemberRequestDTO> getUserForOrder(@PathVariable("memberId") long memberId) {
//        MemberRequestDTO member =  memberService.findForOrderService(memberId);
//        return ResponseEntity.ok(member);
//    }



}
