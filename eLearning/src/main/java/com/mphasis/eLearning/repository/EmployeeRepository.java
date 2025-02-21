package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mphasis.eLearning.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select e.employee_id,e.user_ref_user_id,e.employee_contact,e.employee_name,e.course_list_course_id,e.manager_ref_manager_id,e.team_ref_team_id from employee e "
			+ "join team_employee_list t on e.employee_id=t.employee_list_employee_id where t.team_team_id=:teamId",nativeQuery = true)
	public List<Employee> getEmployeeByTeamId(@Param("teamId") int TeamId);
	
	@Query(value="select * from employee e where e.user_ref_user_id=:userId",nativeQuery = true)
	public Employee getEmployeeByUser(@Param("userId") int userId);

}
