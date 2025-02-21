package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Assign;

public interface IAssignService {
	public Assign assin(Assign assign);
	public List<Assign> getAll();
	public int getTeamId(int emloyeeId);
	public Assign addAssign(int employeeId,int managerId,int courseId);
	public Assign getAssignedEmployeeCourse(int courseId, int employeeId);
}
