package com.preorder.web.member.Controller;


import com.preorder.web.member.dto.JoinDTO;
import com.preorder.web.member.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private  final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }
    // @autowired 보다 생성자 주입방식을 권고하는 이유?

    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {
        joinService.joinProcess(joinDTO);
        return "ok";
    }

}
