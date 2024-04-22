package com.preorder.domain.member;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "member")
@NoArgsConstructor
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class Member{

    @Id // Primary Key 지정
    // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String memberPw;

    @Column
    private Role role;
    /*
    @Column(nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String memberAddr;

    private LocalDate memberBirth;

    @Column(nullable = false)
    private String memberEmail;

    @Column(nullable = false)
    private String memberPhone;

    @Column(nullable = false)
    private LocalDate memberSignDate;
    *//**
     * PrePersist
     * => insert 되기전 (persist 되기전) 실행된다.
     * *//*
    @PrePersist
    void onPrePersist() {
        if (memberSignDate == null)  memberSignDate = LocalDate.now();
    }

    @Column(nullable = true)
    private LocalDate memberDelDate;

    @Column(nullable = true)
    @ColumnDefault("'Y'")
    private String memberStatus;


    @Enumerated(EnumType.STRING)
    private Role role;*/

//    public void encodePassword(PasswordEncoder passwordEncoder){
//        this.memberPw = passwordEncoder.encode(memberPw);
//    }
}

