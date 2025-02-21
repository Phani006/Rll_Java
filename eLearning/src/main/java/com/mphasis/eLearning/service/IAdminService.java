package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Admin;

public interface IAdminService {
	public List<Admin> getAllAdmins();
	 public Admin AddAdmi(Admin admin);
	 public Admin updateAdmin(Admin admin);
	 public Admin deleteAdminById(int adminId);
	 public Admin getAdminById(int adminId);
}
