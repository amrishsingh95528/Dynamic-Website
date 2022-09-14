package com.web.project.service;

import java.util.List;

import com.web.project.entity.Prospectus;

public interface ProspectusService {
	
	List<Prospectus> getAllProspectus();
	void saveProspectus(Prospectus prospectus);
	void deleteProspectusById(long id);
	Prospectus updateProspectusById(long id);
	List<Prospectus> getProspectusCount();

}
