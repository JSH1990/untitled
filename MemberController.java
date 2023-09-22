package com.example.demo;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public String memberLogin(@RequestParam String memberId, @RequestParam String memberPwd, HttpSession session) {
        Member loginUser = memberService.loginMember(memberId, memberPwd);

        if(loginUser != null) {
            session.setAttribute("loginMember", loginUser);
            session.setAttribute("msg", loginUser.getMemberName() + "님 환영합니다.");
        } else {
            session.setAttribute("msg", "로그인 실패");
        }

        return "redirect:/";
    }
}
