package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mphasis.eLearning.entity.Manager;
import com.mphasis.eLearning.entity.Team;

public interface IManagerService {
	
	public List<Manager> getAllManagers();
	public Manager addManager(Manager manager);
	public Manager deleteManager(int managerId);
	public Manager getManagerById(int managerId);
	public Manager updateManager(Manager manager);
	public List<Team> getTeamByManager(int userId);
	public Integer getManagerId(int userId);

}
