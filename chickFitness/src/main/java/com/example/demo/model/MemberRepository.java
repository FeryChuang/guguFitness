package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer>{
	
	Member findByUserNameAndPassword (String userName, String Password);
	
	List<Member> findAll();
}
