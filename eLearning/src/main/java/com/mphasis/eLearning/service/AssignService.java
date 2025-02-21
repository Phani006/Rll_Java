package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Assign;
import com.mphasis.eLearning.entity.Course;
import com.mphasis.eLearning.entity.Employee;
import com.mphasis.eLearning.entity.Manager;
import com.mphasis.eLearning.entity.Team;
import com.mphasis.eLearning.repository.AssignRepository;
import com.mphasis.eLearning.repository.CourseRepository;
import com.mphasis.eLearning.repository.EmployeeRepository;
import com.mphasis.eLearning.repository.ManagerRepository;
import com.mphasis.eLearning.repository.TeamRepository;

import jakarta.transaction.Transactional;

@Service
public class AssignService implements IAssignService{

	@Autowired
	private AssignRepository assignrepository;
	@Autowired
	private TeamRepository teamrepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Assign assin(Assign assign) {
	Assign assin=assignrepository.save(assign);

	return assin;
	}

	@Override
	public List<Assign> getAll() {
	List<Assign> assignList=assignrepository.findAll();
	return assignList;
	}

	@Override
	public int getTeamId(int emloyeeId) {
	int teamid=teamrepository.getTeamId(emloyeeId);

	return teamid;
	}
	
	@Transactional
	@Override
	public Assign addAssign(int employeeId, int managerId, int courseId) {
	Assign assign=new Assign();
	Employee employee=employeeRepository.findById(employeeId).get();
	Course course=courseRepository.findById(courseId).get();
	Course c1=courseRepository.save(course);
	Manager manager=managerRepository.findById(managerId).get();
	//List<Manager> c2=managerRepository.saveAll(manager);
	int teamid=teamrepository.getTeamId(employeeId);
	Team team=teamrepository.findById(teamid).get();
//Team team2= teamrepository.save(team);
	assign.setCourseRef(c1);
	assign.setEmployeeRef(employee);
	assign.setManagerRef(manager);
	assign.setTeam(team);
	assignrepository.save(assign);

	return assign;
}

	@Override
	public Assign getAssignedEmployeeCourse(int courseId, int employeeId) {
		Assign a=assignrepository.getAssignedEmployeeCourse(courseId, employeeId);
		return a;
	}

}
