package com.web.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByUsernameAndPassword(String username, String password);

}
