package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.web.member.dto.CustomUserDetails;
import com.preorder.web.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public CustomUserDetailService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Optional<Member> data = memberRepository.findByMemberId(memberId);

        if(data.isPresent()) {
           return  new CustomUserDetails(data.orElse(null));
        }
        return null;
    }


}
