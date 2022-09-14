package com.web.project.service;

import java.util.List;

import com.web.project.entity.Leave;

public interface LeaveService {
	List<Leave> getAllLeave();
	void saveLeave(Leave leave);
	void deleteLeaveById(long id);
	Leave updateLeaveById(long id);

}
