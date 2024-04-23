package com.preorder.web.member.Controller;

import com.preorder.domain.member.Member;
import com.preorder.web.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

    private final MemberService memberService;


    /**
    * 회원 가입
     */
    @PostMapping("register")
    public ResponseEntity<Member> memberRegister(@RequestBody Member member){
        Member saveMember = memberService.createMember(member);
        return ResponseEntity.ok(saveMember);
    }

    /**
     *  로그인
     */
//    public ResponseEntity<Member> memberLogin(@RequestParam String memberId, @RequestParam String memberPw){
//
//        return new ResponseEntity.ok();
//    }

    /**
     * 회원정보 수정
     */
    @PostMapping("/update")
    public ResponseEntity<Member> memberUpdate(@RequestBody Member member) {
        Member updateMember = memberService.createMember(member);
        return ResponseEntity.ok(updateMember);
    }









}
