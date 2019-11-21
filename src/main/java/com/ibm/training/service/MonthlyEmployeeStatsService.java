package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.model.EmployeeStats;
import com.ibm.training.repository.MonthlyEmployeeStatsRepository;

@Service
public class MonthlyEmployeeStatsService {
	
	@Autowired
	MonthlyEmployeeStatsRepository repo;

	public Iterable<EmployeeStats> getAllEmployees() {
		
		return repo.findAll();
	}

	public Iterable<EmployeeStats> getAllEmployeesForLastMonth(Integer month, Integer year, String project_name) {
		return repo.findByMonth(month, year, project_name);
	}

	public Iterable<EmployeeStats> getAllEmployeesByMonth(Integer month,  Integer year, String project_name) {
		return repo.findAllMonthsBeforeCurrent(month, year, project_name);
	}	

}
