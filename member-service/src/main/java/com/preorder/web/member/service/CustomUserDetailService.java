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
    public UserDetails loadUserByUsername(String memberNickname) throws UsernameNotFoundException {
        //DB에서 조회
        Member data = memberRepository.findByMemberNickname(memberNickname).orElseThrow(null);
        if(data != null) {
            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
           return  new CustomUserDetails(data);
        }
        return null;
    }
}
