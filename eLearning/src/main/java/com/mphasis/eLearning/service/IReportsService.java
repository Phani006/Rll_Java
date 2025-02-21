package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Reports;

public interface IReportsService {
	
	public List<Reports> getReports();
	public Reports addReports(Reports report);
	public List<Reports> getreportsByManager(int managerId);

}
