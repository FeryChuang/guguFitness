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
@RequestMapping("/schedule3") // 網址 http://localhost:8080/schedule3
public class Schedule3Controller implements CommandLineRunner {

	@Autowired
	Schedule3Repository sReps;

	// 網址 http://localhost:8080/schedule3/get/mc/{mid}/{cid}
	@GetMapping("/get/mc/{mid}/{cid}")
	public Schedule3 findByMidAndCid(@PathVariable("mid") Integer mid, @PathVariable("cid") Integer cid) {
		Schedule3 sch=sReps.findByMidAndCid(mid,cid);
		return sch;
	}


/////////////////新增功能/////////////////////
// Postman測試語法↓↓
//	{
//        "sid": "",
//        "mid": 1,
//        "cid": 5,
//        "mon": true,
//        "tue": true,
//        "wed": true,
//        "thu": true,
//        "fri": true,
//        "sat": false,
//        "sun": false
//    }
	// 網址 http://localhost:8080/schedule3/add
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
