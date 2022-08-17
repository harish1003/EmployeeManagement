package com.demo.employeeManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.employeeManage.entity.Emp;

public interface empRepository extends JpaRepository<Emp, Long> {

	@Query(value = "SELECT * FROM EMP ORDER BY EMPLOYEE_ID ASC", nativeQuery = true)
	public List<Emp> findAllWithSort();

	@Query(value = "UPDATE emp SET EMAIL = ?1 , fIRST_NAME =?2 ,lAST_NAME=?3 where employee_id = ?4", nativeQuery = true)
	public void updateById(String EMAIL, String fIRST_NAME, String lAST_NAME, long EMPLOYEE_ID);

}
