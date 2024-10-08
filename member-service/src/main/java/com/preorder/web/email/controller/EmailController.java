package com.preorder.web.email.controller;

import com.preorder.web.email.service.RegisterMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/email")
public class  EmailController {

    @Autowired
    RegisterMail registerMail;

    /**
     * 이메일 인증
     * */
    @PostMapping(value = "/confirm")
    public String mailConfirm(@RequestParam(name = "email") String email) throws Exception {
        String code = registerMail.sendSimpleMessage(email);
        System.out.println("Received email: " + email);
        System.out.println("사용자에게 발송한 인증코드 ==> " + code);
        System.out.println("***전송완료***");
        log.info("이메일 주소 : {}", email);
        return code;
    }

}