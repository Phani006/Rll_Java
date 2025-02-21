package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Assign;
import com.mphasis.eLearning.entity.Manager;
@Repository
public interface AssignRepository extends JpaRepository<Assign, Integer> {
	
	@Query(value = "select * from assign where course_ref_course_id=:courseId and employee_ref_employee_id=:employeeId",nativeQuery = true)
	public Assign getAssignedEmployeeCourse(@Param("courseId")int courseId,@Param("employeeId")int employeeId);

}
