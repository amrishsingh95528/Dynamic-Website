package com.web.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.web.project.entity.Manager;

public interface ManagerService {
	List<Manager> getAllManagers();
	void saveManager(Manager manager);
	void deleteManagerById(long id);
	Manager updateManagerById(long id);
	Page<Manager> findPaginate(int pageNo, int pageSize, String sortField, String sortDirection);	
	List <Manager> getCountOfManager();
	List<Manager> findByUsernameAndPassword(String username, String password);

}
