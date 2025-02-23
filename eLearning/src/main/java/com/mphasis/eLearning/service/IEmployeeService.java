package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Employee;

	public interface IEmployeeService {
		
		public List<Employee> getAllEmployees();
		public Employee addEmployees(Employee employee);
		public Employee updateEmployee(Employee employee);
		public Employee deleteEmployee(int EmployeeId);
		public Employee getEmployeeById(int EmployeeId);
		public List<Employee> getAllEmployeesByTeam(int TeamId);
		public Employee getEmployeeByUser(int userId);
		public Employee updateEmployeById(int employeeId);
		
}
