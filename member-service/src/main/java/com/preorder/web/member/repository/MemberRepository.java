package com.preorder.web.member.repository;


import com.preorder.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {  // JpaRepository를 상속하여 사용. <객체, ID>

    Member findByMemberNo (long memberNo);

    Optional<Member> findByMemberId(String memberId);   // where 조건절에 넣어 데이터를 가져올 수 있도록 findByMemberId 정의

    List<Member> findAll(); // 전체 조회

    Boolean existsByMemberId(String memberId);

    Optional<Member> findByMemberIdAndMemberPw(String memberId, String memberPw);
}


