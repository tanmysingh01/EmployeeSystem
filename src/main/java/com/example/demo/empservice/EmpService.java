package com.example.demo.empservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.empentity.Employee;
import com.example.demo.empentity.user;
import com.example.demo.repo.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepo repo;
	
	
	public void addEmp(Employee e) {
		System.out.println("customer saved");
		repo.save(e);
	}
	
	public List<Employee> getEmp(String name) {
		return repo.findByName(name);
	}

	public List<Employee> getAll() {
		return repo.findAll();
	}
	
	public Employee getbyid(int id) {
		return repo.getById(id);
	}
	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}
	
	public List<Employee> findUserbyUsername(String username) {
		
		return repo.findByName(username);
	}
}
