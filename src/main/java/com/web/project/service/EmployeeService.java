package com.web.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.web.project.entity.Employee;
import com.web.project.entity.Prospectus;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	void deleteEmployeeById(long id);
	Employee updateEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List <Employee> getCountOfEmployee();
	List<Employee> findByUsernameAndPassword(String username, String password);
	
}
