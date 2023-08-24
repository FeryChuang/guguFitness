package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Schedule3;
import com.example.demo.model.Schedule3Repository;



@RestController
@RequestMapping("/schedule3") // 網址 http://localhost:8080/schedule2
public class Schedule3Controller implements CommandLineRunner {

	@Autowired
	Schedule3Repository sReps;

	
	@GetMapping("/get/mc/{mid}/{cid}/weeks")
	public Schedule3 findByMidAndCid(@PathVariable("mid") Integer mid, @PathVariable("cid") Integer cid) {
		Schedule3 sch=sReps.findByMidAndCid(mid,cid);
		return sch;
	}

	//拿上面方法的資料做修改成返回星期的純數字
//	@GetMapping("/get/mc/{mid}/{cid}/weeks")
//	public List<Integer> findWeekByMidAndCid(@PathVariable("mid") Integer mid, @PathVariable("cid") Integer cid) {
//	    List<Schedule3> data = sReps.findByMidAndCidOrderByWeek(mid, cid);
//	    List<Integer> weeks = data.stream()
//	        .map(Schedule3::getWeek) // 提取 week 字段值
//	        .collect(Collectors.toList());
//	    
//	    return weeks;
//	}	


/////////////////新增功能/////////////////////
// Postman測試語法↓↓
//{
//        "sid": null,
//        "mid": 2,
//        "cid": 3,
//        "week": 6
//}
	// 網址 http://localhost:8080/schedule2/add
	@PostMapping("/add")
	public void addSchedule(@RequestBody Schedule3 schedule) {
		// 手動設定 ID 為 null，以便讓 JPA 生成新的 ID
		sReps.save(schedule);
	}

	@GetMapping("/get/plan/{mid}")
	public List<Schedule3> findByMid(@PathVariable("mid") Integer mid){
		return sReps.findByMid(mid);
	}
	
////新增測試資料區
	@Override
	public void run(String... args) throws Exception {

	}

}