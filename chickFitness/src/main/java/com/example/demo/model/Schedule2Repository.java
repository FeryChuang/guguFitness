package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Schedule2Repository extends JpaRepository<Schedule2, Integer> {
// 以會員做篩選並照week排序
	List<Schedule2> findByMidOrderByWeek(Integer mid);
// 以會員的課程做篩選並照week排序
	List<Schedule2> findByMidAndCidOrderByWeek(Integer mid, Integer cid);
// 以會員的week活動做篩選並照課程id排序
	List<Schedule2> findByMidAndWeekOrderByCid(Integer mid, Integer week);
// 以排程ID查詢
	List<Schedule2> findBySid(Integer sid);

}
