package com.preorder.web.member.repository;


import com.preorder.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository  extends JpaRepository<Member, Long> {  // JpaRepository를 상속하여 사용. <객체, ID>

}
