package com.preorder.web.email.controller;

import com.preorder.web.email.sercive.RegisterMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class  EmailController {

    @Autowired
    RegisterMail registerMail;

    /**
     * 이메일 인증
     * */
    @PostMapping(value = "/confirm")
    public String mailConfirm(@RequestParam(name = "email") String email) throws Exception {
        String code = registerMail.sendSimpleMessage(email);
        System.out.println("사용자에게 발송한 인증코드 ==> " + code);
        return code;
    }



}