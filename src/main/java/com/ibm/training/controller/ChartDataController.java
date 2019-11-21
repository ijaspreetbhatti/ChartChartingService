package com.ibm.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.model.EmployeeStats;
import com.ibm.training.model.ProjectStats;
import com.ibm.training.service.MonthlyEmployeeStatsService;
import com.ibm.training.service.MonthlyProjectStatsService;




@CrossOrigin(origins = "http://localhost:*")
@RestController
public class ChartDataController {
	
	@Autowired
	MonthlyEmployeeStatsService e_service;
	
	@Autowired
	MonthlyProjectStatsService p_service;
	
	@RequestMapping("/employees")
	Iterable<EmployeeStats> getAllEmployees()
	{
		return e_service.getAllEmployees();
	}
	
	@RequestMapping("/employees/lastmonth/{month}/{year}/{project_name}")
	Iterable<EmployeeStats> getAllEmployeesForLastMonth(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name)
	{
		return e_service.getAllEmployeesForLastMonth(month, year, project_name);
	}
	
	@RequestMapping("/employees/{month}/{year}/{project_name}")
	Iterable<EmployeeStats> getAllEmployeesByMonth(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name)
	{
		return e_service.getAllEmployeesByMonth(month, year, project_name);
	}

	@RequestMapping("/projects/{month}/{year}/{project_name}")
	Iterable<ProjectStats> getAllMonthsBeforeCurrent(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name){
		return p_service.getAllMonthsBeforeCurrent(month, year, project_name);
	}
}
