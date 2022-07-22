package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.empentity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

	
	List<Employee> findByName(String name);
}
