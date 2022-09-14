package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Fees;
import com.web.project.repository.FeesRepository;
@Service
public class FeesServiceImpl implements FeesService{
	@Autowired
	private FeesRepository feesRepository;

	@Override
	public List<Fees> getAllFees() {
		return feesRepository.findAll();
	}

	@Override
	public void saveFees(Fees fees) {
		this.feesRepository.save(fees);
		
	}

	@Override
	public void deleteFeesById(long id) {
		this.feesRepository.deleteById(id);
		
	}

	@Override
	public Fees updateFeesById(long id) {
		Optional<Fees> optional = feesRepository.findById(id);
		Fees fees=null;
		if(optional.isPresent()) {
			fees=optional.get();
			
		}else {
			throw new RuntimeException("Fees not found for Id ::" +id);
		}
		return fees;
	}
	
	@Override
	public List<Fees> getCountOfFees() {

		return feesRepository.findAll();
	}
	
	
}
