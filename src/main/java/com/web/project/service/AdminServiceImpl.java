package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Admin;
import com.web.project.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public void saveAdmin(Admin admin) {
		this.adminRepository.save(admin);
		
	}

	@Override
	public void deleteAdminById(long id) {
		this.adminRepository.deleteById(id);
		
	}

	@Override
	public Admin updateAdminById(long id) {
		Optional<Admin> optional = adminRepository.findById(id);
		Admin admin=null;
		if(optional.isPresent()) {
			admin=optional.get();
			
		}else {
			throw new RuntimeException("Admin not found for Id ::" +id);
		}
		return admin;
	}
	
	@Override
	public List<Admin> getCountOfAdmin() {

		return adminRepository.findAll();
	}
	
	public List<Admin> findByUsernameAndPassword(String username, String password) {
		List<Admin> list = adminRepository.findByUsernameAndPassword(username, password);
		return list;
	}

}
