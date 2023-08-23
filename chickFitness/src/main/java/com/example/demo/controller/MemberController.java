package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Chick;
import com.example.demo.model.ChickRepository;
import com.example.demo.model.Member;
import com.example.demo.model.MemberRepository;



@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ChickRepository chickRepository;

    @RequestMapping(value = "/membercreate", method = RequestMethod.POST)
    public ModelAndView add(@RequestBody Member member) {
        ModelAndView model = new ModelAndView("redirect:/index.html");
        
        // 新增 Member 資料
        Member savedMember = memberRepository.save(member);
        
        // 新增對應的 Chick 資料，設定預設值
         Chick chick = new Chick();
        chick.setUserName(savedMember.getUserName()); // 使用相同的使用者名稱
        chick.setChickStage("手無縛雞"); // 設定預設階段
        chick.setCurrentLevel(1); // 設定預設等級
        chick.setCurrentExp(0); // 設定預設經驗值
        chick.setLifecount(0); // 設定預設生命數量
        chickRepository.save(chick);
        
        return model;
    }
 ///登入//////////////////////////////////////////////////////   
    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String userName, @RequestParam String password, HttpSession session) {
        Member member = memberRepository.findByUserNameAndPassword(userName, password);

        if (member != null) {
            // 将会员信息存储在 HttpSession 中
            session.setAttribute("loggedInMember", member);
             System.out.println(session.getAttribute("loggedInMember"));
            ModelAndView model = new ModelAndView("redirect:/home.html");
            return model;
        } else {
            ModelAndView model = new ModelAndView("redirect:/index.html");
            model.addObject("info", "Login failed"); // 传递错误信息到登录页面
            return model;
        }
        
     
    }
    @RequestMapping(value="/session",method=RequestMethod.GET)
    public Member getSession(HttpSession session) {
   	 return (Member)session.getAttribute("loggedInMember");
    }


}
