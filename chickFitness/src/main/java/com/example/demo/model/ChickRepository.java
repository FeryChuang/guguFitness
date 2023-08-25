package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChickRepository extends JpaRepository<Chick,Integer>{

	 List<Chick> findByMemberId(Integer memberId);
	 
	 void deleteByMemberId(Integer memberId);

}
