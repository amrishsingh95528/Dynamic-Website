package com.web.project.service;

import java.util.List;

import com.web.project.entity.Fees;

public interface FeesService {
	List<Fees> getAllFees();
	void saveFees(Fees fees);
	void deleteFeesById(long id);
	Fees updateFeesById(long id);
	List <Fees> getCountOfFees();

}
