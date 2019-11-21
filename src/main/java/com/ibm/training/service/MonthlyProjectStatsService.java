package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.model.ProjectStats;
import com.ibm.training.repository.MonthlyProjectStatsRepository;

@Service
public class MonthlyProjectStatsService {
	
	@Autowired
	MonthlyProjectStatsRepository repo;
	
	public Iterable<ProjectStats> getAllMonthsBeforeCurrent(Integer month, Integer year, String project_name){
		return repo.findAllProjectsBeforeMonth(month, year, project_name);
	}

}
