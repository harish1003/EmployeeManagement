package com.demo.employeeManage.service;

import java.util.List;

import com.demo.employeeManage.Error.DataNotFoundException;
import com.demo.employeeManage.entity.Emp;
import com.demo.employeeManage.entity.Employees;

public interface EmployeeService {

	public List<Employees> getAllEmployees();

	public Employees saveEmployee(Employees employees);

	public void saveEmployee(Emp emp);

	public void deleteEmployee(Long id) throws DataNotFoundException;

	public void updateById(Emp emp);
	
	public List<Emp> getAllEmployee();

	public Emp getEmployeeById(long eMPLOYEE_ID);

}
