package com.ibm.training.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.training.model.ProjectStats;

@Repository
public interface MonthlyProjectStatsRepository extends CrudRepository<ProjectStats, Integer> {
	
	@Query(value = "select * from project_stats where month<:month and month>((:month)-6) and year=:year and project_name=:project_name order by month desc", nativeQuery = true)
	Iterable<ProjectStats> findAllProjectsBeforeMonth(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "project_name") String project_name);

}
