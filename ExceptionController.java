package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    @ExceptionHandler(NullPointerException.class)
    public String catcher2(Exception ex, Model m){
        m.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m){
        System.out.println("m=" + m); //아래 main2메서드 Model m과 이 메서드의 m 객체는 서로 다르다.
        m.addAttribute("ex", ex);
        return "error";
    }

    @RequestMapping("/ex")
    public String main(Model m) throws Exception{
            m.addAttribute("msg", "mseeddd");
            throw new Exception("예외가 발생하였습니다.");
    }

    @RequestMapping("/ex2")
    public String main2() throws Exception{
            throw new FileNotFoundException("예외가 발생하였습니다.");
    }
}