package com.example.demo.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Chick;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleRepository;

@RestController
@RequestMapping("/schedule") // 網址 http://localhost:8080/schedule
public class ScheduleController implements CommandLineRunner{

	@Autowired
	ScheduleRepository sReps;

///////測試用資料///////
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Schedule s1 = new Schedule();
		s1.setSid(null);
		s1.setMid(1);
		s1.setCid(1);
		s1.setRedate(LocalDate.parse("2023-08-21"));
		s1.setStatus("wait");
		s1.setSort(1);
		s1.setSname("測試用排程");
		s1.setStartime(null);
		s1.setEndtime(null);
		sReps.save(s1);
		sReps.save(new Schedule(null, s1.getMid(), (s1.getCid()+1), s1.getRedate(), s1.getStatus(), (s1.getSort()+1), s1.getSname(), null, null ));
		sReps.save(new Schedule(null, s1.getMid(), (s1.getCid()+2), s1.getRedate(), s1.getStatus(), (s1.getSort()+3), s1.getSname(), null, null ));
		sReps.save(new Schedule(null, s1.getMid(), (s1.getCid()+3), s1.getRedate(), s1.getStatus(), (s1.getSort()+4), s1.getSname(), null, null ));
		sReps.save(new Schedule(null, (s1.getMid()+1), (s1.getCid()+4), s1.getRedate(), s1.getStatus(), (s1.getSort()+0), (s1.getSname()+"2"), null, null ));
		sReps.save(new Schedule(null, (s1.getMid()+1), (s1.getCid()+2), s1.getRedate(), s1.getStatus(), (s1.getSort()+2), (s1.getSname()+"2"), null, null ));
		sReps.save(new Schedule(null, (s1.getMid()+1), (s1.getCid()+0), s1.getRedate(), s1.getStatus(), (s1.getSort()+1), (s1.getSname()+"2"), null, null ));
	}
//取得資料
	// 取得所有排程
	// Json格式
	//網址 http://localhost:8080/schedule/get/all
	@GetMapping(value = "/get/all")
	public List<Schedule> getAllSchedule() {
		List<Schedule> data = sReps.findAll();
		return data;
	}

	// View
	//網址 http://localhost:8080/schedule/view/all
	@GetMapping(value = "/view/all")
	public ModelAndView getAllScheduleView() {
		List<Schedule> data = null;
		data = sReps.findAll(); // 到此data已被讀取為Json
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}

	// 以會員列出所有排程
	//網址 http://localhost:8080/schedule/get/{mid}
	@GetMapping("/get/{mid}")
	public List<Schedule> getMidObySname(@PathVariable("mid") Integer mid) {
		List<Schedule> data = sReps.findByMidOrderBySname(mid);
		return data;
	}
	//網址 http://localhost:8080/schedule/view/{mid}
	@GetMapping("/view/{mid}")
	public ModelAndView viewMidObySname(@PathVariable("mid") Integer mid) {
		List<Schedule> data = null;
		data = sReps.findByMidOrderBySname(mid);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}

	// 以會員的排程名稱做篩選並照sort排序
	//網址 http://localhost:8080/schedule/get/{mid}/{sname}
	@GetMapping("/get/{mid}/{sname}")
	public List<Schedule> getMidSnameObySort(@PathVariable Integer mid, @PathVariable("sname") String sname) {
		List<Schedule> data = sReps.findByMidAndSnameOrderBySort(mid, sname);
		return data;
	}
	//網址 http://localhost:8080/schedule/view/{mid}/{sname}
	@GetMapping("/view/{mid}/{sname}")
	public ModelAndView viewMidSnameObySort(@PathVariable Integer mid, @PathVariable("sname") String sname) {
		List<Schedule> data = null;
		data = sReps.findByMidAndSnameOrderBySort(mid, sname);
		ModelAndView view = new ModelAndView("/schedule/viewSchedule");
		view.addObject("fc_data_1", data);
		return view;
	}

	// 以redate查詢
	//網址 http://localhost:8080/schedule/get/date/{redate}
	@GetMapping("/get/date/{redate}")
	public List<Schedule> getRedate(@PathVariable("redate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date redate) {
		List<Schedule> data = sReps.findByRedate(redate);
		return data;
	}

	// 以redate查詢依據sname與sort排序
	//網址 http://localhost:8080/schedule/get/date/sort/{redate}
	@GetMapping("/get/date/sort/{redate}")
	public List<Schedule> getRedateObySname(
			@PathVariable("redate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date redate) {
		List<Schedule> data = sReps.findByRedateOrderBySnameAscSortAsc(redate);
		return data;
	}

///////////////新增功能//////////////////
//	{
//        "sid": 1,
//        "mid": 1,
//        "cid": 1,
//        "redate": "2023-06-30T16:00:00.000+00:00",
//        "status": "wait",
//        "sort": 3,
//        "sname": "AAA",
//        "startime": null,
//        "endtime": null
//    }
	//網址 http://localhost:8080/schedule/add
	@PostMapping("/add")
	public Schedule addSchedule(@RequestBody Schedule schedule) {
		// 手動設定 ID 為 null，以便讓 JPA 生成新的 ID
		schedule.setSid(null);
		return sReps.save(schedule);
	}

//////////////修改/////////////////////
	// 網址 http://localhost:8080/schedule/sid/{sid}
	@GetMapping("/sid/{sid}")
	public List<Schedule> getSidObySort(@PathVariable("sid") Integer sid) {
		List<Schedule> data = sReps.findBySidOrderBySort(sid);
		return data;
	}
	// 網址 http://localhost:8080/schedule/sid/{sid}/update
	@PutMapping("/sid/{sid}/update")
	public Schedule updateSchedule(@PathVariable Integer sid, @RequestBody Schedule updatedSchedule) {
		// 確保更新的 Schedule 存在
		Schedule existSchedule = sReps.findById(sid)
				.orElseThrow(() -> new EntityNotFoundException("喔喔!! Schedule not found with ID: " + sid));

		// 更新 Schedule 的相關欄位
		existSchedule.setSid(existSchedule.getSid());//原資料不更動
		existSchedule.setMid(existSchedule.getMid());//原資料不更動
		existSchedule.setCid(existSchedule.getCid());//原資料不更動
		existSchedule.setRedate(updatedSchedule.getRedate());
		existSchedule.setStatus(updatedSchedule.getStatus());
		existSchedule.setSort(updatedSchedule.getSort());
		existSchedule.setSname(updatedSchedule.getSname());
		existSchedule.setStartime(updatedSchedule.getStartime());
		existSchedule.setEndtime(updatedSchedule.getEndtime());

		return sReps.save(existSchedule);
	}

//////////////刪除//////////
	// 網址 http://localhost:8080/schedule/sid/{sid}/delete
	@DeleteMapping("/sid/{sid}/delete")
	public void deleteSchedule(@PathVariable Integer sid) {
		// 確保要刪除的 Schedule 存在
		Schedule existSchedule = sReps.findById(sid)
				.orElseThrow(() -> new EntityNotFoundException("喔喔!! Schedule not found with ID: " + sid));

		sReps.delete(existSchedule);
	}



//待處理:
//以redate查詢???
//	→ SELECT * FROM workout.schedule WHERE redate = '2023-07-01' ORDER BY schedule_name ASC;
//	→ Date資料處理與讀取?????
//mid改對應到username??
}
