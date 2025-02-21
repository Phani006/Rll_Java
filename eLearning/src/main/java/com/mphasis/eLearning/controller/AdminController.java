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

import com.mphasis.eLearning.entity.Admin;
import com.mphasis.eLearning.service.AdminService;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	@GetMapping("/getadmin")
	public ResponseEntity<?> getAllAdmin(){
		List<Admin> adminList=adminservice.getAllAdmins();
		if(adminList!=null) {
			return new ResponseEntity<List<Admin>>(adminList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no Admins are present",HttpStatus.BAD_REQUEST);

		}
	}
	@PostMapping("/addadmin")
	public ResponseEntity<?> AddAdmin(@RequestBody Admin admin){
		Admin adminadded=adminservice.AddAdmi(admin);
		return new ResponseEntity<Admin>(adminadded,HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateadmin")
	public ResponseEntity<?> updateAdmin(@RequestBody Admin admin){
		Admin adminupdated=adminservice.updateAdmin(admin);
		return new ResponseEntity<Admin>(adminupdated,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/deleteadminbyid/{adminId}")
	public ResponseEntity<?> deleteAdminById(@PathVariable("adminId") int adminId){
		Admin admindeleted=adminservice.deleteAdminById(adminId);
		if(admindeleted!=null) {
			return new ResponseEntity<Admin>(admindeleted,HttpStatus.OK);

		}else {
		return new ResponseEntity<>("Admins does not found",HttpStatus.NOT_FOUND);
	}
	}
	@GetMapping("/getadminbyid/{adminid}")
	public ResponseEntity<?> getAdminById(@PathVariable("adminid") int adminid){
		Admin admin=adminservice.getAdminById(adminid);
		if(admin!=null) {
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Admins does not found with given adminId",HttpStatus.NOT_FOUND);

		}
	}
 
}

