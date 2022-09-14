package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Prospectus;
import com.web.project.repository.ProspectusRepository;
@Service
public class ProspectusServiceImpl implements ProspectusService {
	
	@Autowired
	private ProspectusRepository prospectusRepository;

	@Override
	public List<Prospectus> getAllProspectus() {
		return prospectusRepository.findAll();
	}

	@Override
	public void saveProspectus(Prospectus prospectus) {
		this.prospectusRepository.save(prospectus);

	}

	@Override
	public void deleteProspectusById(long id) {
		this.prospectusRepository.deleteById(id);

	}

	@Override
	public Prospectus updateProspectusById(long id) {
		Optional<Prospectus> optional = prospectusRepository.findById(id);
		Prospectus prospectus=null;
		if(optional.isPresent()) {
			prospectus=optional.get();
			
		}else {
			throw new RuntimeException("Prospectus not found for Id ::" +id);
		}
		return prospectus;
	}

	@Override
	public List<Prospectus> getProspectusCount() {
		return prospectusRepository.findAll();
	}
	}

