package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "membercreate", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Member me) {
		ModelAndView model = new ModelAndView("redirect:/signin");
		dao.save(me);
		// model.addObject(cus);
		return model;
	}
}
