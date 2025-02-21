package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Manager;
import com.mphasis.eLearning.entity.Team;
import com.mphasis.eLearning.repository.ManagerRepository;
import com.mphasis.eLearning.repository.TeamRepository;


@Service
public class ManagerService implements IManagerService{
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public List<Manager> getAllManagers() {
		List<Manager> managersList=managerRepository.findAll();
		return managersList;
	}

	@Override
	public Manager addManager(Manager manager) {
		Manager savedManager=managerRepository.save(manager);
		return savedManager;
	}

	@Override
	public Manager deleteManager(int managerId) {
		Manager manager=null;
		if(managerRepository.existsById(managerId)) {
			manager=managerRepository.findById(managerId).get();
			managerRepository.deleteById(managerId);
			
		}
		
		return manager;
	}

	@Override
	public Manager getManagerById(int managerId) {
		Manager manager=null;
		if(managerRepository.existsById(managerId)) {
			manager=managerRepository.findById(managerId).get();
		}
		return manager;
	}

	@Override
	public Manager updateManager(Manager manager) {
		Manager updateManager=managerRepository.save(manager);
		return updateManager;
	}

	@Override
	public List<Team> getTeamByManager(int userId) {
		List<Team> teamsByManager=teamRepository.getTeamByManager(userId);
		return teamsByManager;
	}

	@Override
	public Integer getManagerId(int userId) {
		Integer managerId=managerRepository.getManagerId(userId);
		return managerId;
	}

}
