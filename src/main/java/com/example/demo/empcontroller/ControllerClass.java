package com.example.demo.empcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.empentity.Employee;

import com.example.demo.empservice.EmpService;

@Controller
public class ControllerClass {

	@Autowired
	EmpService service = new EmpService();

	@RequestMapping("/")
	public String home() {
		System.out.println("This is the homepage");
		return "index.html";
	}

	@GetMapping("/elist")

	public String getList(Model m) {

		List<Employee> emp = service.getAll();
		m.addAttribute("emp", emp);
		return "elist.html";
	}

	@RequestMapping("/register")
	public String addForm() {
		return "Register.html";
	}

	@PostMapping("/addemp")
	public String addeEmp(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		
		  service.addEmp(e);
		  
		  session.setAttribute("msg", "Employee has been added Successfully!!");
		  System.out.println(e); return "redirect:/elist";
		 
	}

	@RequestMapping("/search")
	public String searchEmp() {
		return "search.html";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {

		Employee e = service.getbyid(id);
		m.addAttribute("emp", e);
		return "edit.html";

	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		service.addEmp(e);

		session.setAttribute("msg", "Employee has been updated Successfully!!");
		System.out.println(e);
		return "redirect:/elist";
	}

	@PostMapping("/details")
	public String getdetails(@RequestParam int id, Model m) {
		Employee e = service.getbyid(id);
		m.addAttribute("emp", e);
		return "details.html";

	}

	
	/*
	 * @GetMapping("/delete") public String deleteEmp(@ModelAttribute Employee e,
	 * HttpSession session) {
	 * 
	 * service.deleteEmployee(e.getId());
	 * 
	 * session.setAttribute("msg", "Employee has been deleted Successfully!!");
	 * System.out.println(e); return "redirect:/elist"; }
	 */
	@GetMapping("/delete/{id}") 
	  public String deleteEmp(@PathVariable int id , HttpSession session) {
	  
	  service.deleteEmployee(id);
	  
	  session.setAttribute("msg", "Employee has been deleted Successfully!!");
	   
	  return "redirect:/elist"; }
	
	
	
	@RequestMapping("/login")
		
	public String login() {
		return "login.html";
	}
	
	/*
	 * @PostMapping("/logine") public String logindo(@ModelAttribute User u,
	 * HttpSession session) { System.out.println(u); session.setAttribute("msg",
	 * "Employee has been added Successfully!!"); return "redirect:/elist";
	 * 
	 * }
	 */
	
	 

}
