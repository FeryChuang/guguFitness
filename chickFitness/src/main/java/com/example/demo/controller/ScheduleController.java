package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleRepository;


@RestController
@RequestMapping("/schedule") // 網址http://localhost:8080/schedule
public class ScheduleController {
	@Autowired
	ScheduleRepository sReps;

	
	
//取得資料
	//Json格式
	@GetMapping(value = "/getAlljson")
	public List<Schedule> getAllSchedule() {
		List<Schedule> data = sReps.findAll();
		return data;
	}
	//View
	@GetMapping(value = "/view/All")
	public ModelAndView getAllScheduleView() {
		List<Schedule> data = null;
		data = sReps.findAll(); //到此data已被讀取為Json
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}
	
//	@GetMapping("/view/redate/{url_redate}") //{urlAge}，程式內如需要使用，需以@PathVariable("urlAge") 定義(本處定義型態為Integer 參數名稱age)
//	public List<Schedule> getRedate(@PathVariable("url_redate") Date redate) {
//		List<Schedule> data = (sReps.findAll()).stream().filter(u->u.getRedate().equals(redate)).collect(Collectors.toList());
//		return data;//
//	}

}
