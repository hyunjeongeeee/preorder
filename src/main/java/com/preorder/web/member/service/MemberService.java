package com.preorder.web.member.service;

import com.preorder.domain.member.Member;
import com.preorder.web.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * Member 생성
     *
    */
    public Member createMember(Member member) {
        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    /**
     * Member 수정
     */
    @Transactional
    public Member updateMember(Member member) {
        member = memberRepository.findById(member.getMemberNo()).get();
        Member updateMember = memberRepository.save(member);
        return updateMember;
    }


    /**
     * Member 수정
     * JPA Repository의 save Method를 사용하여 객체를 업데이트 할 수 있습니다.
     * Entity Member에 @Id로 설정한 키 값이 존재할 경우 해당하는 데이터를 업데이트 해줍니다.
     * 만약 수정하려는 Entity Member 객체에 @Id 값이 존재하지 않으면 Insert 되기 때문에
     * 아래와 같이 업데이트 하고자 하는 Member가 존재하는지 체크하는 로직을 추가하였습니다.
     *
     * @param member
     * @return
     */
//    public Member updateMember(Member member) {
//        Member updatedMember = null;
//        try {
//            Member existMember = getMember(member.getId());
//            if (!ObjectUtils.isEmpty(existMember)) {
//                updatedMember = memberRepository.save(member);  // JpaRepository에서 제공하는 save() 함수
//            }
//        } catch (Exception e) {
//            log.info("[Fail] e: " + e.toString());
//        } finally {
//            return updatedMember;
//        }
//    }

    /**
     * Member List 조회
     *
     * @return
     */
    public List<Member> getMembers() {
        return memberRepository.findAll();  // JpaRepository에서 제공하는 findAll() 함수
    }

//        @PostMapping("create")
//    public ResponseEntity<Member> createMember() throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = format.parse("1995-09-02");
//        LocalDate localDate = LocalDate.now();
//        Member member = Member.builder()
//                .memberId("123456")
//                .memberPw("1234")
//                .memberName("현정")
//                .memberBirth(date)
//                .memberPhone("01012345678")
//                .memberSignDate(date)
//                .memberDelDate(date)
//                .memberStatus("Y")
//                .build();
//        Member saveMember = memberService.createMember(member);
//        return new ResponseEntity<>(saveMember, HttpStatus.OK);
//    }
}
