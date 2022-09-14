package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.TTable;
import com.web.project.repository.TTableRepository;
@Service
public class TTableServiceImpl implements TTableService {
	
	@Autowired
	private TTableRepository TTableRepository;

	@Override
	public List<TTable> getAllTTable() {
		return TTableRepository.findAll();
	}

	@Override
	public void saveTTable(TTable TTable) {
		this.TTableRepository.save(TTable);

	}

	@Override
	public void deleteTTableById(long id) {
		this.TTableRepository.deleteById(id);

	}

	@Override
	public TTable updateTTableById(long id) {
		Optional<TTable> optional = TTableRepository.findById(id);
		TTable TTable=null;
		if(optional.isPresent()) {
			TTable=optional.get();
			
		}else {
			throw new RuntimeException("TTable not found for Id ::" +id);
		}
		return TTable;
	}

	@Override
	public List<TTable> getAllTTableCount() {
		
		return TTableRepository.findAll();
	}
	}

