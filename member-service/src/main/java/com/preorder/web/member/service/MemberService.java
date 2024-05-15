package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.domain.member.QMember;
import com.preorder.web.common.EncryptionUtils;
import com.preorder.web.member.dto.MemberDTO;
import com.preorder.web.member.dto.MemberRequestDTO;
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



    public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                         EncryptionUtils encryptionUtils ,EntityManager entityManager) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.encryptionUtils = encryptionUtils;
        this.entityManager = entityManager;
    }


    /**
     *   회원가입
     */
    public void joinProcess(MemberDTO memberDTO) {
        String nickName = memberDTO.getMemberNickname();
        String password = memberDTO.getMemberPw();
        String email = memberDTO.getMemberEmail();
        String phone = memberDTO.getMemberPhone();
        String address = memberDTO.getMemberAddr();
        String name = memberDTO.getMemberName();

        Boolean isExist = memberRepository.existsByMemberNickname(nickName);

        if (isExist) {
            return ;
        }
        Member data = new Member();
        data = Member.builder()
                .memberNickname(nickName)
                .memberPw(bCryptPasswordEncoder.encode(password))
                .memberName(encryptionUtils.encrypt(name))
                .memberEmail(encryptionUtils.encrypt(email))
                .memberPhone(encryptionUtils.encrypt(phone))
                .memberAddr(encryptionUtils.encrypt(address))
                .build();
        memberRepository.save(data);
        System.out.println("저장된 회원 정보 : "+data);

    }

    /**
     *  회원정보 조회
     */
    public Optional<Member> getMemberById(String id) {
        return memberRepository.findByMemberNickname(id);
    }

    /**
     * 회원정보 조회
     * */
    public Member memberInfoProcess(String id, String pw) {

        // 조건 => 아이디와 비밀번호가 둘다 같아야함
        // 1) 일단 아이디가 같은 객체를 불러옴
        Member member = memberRepository.findByMemberNickname(id).orElseThrow(() -> new RuntimeException("Member not found"));

        String password = member.getMemberPw();

        // 2) 입력받은 비밀번호가 같은지 확인하기
        if(bCryptPasswordEncoder.matches(pw, password)) {
            System.out.println("비밀번호 일치");
            Member data = Member.builder()
                    .memberId(member.getMemberId())
                    .memberNickname(member.getMemberNickname())
                    .memberName(encryptionUtils.decrypt(member.getMemberName()))
                    .memberEmail(encryptionUtils.decrypt(member.getMemberEmail()))
                    .memberPhone(encryptionUtils.decrypt(member.getMemberPhone()))
                    .memberAddr(encryptionUtils.decrypt(member.getMemberAddr()))
                    .role(member.getRole())
                    .build();
            return data;
        }
        return null;
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
        Member data = memberInfoProcess(member.getMemberNickname(), member.getMemberPw());
        long memberId = data.getMemberId();
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
           update.where(qMember.memberId.eq(memberId))
                   .execute();
       }
       return member;
   }

   /**
    * 주문을 위한 회원정보 반환
    * */
//    public MemberRequestDTO findForOrderService(long memberId) {
//        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
//        MemberRequestDTO memberRequestDTO = MemberRequestDTO.builder()
//                .memberId(memberId)
//                .memberAddr(encryptionUtils.decrypt(member.getMemberAddr()))
//                .memberPhone(encryptionUtils.decrypt(member.getMemberPhone()))
//                .build();
//        return memberRequestDTO;
//   }

}
