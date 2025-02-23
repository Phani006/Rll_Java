package com.mphasis.eLearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Employee;
import com.mphasis.eLearning.entity.Manager;
import com.mphasis.eLearning.entity.Team;
import com.mphasis.eLearning.repository.ManagerRepository;
import com.mphasis.eLearning.repository.TeamRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class TeamService implements ITeamService {
@Autowired
private TeamRepository teamrepository;

@Autowired
private EntityManager entityManager;

@Autowired
private ManagerRepository managerRepository;

	@Override
	public List<Team> getAllTeams() {
		List<Team> teamList=teamrepository.findAll();
		return teamList;
	}

	@Override
	public Team getTeamByTeamId(int teamId) {
		Team team=teamrepository.findById(teamId).get();
		return team;
	}
	
	@Transactional
	@Override
	public Team addTeam(Team team) {
		Manager manager = team.getManagerRef();  
		List<Employee> employee=team.getEmployeeList();
		manager = entityManager.merge(manager);
		team.setManagerRef(manager);
		List<Employee> managedEmployees = new ArrayList<>();
		    for (Employee emp : employee) {
		        Employee managedEmp = entityManager.merge(emp);
		        managedEmployees.add(managedEmp);
		    }
		    team.setEmployeeList(managedEmployees);
		Team t=teamrepository.save(team);
		return t;
	}

	@Override
	public Team DeleteTeamById(int id) {
		Team team=null;
		if(teamrepository.existsById(id)) {
			team=teamrepository.findById(id).get();
			teamrepository.delete(team);
		}
		return team;
	}

	@Override
	public Team updateTeam(Team team) {
		Team t=teamrepository.save(team);
		return t;
	}

	

}

