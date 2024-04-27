package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.web.common.EncryptionUtils;
import com.preorder.web.member.dto.MemberDTO;
import com.preorder.web.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EncryptionUtils encryptionUtils;

    public MemberService(MemberRepository memberRepository, EncryptionUtils encryptionUtils) {
        this.memberRepository = memberRepository;
        this.encryptionUtils = encryptionUtils;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();

    }

    /**
     *   회원가입
     */
    public void joinProcess(MemberDTO memberDTO) {
        String id = memberDTO.getMemberId();
        String password = memberDTO.getMemberPw();
        String email = memberDTO.getMemberEmail();
        String phone = memberDTO.getMemberPhone();
        String address = memberDTO.getMemberAddr();
        String name = memberDTO.getMemberName();

        Boolean isExist = memberRepository.existsByMemberId(id);

        if (isExist) {
            return ;
        }
        Member data = new Member();
        data = Member.builder()
                .memberId(id)
                .memberPw(bCryptPasswordEncoder.encode(password))
                .memberName(encryptionUtils.encrypt(name))
                .memberEmail(encryptionUtils.encrypt(email))
                .memberPhone(encryptionUtils.encrypt(phone))
                .memberAddr(encryptionUtils.encrypt(address))
                .build();
        memberRepository.save(data);
    }

    /**
     *  회원정보 조회
     */
    public Optional<Member> getMemberById(String id) {
        return memberRepository.findByMemberId(id);
    }

    /**
     * 회원정보 조회
     * */
    public Member memberInfoProcess(String id, String pw) {

        // 조건 => 아이디와 비밀번호가 둘다 같아야함
        // 1) 일단 아이디가 같은 객체를 불러옴
        Optional<Member> optional = memberRepository.findByMemberId(id);

        String password = optional.get().getMemberPw();

        // 2) 입력받은 비밀번호가 같은지 확인하기
        if(bCryptPasswordEncoder.matches(pw, password)) {
            System.out.println("비밀번호 일치");
            Member member = optional.get();
            Member data = new Member();
            data = Member.builder()
                    .memberId(id)
                    .memberNo(member.getMemberNo())
                    .memberName(encryptionUtils.decrypt(member.getMemberName()))
                    .memberEmail(encryptionUtils.decrypt(member.getMemberEmail()))
                    .memberPhone(encryptionUtils.decrypt(member.getMemberPhone()))
                    .memberAddr(encryptionUtils.decrypt(member.getMemberAddr()))
                    .role(member.getRole())
                    .build();

            return data;

        } else {
            System.out.println("비밀번호 불일치");
            return  null;
        }
    }


   /**
    * 회원정보 수정
    * */
   public Member memberUpdateProcess(Member member) {

       Member data = memberInfoProcess(member.getMemberId(), member.getMemberPw());
        //  주소, 전화번호 => null 인 경우 수정 X
        String originAddr =  data.getMemberAddr();
        String originPhone = data.getMemberPhone();
        System.out.println("originAddr: " + originAddr);
        System.out.println("originPhone : " + originPhone);

        // 입력받은 데이터
        String addr = member.getMemberAddr();
        String phone = member.getMemberPhone();
        System.out.println("addr: " + addr);
        System.out.println("phone: " + phone);

      if(!originAddr.equals(addr) || addr != null) {
            addr = encryptionUtils.encrypt(addr);
      }

       if(!originPhone.equals(phone) || phone !=null) {
           phone = encryptionUtils.encrypt(phone);
       }

       memberRepository.updateMemberInfo(phone, addr, member.getMemberNo());



       return member;

   }


}
