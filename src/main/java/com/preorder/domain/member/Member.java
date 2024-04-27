package com.preorder.domain.member;

import com.preorder.web.common.EncryptionUtils;
import com.preorder.web.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@Table(name = "MEMBER",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "member_join_unique",
                        columnNames = {
                                "member_id",
                                "member_email"
                        }
                ),
        }
)
@NoArgsConstructor
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_NO")
    private long memberNo;

    @Column(name = "MEMBER_ID", nullable = false, length = 100)
    private String memberId;

    @Column(name = "MEMBER_PW", nullable = false, length = 100)
    private String memberPw;

    @Column(name = "MEMBER_NAME", nullable = false, length = 100)
    private String memberName;

    @Column(name = "MEMBER_ADDR", length = 500)
    private String memberAddr;

    @Column(name = "MEMBER_EMAIL", nullable = false, length = 100)
    private String memberEmail;

    @Column(name = "MEMBER_PHONE", nullable = false, length = 100)
    private String memberPhone;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false, length = 100)
    private Role role;

    @Transient
    private EncryptionUtils encryptionUtils;


    public EncryptionUtils encryption(EncryptionUtils encryptionUtils) {
        this.encryptionUtils = encryptionUtils;
        return encryptionUtils;
    }

    public Member(MemberDTO memberDTO){}

    @Builder
    public Member(long memberNo, String memberId, String memberPw, String memberName,
                  String memberAddr, String memberEmail, String memberPhone, Role role,
                  EncryptionUtils encryptionUtils) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberAddr = memberAddr;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.encryptionUtils = encryptionUtils;
        this.role = role;
    }



}
