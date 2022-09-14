package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.web.project.entity.Manager;
import com.web.project.repository.ManagerRepository;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public List<Manager> getAllManagers() {
		return managerRepository.findAll();
	}

	@Override
	public void saveManager(Manager manager) {
		this.managerRepository.save(manager);
		
	}

	@Override
	public void deleteManagerById(long id) {
		this.managerRepository.deleteById(id);
		
	}

	@Override
	public Manager updateManagerById(long id) {
		Optional<Manager> optional = managerRepository.findById(id);
		Manager manager=null;
		if(optional.isPresent()) {
			manager=optional.get();
			
		}else {
			throw new RuntimeException("Employee not found for Id ::" +id);
		}
		return manager;
	}
	
	
	@Override
	public Page<Manager> findPaginate(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.managerRepository.findAll(pageable);
	}

	@Override
	public List<Manager> getCountOfManager() {

		return managerRepository.findAll();
	}
	
	public List<Manager> findByUsernameAndPassword(String username, String password) {
		List<Manager> list = managerRepository.findByUsernameAndPassword(username, password);
		return list;
	}
	
	


}
