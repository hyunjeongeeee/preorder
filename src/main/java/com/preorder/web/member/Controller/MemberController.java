package com.preorder.web.member.Controller;

import com.preorder.domain.member.Member;
import com.preorder.web.member.dto.MemberDTO;
import com.preorder.web.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class MemberController {

    private  final MemberService memberService;

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
     * 회원정보 조회 => 암호화된것 복호화해서 보여줌
     * */
    @PostMapping("/members")
    public ResponseEntity<?> updateInfo(@RequestParam(name = "id") String id,
                                        @RequestParam(name = "pw") String pw) {
        Member member =  memberService.memberInfoProcess(id, pw);
        return ResponseEntity.ok(member);
    }

    /**
     * 업데이트
     * */
    @PostMapping("/member-update")
    public ResponseEntity<?> updateInfo(@RequestBody Member member) {
        Member data =  memberService.memberUpdateProcess(member);
        return ResponseEntity.ok(data);
    }



}
