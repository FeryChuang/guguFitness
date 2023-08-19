package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer>{
	
	Boolean findByUserNameAndPassword (String userName, String Password);
}