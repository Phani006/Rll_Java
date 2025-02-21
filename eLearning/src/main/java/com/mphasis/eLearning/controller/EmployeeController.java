package com.mphasis.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Employee;
import com.mphasis.eLearning.service.IEmployeeService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/getemployee")
	public ResponseEntity<?> getEmployees() {
		List<Employee> employeeList=employeeService.getAllEmployees();
		if(!employeeList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("EmployeeList Not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<?> postEmployee(@RequestBody Employee employee) {
		Employee employeeAdded=employeeService.addEmployees(employee);
		if(employee.getEmployeeId()==employeeAdded.getEmployeeId()) {
			return new ResponseEntity<Employee>(employeeAdded,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Unable to add the employee",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateemployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		Employee employeeUpdate=employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employeeUpdate,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteemployee/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId){
		Employee employeeDeleted=employeeService.deleteEmployee(employeeId);
		if(employeeDeleted!=null) {
			return new ResponseEntity<Employee>(employeeDeleted,HttpStatus.GONE);
		}
		else {
			return new ResponseEntity<String>("Unable to Delete",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getemployee/{employeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int employeeId){
		Employee employeeFound=employeeService.getEmployeeById(employeeId);
		if(employeeFound!=null) {
			return new ResponseEntity<Employee>(employeeFound,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<String>("Unable to find the Employee",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/employeesbyteam/{teamId}")
	public ResponseEntity<?> getEmployeeByTeam(@PathVariable int teamId){
		List<Employee> employeeFound=employeeService.getAllEmployeesByTeam(teamId);
		if(!employeeFound.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employeeFound,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Unable to find the Employees",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getemployeebyuser/{userId}")
	public ResponseEntity<?> getEmployeeByUser(@PathVariable int userId){
		Employee employee=employeeService.getEmployeeByUser(userId);
		if(employee!=null) {
			return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Unable to find Employee",HttpStatus.BAD_REQUEST);
		}
	}
}
