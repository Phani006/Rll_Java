package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Reports;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Integer>{
	
	@Query(value = "SELECT r.report_id, r.progress, r.quiz_id, r.quiz_score, r.course_ref_course_id, r.employee_ref_employee_id, e.employee_name " +
            "FROM reports r " +
            "JOIN employee e ON r.employee_ref_employee_id = e.employee_id " +
            "JOIN team_employee_list te ON e.employee_id = te.employee_list_employee_id " +
            "JOIN team t ON te.team_team_id = t.team_id " +
            "JOIN manager m ON t.manager_ref_manager_id = m.manager_id " +
            "WHERE m.manager_id = :managerId", nativeQuery = true)
	public List<Reports> getReportByManager(@Param("managerId") int managerId);

}
