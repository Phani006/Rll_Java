package com.mphasis.eLearning.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Employee;
import com.mphasis.eLearning.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList=employeeRepository.findAll();
		return empList;
	}

	@Override
	public Employee addEmployees(Employee employee) {
		Employee savedEmployee=employeeRepository.save(employee);
		return savedEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee=employeeRepository.save(employee);
		return updatedEmployee;
	}

	@Override
	public Employee deleteEmployee(int EmployeeId) {
		Employee emp=null;
		if(employeeRepository.existsById(EmployeeId)) {
			emp=employeeRepository.findById(EmployeeId).get();
			employeeRepository.deleteById(EmployeeId);
		};
		return emp;
	}

	@Override
	public Employee getEmployeeById(int EmployeeId) {
		Employee employee=null;
		if(employeeRepository.existsById(EmployeeId)) {
			employee=employeeRepository.findById(EmployeeId).get();
		};
		return employee;
	}

	@Override
	public List<Employee> getAllEmployeesByTeam(int TeamId) {
		List<Employee> employeesByTeam=employeeRepository.getEmployeeByTeamId(TeamId);
		return employeesByTeam;
	}

	@Override
	public Employee getEmployeeByUser(int userId) {
		Employee employee=employeeRepository.getEmployeeByUser(userId);
		return employee;
	}

}
