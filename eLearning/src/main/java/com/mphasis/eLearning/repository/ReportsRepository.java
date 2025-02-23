package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Reports;

import io.swagger.v3.oas.annotations.Parameter;

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
	
	@Query(value = "select * from reports r join course c on r.course_ref_course_id=c.course_id where r.employee_ref_employee_id=:employeeId", nativeQuery = true)
	public List<Reports> getReportsForEmployee(@Param("employeeId") int employeeId);
	
	@Query(value="SELECT COUNT(DISTINCT r.quiz_id) \r\n"
			+ "FROM reports r \r\n"
			+ "WHERE r.quiz_id IN (\r\n"
			+ "    SELECT q.quiz_id \r\n"
			+ "    FROM course c\r\n"
			+ "    JOIN course_module_list cm ON c.course_id = cm.course_course_id \r\n"
			+ "    JOIN modules m ON cm.module_list_module_id = m.module_id \r\n"
			+ "    JOIN quiz q ON m.quiz_ref_quiz_id = q.quiz_id \r\n"
			+ "    WHERE c.course_id = :courseid\r\n"
			+ ") \r\n"
			+ "AND r.employee_ref_employee_id = :employeeId;\r\n"
			+ "",nativeQuery = true)
	public int countOfQuizIdByReports(@Param("courseid") int courseId, @Param("employeeId")int employeeId);
	@Query(value ="SELECT AVG(r.progress) \r\n"
			+ "FROM reports r \r\n"
			+ "WHERE r.quiz_id IN (\r\n"
			+ "    SELECT q.quiz_id \r\n"
			+ "    FROM course c "
			+ "    JOIN course_module_list cm ON c.course_id = cm.course_course_id "
			+ "    JOIN modules m ON cm.module_list_module_id = m.module_id  "
			+ "    JOIN quiz q ON m.quiz_ref_quiz_id = q.quiz_id "
			+ "    WHERE c.course_id = :courseId and r.employee_ref_employee_id=:employeeId"
			+ ");\r\n"
			+ "",nativeQuery = true)
	public double getProgressByCourseId(@Param("courseId")int courseId,@Param("employeeId") int employeeId);
	
	@Query(value = "select count(distinct(q.quiz_id)) from course c join course_module_list cm on c.course_id=cm.course_course_id  join modules m on cm.module_list_module_id=m.module_id  "
			+ "join quiz q on  m.quiz_ref_quiz_id=q.quiz_id  where c.course_id=:courseid ",nativeQuery = true)
	public int getCountOfmoduleQuizzes(@Param("courseid")int courseid);
	
	@Query(value="select r.report_id,r.progress,r.quiz_id,r.quiz_score,r.course_ref_course_id,r.employee_ref_employee_id from reports r  join course c on r.course_ref_course_id=c.course_id  join course_instructor_ref cr on c.course_id=cr.course_course_id where cr.instructor_ref_instructor_id=:instructorid",nativeQuery = true)
	public List<Reports> getReportsByInstructorId(@Param("instructorid")int instructorId);


}
