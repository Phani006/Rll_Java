package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	
	@Query(value = "select t.manager_ref_manager_id,t.team_id,t.team_name from team t "
			+ "left join manager m on t.manager_ref_manager_id=m.manager_id "
			+ "right join user u on  u.user_id=m.user_ref_user_id where u.user_id=:userId",nativeQuery = true)
	public List<Team> getTeamByManager(@Param("userId")int userId);
	
	@Query(value="select t.team_id from team t inner join team_employee_list te on t.team_id=te.team_team_id "
			+ "inner join employee e on te.employee_list_employee_id=e.employee_id where employee_id=:employeeId",nativeQuery = true)
	public int  getTeamId(@Param("employeeId") int employeeId);

}
