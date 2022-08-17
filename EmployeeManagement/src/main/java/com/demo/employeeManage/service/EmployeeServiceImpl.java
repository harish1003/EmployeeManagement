package com.demo.employeeManage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.employeeManage.entity.Emp;
import com.demo.employeeManage.entity.Employees;
import com.demo.employeeManage.repository.EmployeeRepository;
import com.demo.employeeManage.repository.empRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private empRepository empRepository;

	@Override
	public List<Emp> getAllEmployee() {
		return empRepository.findAllWithSort();
	}

	@Override
	public List<Employees> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employees saveEmployee(Employees employees) {
		return employeeRepository.save(employees);
	}

	@Override
	public void saveEmployee(Emp emp) {
		empRepository.save(emp);

	}

	@Override
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);

	}

	@Override
	public void updateById(Emp emp) {
		System.out.println(emp.EMAIL);
		try {
			empRepository.updateById(emp.EMAIL, emp.FIRST_NAME, emp.LAST_NAME, emp.EMPLOYEE_ID);
		} catch (Exception e) {}

	}

	@Override
	public Emp getEmployeeById(long eMPLOYEE_ID) {
		Optional<Emp> emp = empRepository.findById(eMPLOYEE_ID);
		return emp.get();
	}

}
