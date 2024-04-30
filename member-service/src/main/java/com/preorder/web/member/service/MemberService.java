package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.domain.member.QMember;
import com.preorder.web.common.EncryptionUtils;
import com.preorder.web.member.dto.MemberDTO;
import com.preorder.web.member.repository.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EncryptionUtils encryptionUtils;
    private final EntityManager entityManager;

    public MemberService(MemberRepository memberRepository, EncryptionUtils encryptionUtils, EntityManager entityManager) {
        this.memberRepository = memberRepository;
        this.encryptionUtils = encryptionUtils;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.entityManager = entityManager;
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
   @Transactional
   public Member memberUpdateProcess(Member member) {
       // Querydsl JPA 엔티티 매니저 및 쿼리 팩토리 설정
       JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        // 멤버 엔티티를 위한 QMember 인스턴스 생성
       QMember qMember = QMember.member;
        // 동적으로 업데이트 문 생성을 위한 JPAUpdateClause 초기화
       JPAUpdateClause update = queryFactory.update(qMember);
        Member data = memberInfoProcess(member.getMemberId(), member.getMemberPw());
        long memberNo = data.getMemberNo();
       String addr = member.getMemberAddr();
       String phone = member.getMemberPhone();

       //  주소, 전화번호 => null 인 경우 수정 X
       // 동적 조건 생성
       if (phone != null) {
           phone = encryptionUtils.encrypt(phone);
           update.set(qMember.memberPhone, phone);
       }
       if (addr != null) {
           addr = encryptionUtils.encrypt(addr);
           update.set(qMember.memberAddr, addr);
       }

       // 변경 조건이 하나 이상 있을 때만 실행
       if (phone != null || addr != null) {
           update.where(qMember.memberNo.eq(memberNo))
                   .execute();
       }
       return member;
   }


}
