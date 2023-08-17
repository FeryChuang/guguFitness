package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Member;
import com.example.demo.model.MemberRepository;



@RestController
public class MemberController {

	@Autowired
	MemberRepository dao;
	
	@RequestMapping(value = "/membercreate", method = RequestMethod.POST)
	public ModelAndView add(@RequestBody Member me) {
		ModelAndView model = new ModelAndView("redirect:/index.html");
		dao.save(me);
		return model;
	}
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public ModelAndView signin(@ModelAttribute String userName, String password) {
		ModelAndView model=null;
		Boolean b=dao.findByUserNameAndPassword(userName, password);
		System.out.println(b);
		if(b) {
			model=new ModelAndView("signin");
			model.addObject("username", userName);
			return model;
		}else{
			model=new ModelAndView("redirect:/index.html?info=查無此帳號或密碼錯誤");
			return model;
		}	
	}
}
