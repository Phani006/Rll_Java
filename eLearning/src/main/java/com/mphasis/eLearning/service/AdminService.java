package com.mphasis.eLearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Admin;
import com.mphasis.eLearning.repository.AdminRepository;
@Service
public class AdminService implements IAdminService {
	 @Autowired
	    private AdminRepository adminRepository;

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> adminList=new ArrayList<>();
		adminList=adminRepository.findAll();
		 return adminList;
	}



	@Override
	public Admin updateAdmin(Admin admin) {
		adminRepository.save(admin);
		return admin;
	}

	@Override
	public Admin deleteAdminById(int adminId) {
		Admin admin=null;
		if(adminRepository.existsById(adminId)) {
			admin=adminRepository.findById(adminId).get();
			adminRepository.deleteById(adminId);
		}
		return admin;
	}

	@Override
	public Admin getAdminById(int adminId) {
		Admin admin=null;
		if(adminRepository.existsById(adminId)) {
			admin=adminRepository.findById(adminId).get();
		}
		return admin;
	}

	@Override
	public Admin AddAdmi(Admin admin) {
		// TODO Auto-generated method stub
		adminRepository.save(admin);
		return admin;
	}

}
