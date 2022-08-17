package com.demo.employeeManage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.employeeManage.entity.Emp;
import com.demo.employeeManage.entity.Employees;
import com.demo.employeeManage.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav1 = new ModelAndView("home");
		List<Emp> emp1 = employeeService.getAllEmployee();
		mav1.addObject("emp", emp1);
		return mav1;
	}

	@GetMapping("/getAll")
	public ModelAndView getOldAllEmployee() {
		ModelAndView mav = new ModelAndView("getAllEmp");
		List<Employees> emp = employeeService.getAllEmployees();
		mav.addObject("e", emp);
		return mav;
	}

	@GetMapping("/addEmployee")
	public ModelAndView addEmployee() {
		ModelAndView mav = new ModelAndView("newEmployee");
		Emp emp = new Emp();
		mav.addObject("emp", emp);
		return mav;
	}

	@PostMapping("/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute("emp") Emp emp) {
		employeeService.saveEmployee(emp);
		return homePage();
	}

	@GetMapping("/getdeleteEmployeeId")
	public ModelAndView getdeleteEmployeeId() {
		ModelAndView mav = new ModelAndView("deleteEmp");
		Emp emp = new Emp();
		mav.addObject("emp", emp);
		return mav;
	}

	@PostMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@ModelAttribute("emp") Emp emp) {
		try {
			employeeService.deleteEmployee(emp.EMPLOYEE_ID);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return homePage();
	}

	@GetMapping("/getIdUpdateEmployee")
	public ModelAndView getIdUpdateEmployee() {
		ModelAndView mav = new ModelAndView("updateEmp");
		Emp emp = new Emp();
		mav.addObject("emp", emp);
		return mav;
	}

	@PostMapping("/updateEmployee")
	public ModelAndView updateEmployee(@ModelAttribute("emp") Emp emp) {
		ModelAndView mav = new ModelAndView("updateEmpForm");
		Emp emp2 = employeeService.getEmployeeById(emp.EMPLOYEE_ID);
		mav.addObject("emp", emp2);
		return mav;
	}

	@PostMapping("/doUpdate")
	public ModelAndView doUpdate(@ModelAttribute("emp") Emp emp) {
		employeeService.updateById(emp);
		return homePage();
	}

}
