package com.web.project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.web.project.entity.Employee;
import com.web.project.repository.EmployeeRepository;
@Service
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
			
		}else {
			throw new RuntimeException("Employee not found for Id ::" +id);
		}
		return employee;
	}
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}


	@Override
	public List<Employee> getCountOfEmployee() {

		return employeeRepository.findAll();
	}
	
	public List<Employee> findByUsernameAndPassword(String username, String password) {
		List<Employee> list = employeeRepository.findByUsernameAndPassword(username, password);
		return list;
	}

}
