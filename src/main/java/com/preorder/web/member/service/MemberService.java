package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.web.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;


    /**
     * Member 수정
     */
    @Transactional
    public Member updateMember(Member member) {
        member = memberRepository.findById(member.getMemberNo()).get();
        Member updateMember = memberRepository.save(member);
        return updateMember;
    }




}
