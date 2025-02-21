package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Manager;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer>{
	
	@Query(value = "select manager_id from manager where user_ref_user_id=:userId",nativeQuery = true)
	public Integer getManagerId(@Param("userId") int userId);
	
	@Query(value="select m.manager_id,m.manager_contact,m.managername,m.user_ref_user_id from manager m join assign_manager_ref am on m.manager_id=am.manager_ref_manager_id join assign a on am.assign_assign_id=a.assign_id \r\n"
			+ " where m.manager_id=:managerId",nativeQuery = true)
	public List<Manager> getAllManagers(@Param("managerId") int managerId);

}
