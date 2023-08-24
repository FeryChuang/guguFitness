package com.example.demo.controller;
import com.example.demo.model.Chick;
import com.example.demo.model.ChickRepository;
import com.example.demo.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
@RequestMapping("/chick")
public class ChickController {
    
    @Autowired
    private ChickRepository chickRepository; // 注入ChickRepository


    
    
    @RequestMapping(value = "/info", method = RequestMethod.GET) // 修改映射路径
    public ResponseEntity<Chick> getChickInfo(@SessionAttribute("loggedInMember") Member member) {
        Integer memberid = member.getMemberId();
        List<Chick> chickData = chickRepository.findByMemberId(memberid);

        if (!chickData.isEmpty()) {
            return new ResponseEntity<>(chickData.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
   
    
}
