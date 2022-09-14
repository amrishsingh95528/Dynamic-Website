package com.web.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Help;
import com.web.project.repository.HelpRepository;
@Service
public class HelpServiceImpl implements HelpService {

	@Autowired
	private HelpRepository helpRepository;

	@Override
	public List<Help> getAllHelp() {
		return helpRepository.findAll();
	}

	@Override
	public void saveHelp(Help help) {
		this.helpRepository.save(help);
		
	}


	@Override
	public Help updateHelpById(long id) {
		Optional<Help> optional = helpRepository.findById(id);
		Help help=null;
		if(optional.isPresent()) {
			help=optional.get();
			
		}else {
			throw new RuntimeException("Help Desk not found for Id ::" +id);
		}
		return help;
	}
}
