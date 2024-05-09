package com.preorder.web.member.controller;

import com.preorder.domain.member.Member;
import com.preorder.web.member.dto.MemberDTO;
import com.preorder.web.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    /**
     * 회원가입
     * */
    @PostMapping("/join")
    public String joinProcess(MemberDTO memberDTO) {
        memberService.joinProcess(memberDTO);
        return "가입완료";
    }

    /**
     * 회원정보  => 암호화된것 복호화해서 보여줌
     * */
    @PostMapping("/{memberId}")
    public ResponseEntity<Member> updateInfo(@PathVariable("memberId") String memberId,
                                        @RequestParam("memberPw") String memberPw) {
        Member member =  memberService.memberInfoProcess(memberId, memberPw);
        return ResponseEntity.ok(member);
    }

    /**
     * 업데이트
     * */
    @PostMapping("/update")
    public ResponseEntity<?> updateInfo(@RequestBody Member member) {
        Member data =  memberService.memberUpdateProcess(member);
        return ResponseEntity.ok(data);
    }


    // 내부 API 예시: 주문 서비스용 사용자 정보 조회
//    @GetMapping("/internal/members/{memberId}")
//    public ResponseEntity<?> getUserForOrder(@PathVariable String memberId) {
//        Member member = memberService.findForOrderService(memberId);
//        return ResponseEntity.ok(member);
//        return null;
//    }


}
