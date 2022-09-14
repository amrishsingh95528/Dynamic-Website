package com.web.project.service;

import java.util.List;

import com.web.project.entity.Help;

public interface HelpService {
	List<Help> getAllHelp();
	void saveHelp(Help help);
	Help updateHelpById(long id);

}
