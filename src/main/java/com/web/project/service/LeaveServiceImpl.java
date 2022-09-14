package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Leave;
import com.web.project.repository.LeaveRepository;
@Service
public class LeaveServiceImpl implements LeaveService{
	
	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public List<Leave> getAllLeave() {
		return leaveRepository.findAll();
	}

	@Override
	public void saveLeave(Leave leave) {
		this.leaveRepository.save(leave);
		
	}

	@Override
	public void deleteLeaveById(long id) {
		this.leaveRepository.deleteById(id);
		
	}

	@Override
	public Leave updateLeaveById(long id) {
		Optional<Leave> optional = leaveRepository.findById(id);
		Leave leave=null;
		if(optional.isPresent()) {
			leave=optional.get();
			
		}else {
			throw new RuntimeException("Leave not found for Id ::" +id);
		}
		return leave;
	}

}
