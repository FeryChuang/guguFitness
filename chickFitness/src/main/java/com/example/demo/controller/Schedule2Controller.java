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

import com.example.demo.model.Schedule2;
import com.example.demo.model.Schedule2Repository;

@RestController
@RequestMapping("/schedule2") // 網址 http://localhost:8080/schedule2
public class Schedule2Controller implements CommandLineRunner {

	@Autowired
	Schedule2Repository sReps;

////////////////取得資料/////////////////////////
// 取得所有排程
	// Json格式
	// 網址 http://localhost:8080/schedule2/get/all
	@GetMapping(value = "/get/all")
	public List<Schedule2> getAllSchedule() {
		List<Schedule2> data = sReps.findAll();
		return data;
	}

	// View
	// 網址 http://localhost:8080/schedule2/view/all
	@GetMapping(value = "/view/all")
	public ModelAndView getAllScheduleView() {
		List<Schedule2> data = null;
		data = sReps.findAll(); // 到此data已被讀取為Json
		ModelAndView view = new ModelAndView("/schedule/viewSchedule2");
		view.addObject("fc_data_1", data);
		return view;
	}

// 以會員做篩選並照week排序
	// 網址 http://localhost:8080/schedule2/get/m/{mid}
	@GetMapping("/get/m/{mid}")
	public List<Schedule2> getMidObyWeek(@PathVariable("mid") Integer mid) {
		List<Schedule2> data = sReps.findByMidOrderByWeek(mid);
		return data;
	}

	// 網址 http://localhost:8080/schedule2/view/m/{mid}
	@GetMapping("/view/m/{mid}")
	public ModelAndView viewMidObyWeek(@PathVariable("mid") Integer mid) {
		List<Schedule2> data = null;
		data = sReps.findByMidOrderByWeek(mid);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule2");
		view.addObject("fc_data_1", data);
		return view;
	}

// 以會員的課程做篩選並照week排序
	// 網址 http://localhost:8080/schedule2/get/mc/{mid}/{cid}
	@GetMapping("/get/mc/{mid}/{cid}")
	public List<Schedule2> getMidCidObyWeek(@PathVariable("mid") Integer mid, @PathVariable("cid") Integer cid) {
		List<Schedule2> data = sReps.findByMidAndCidOrderByWeek(mid, cid);
		return data;
	}

	//拿上面方法的資料做修改成返回星期的純數字
	@GetMapping("/get/mc/{mid}/{cid}/weeks")
	public List<Integer> findWeekByMidAndCid(@PathVariable("mid") Integer mid, @PathVariable("cid") Integer cid) {
	    List<Schedule2> data = sReps.findByMidAndCidOrderByWeek(mid, cid);
	    List<Integer> weeks = data.stream()
	        .map(Schedule2::getWeek) // 提取 week 字段值
	        .collect(Collectors.toList());
	    
	    return weeks;
	}

	
	// 網址 http://localhost:8080/schedule2/view/mc/{mid}/{cid}
	@GetMapping("/view/mc/{mid}/{cid}")
	public ModelAndView viewMidCidObyWeek(@PathVariable("mid") Integer mid, @PathVariable("cid") Integer cid) {
		List<Schedule2> data = null;
		data = sReps.findByMidAndCidOrderByWeek(mid, cid);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule2");
		view.addObject("fc_data_1", data);
		return view;
	}

// 以會員的week活動做篩選並照課程id排序
	// 網址 http://localhost:8080/schedule2/get/{mid}/{week}
	@GetMapping("/get/mw/{mid}/{week}")
	public List<Schedule2> getMidWeekObyCid(@PathVariable("mid") Integer mid, @PathVariable("week") Integer week) {
		List<Schedule2> data = sReps.findByMidAndWeekOrderByCid(mid, week);
		return data;
	}

	// 網址 http://localhost:8080/schedule2/view/{mid}/{week}
	@GetMapping("/view/mw/{mid}/{week}")
	public ModelAndView viewMidWeekObyCid(@PathVariable("mid") Integer mid, @PathVariable("week") Integer week) {
		List<Schedule2> data = null;
		data = sReps.findByMidAndWeekOrderByCid(mid, week);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule2");
		view.addObject("fc_data_1", data);
		return view;
	}

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
	public Schedule2 addSchedule(@RequestBody Schedule2 schedule) {
		// 手動設定 ID 為 null，以便讓 JPA 生成新的 ID
		schedule.setSid(null);
		return sReps.save(schedule);
	}

	////////////// 修改/////////////////////
	// 網址 http://localhost:8080/schedule2/sid/{sid}/update
	@GetMapping("/sid/{sid}/update")
	public List<Schedule2> getSid(@PathVariable("sid") Integer sid) {
		List<Schedule2> data = sReps.findBySid(sid);
		return data;
	}

	// 網址 http://localhost:8080/schedule2/sid/{sid}/update
	@PutMapping("/sid/{sid}/update")
	public Schedule2 updateSchedule(@PathVariable("sid") Integer sid, @RequestBody Schedule2 updatedSchedule) {
		// 確保更新的 Schedule 存在
		Schedule2 existSchedule = sReps.findById(sid)
				.orElseThrow(() -> new EntityNotFoundException("喔喔!! Schedule not found with ID: " + sid));

		// 更新 Schedule 的相關欄位
		existSchedule.setSid(existSchedule.getSid());// 原資料不更動
		existSchedule.setMid(existSchedule.getMid());// 原資料不更動
		existSchedule.setCid(existSchedule.getCid());// 原資料不更動????
		existSchedule.setWeek(updatedSchedule.getWeek());

		return sReps.save(existSchedule);
	}

	////////////// 刪除//////////
	// 網址 http://localhost:8080/schedule2/sid/{sid}/delete
	@DeleteMapping("/sid/{sid}/delete")
	public void deleteSchedule(@PathVariable("sid") Integer sid) {
		// 確保要刪除的 Schedule 存在
		Schedule2 existSchedule = sReps.findById(sid)
				.orElseThrow(() -> new EntityNotFoundException("喔喔!! Schedule not found with ID: " + sid));

		sReps.delete(existSchedule);
	}
	
////新增測試資料區
	@Override
	public void run(String... args) throws Exception {
//		// M1
//		Schedule2 s1 = new Schedule2();
//		s1.setSid(null);
//		s1.setMid(1);
//		s1.setCid(1);
//		s1.setWeek(1);
//		sReps.save(s1);
//		sReps.save(new Schedule2(null, s1.getMid(), s1.getCid(), (s1.getWeek() + 2)));
//		sReps.save(new Schedule2(null, s1.getMid(), s1.getCid(), (s1.getWeek() + 4)));
//		sReps.save(new Schedule2(null, s1.getMid(), s1.getCid(), (s1.getWeek() + 5)));
//
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 1), (s1.getWeek() + 0)));
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 1), (s1.getWeek() + 2)));
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 1), (s1.getWeek() + 4)));
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 1), (s1.getWeek() + 6)));
//
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 2), (s1.getWeek() + 4)));
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 2), (s1.getWeek() + 5)));
//		sReps.save(new Schedule2(null, s1.getMid(), (s1.getCid() + 2), (s1.getWeek() + 6)));
//		// M2
//		Schedule2 s2 = new Schedule2();
//		s2.setSid(null);
//		s2.setMid(2);
//		s2.setCid(1);
//		s2.setWeek(1);
//		sReps.save(s2);
//		sReps.save(new Schedule2(null, s2.getMid(), s2.getCid(), (s2.getWeek() + 2)));
//		sReps.save(new Schedule2(null, s2.getMid(), s2.getCid(), (s2.getWeek() + 6)));
//
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 1), (s2.getWeek() + 0)));
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 1), (s2.getWeek() + 2)));
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 1), (s2.getWeek() + 3)));
//
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 2), (s2.getWeek() + 0)));
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 2), (s2.getWeek() + 1)));
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 2), (s2.getWeek() + 3)));
//		sReps.save(new Schedule2(null, s2.getMid(), (s2.getCid() + 2), (s2.getWeek() + 5)));
//		//M3
//		Schedule2 s3 = new Schedule2();
//		s3.setSid(null);
//		s3.setMid(3);
//		s3.setCid(1);
//		s3.setWeek(1);
//		sReps.save(s3);
//		sReps.save(new Schedule2(null, s3.getMid(), s3.getCid(), (s3.getWeek() + 1)));
//		sReps.save(new Schedule2(null, s3.getMid(), s3.getCid(), (s3.getWeek() + 3)));
//
//		sReps.save(new Schedule2(null, s3.getMid(), (s3.getCid() + 1), (s3.getWeek() + 0)));
//		sReps.save(new Schedule2(null, s3.getMid(), (s3.getCid() + 1), (s3.getWeek() + 3)));
//
//		sReps.save(new Schedule2(null, s3.getMid(), (s3.getCid() + 2), (s3.getWeek() + 0)));
//		sReps.save(new Schedule2(null, s3.getMid(), (s3.getCid() + 2), (s3.getWeek() + 3)));
	}

}
