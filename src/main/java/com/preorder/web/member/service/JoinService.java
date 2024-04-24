package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.domain.member.Role;
import com.preorder.web.member.dto.JoinDTO;
import com.preorder.web.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     *   회원가입
     */
    public JoinService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void joinProcess(JoinDTO joinDTO) {
        String id = joinDTO.getMemberid();
        String password = joinDTO.getMemberpassword();

        Boolean isExist = memberRepository.existsByMemberId(id);

        if (isExist) {
            return;
        }

        Member data = new Member();

        data.setMemberId(id);
        data.setMemberPw(bCryptPasswordEncoder.encode(password));
        data.setRole(Role.ADMIN);  // 테스트중 -> admin으로 지정

        memberRepository.save(data);
    }



}
