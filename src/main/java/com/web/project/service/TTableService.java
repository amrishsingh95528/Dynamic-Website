package com.web.project.service;

import java.util.List;

import com.web.project.entity.TTable;

public interface TTableService {
	
	List<TTable> getAllTTable();
	void saveTTable(TTable TTable);
	void deleteTTableById(long id);
	TTable updateTTableById(long id);
	List<TTable> getAllTTableCount();

}
