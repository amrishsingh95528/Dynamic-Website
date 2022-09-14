package com.web.project.service;

import java.util.List;

import com.web.project.entity.Admin;

public interface AdminService {
	List<Admin> getAllAdmin();
	void saveAdmin(Admin admin);
	void deleteAdminById(long id);
	Admin updateAdminById(long id);
	List <Admin> getCountOfAdmin();
	List<Admin> findByUsernameAndPassword(String username, String password);
}
