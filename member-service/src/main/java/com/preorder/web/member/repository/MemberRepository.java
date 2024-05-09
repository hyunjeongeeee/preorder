package com.preorder.web.member.repository;


import com.preorder.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {  // JpaRepository를 상속하여 사용. <객체, ID>

    Member findByMemberId(long memberId);

    Optional<Member> findByMemberNickname(String memberNickname);   // where 조건절에 넣어 데이터를 가져올 수 있도록 findByMemberNickname 정의

    List<Member> findAll(); // 전체 조회

    Boolean existsByMemberNickname(String memberNickname);

    Optional<Member> findByMemberNicknameAndMemberPw(String memberNickname, String memberPw);
}


