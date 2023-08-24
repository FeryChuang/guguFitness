package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Schedule3Repository extends JpaRepository<Schedule3, Integer> {

// 以排程ID查詢
	List<Schedule3> findBySid(Integer sid);

	Schedule3 findByMidAndCid(Integer mid, Integer cid);

	List<Schedule3> findByMid(Integer mid);

}
