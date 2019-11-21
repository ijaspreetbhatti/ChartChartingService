package com.ibm.training.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.training.model.EmployeeStats;



@Repository
public interface MonthlyEmployeeStatsRepository extends CrudRepository<EmployeeStats, Integer>{

	@Query(value = "select * from employee_stats where month=:month and year=:year and project_name=:project_name" ,nativeQuery = true)
	Iterable<EmployeeStats> findByMonth(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "project_name") String project_name);

	@Query(value = "select * from employee_stats where month<:month and month>((:month)-6) and year=:year and project_name=:project_name order by month desc", nativeQuery = true)
	Iterable<EmployeeStats> findAllMonthsBeforeCurrent(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "project_name") String project_name);

}
