package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.web.member.dto.CustomUserDetails;
import com.preorder.web.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public CustomUserDetailService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Member data = memberRepository.findByMemberId(memberId);

        if(data != null) {
           return  new CustomUserDetails(data);
        }
        return null;
    }


}
