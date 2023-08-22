package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleRepository;


@RestController
@RequestMapping("/schedule") //網址 http://localhost:8080/schedule
public class ScheduleController {
	
	@Autowired
	ScheduleRepository sReps;
	
//取得資料
	//取得所有排程
	//Json格式
	//http://localhost:8080/schedule/get/all
	@GetMapping(value = "/get/all")
	public List<Schedule> getAllSchedule() {
		List<Schedule> data = sReps.findAll();
		return data;
	}
	//View
	//http://localhost:8080/schedule/view/all
	@GetMapping(value = "/view/all")
	public ModelAndView getAllScheduleView() {
		List<Schedule> data = null;
		data = sReps.findAll(); //到此data已被讀取為Json
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}
	
	//以會員列出所有排程
	//http://localhost:8080/schedule/view/{mid}
	@GetMapping("/get/{mid}")
	public List<Schedule> getMidObySname(@PathVariable("mid") Integer mid) {
		List<Schedule> data = sReps.findByMidOrderBySname(mid);
		return data;
	}
	@GetMapping("/view/{mid}")
	public ModelAndView viewMidObySname(@PathVariable("mid") Integer mid) {
		List<Schedule> data = null;
		data = sReps.findByMidOrderBySname(mid);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}
	
	//以會員的排程名稱做篩選並照sort排序
	//http://localhost:8080/schedule/view/{mid}/{sname}
	@GetMapping("/get/{mid}/{sname}")
	public List<Schedule> getMidSnameObySort(@PathVariable Integer mid, @PathVariable("sname") String sname) {
		List<Schedule> data = sReps.findByMidAndSnameOrderBySort(mid, sname);
		return data;
	}
	@GetMapping("/view/{mid}/{sname}")
	public ModelAndView viewMidSnameObySort(@PathVariable Integer mid, @PathVariable("sname") String sname) {
		List<Schedule> data = null;
		data = sReps.findByMidAndSnameOrderBySort(mid, sname);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}
	
	//以redate查詢
	@GetMapping("/get/date/{redate}")
	public List<Schedule> getRedate(@PathVariable("redate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date redate) {
		List<Schedule> data = sReps.findByRedate(redate);
		return data;
	}
	//以redate查詢依據sname與sort排序
	@GetMapping("/get/date/sort/{redate}")
	public List<Schedule> getRedateObySname(@PathVariable("redate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date redate) {
		List<Schedule> data = sReps.findByRedateOrderBySnameAscSortAsc(redate);
		return data;
	}
///////////////新增功能//////////////////
	
	//網址 http://localhost:8080/schedule/add
	@PostMapping("/add")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        // 手動設定 ID 為 null，以便讓 JPA 生成新的 ID
        schedule.setSid(null);
        return sReps.save(schedule);
    }
	
	
	
	
//	@GetMapping("/view/date/{redate}")
	
//	@PostMapping("/add/")
//    public void addSchedule(@ModelAttribute("schedule") Schedule sche) {
//        // save employee to database
//		Schedule data = sReps.save(sche);
//    }

//新增?可參考網址??https://matthung0807.blogspot.com/2019/05/spring-boot-2-spring-data-jpa-mysql-8.html
//修改?
//刪除?
	
//待處理:
//以redate查詢???
//	→ SELECT * FROM workout.schedule WHERE redate = '2023-07-01' ORDER BY schedule_name ASC;
//	→ Date資料處理與讀取?????
//mid改對應到username??


}
