package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Reports;
import com.mphasis.eLearning.repository.ReportsRepository;

@Service
public class ReportsService implements IReportsService{
	
	@Autowired
	private ReportsRepository reportsRepository;

	@Override
	public List<Reports> getReports() {
		List<Reports> reportsList=reportsRepository.findAll();
	return reportsList;
	}

	@Override
	public Reports addReports(Reports report) {
		Reports reportsAdded=reportsRepository.save(report);
	return reportsAdded;
	}
	
	@Override
	public List<Reports> getreportsByManager(int managerId) {
		List<Reports> r=reportsRepository.getReportByManager(managerId);
		return r;
	}
	
	

}
