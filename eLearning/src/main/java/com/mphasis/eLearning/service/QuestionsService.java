package com.mphasis.eLearning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Course;
import com.mphasis.eLearning.entity.Employee;
import com.mphasis.eLearning.entity.Questions;
import com.mphasis.eLearning.entity.Reports;
import com.mphasis.eLearning.repository.CourseRepository;
import com.mphasis.eLearning.repository.EmployeeRepository;
import com.mphasis.eLearning.repository.QuestionsRepository;
import com.mphasis.eLearning.repository.ReportsRepository;
@Service
public class QuestionsService implements IQuestionsService{
	@Autowired
	private QuestionsRepository questionsRepository;
	@Autowired
	private ReportsRepository reportsRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	private List<Questions> ql=new ArrayList<>();
	
	@Override
	public Questions addQuestion(Questions question) {
		questionsRepository.save(question);
		return question;
	}

	@Override
	public Questions deleteQuestion(int questionId) {
		Questions question=null;
		if(questionsRepository.existsById(questionId)) {
			question=questionsRepository.findById(questionId).get();
			questionsRepository.deleteById(questionId);
		}
		return question;
	}

	@Override
	public Questions updateQuestion(Questions question) {
		questionsRepository.save(question);
		return question;
	}
	
	@Override
	public Reports addoptions(List<String> ls,int quizId,int employeeId,int courseId) {
		double sum=0;
		ql=questionsRepository.getAllQuestions(quizId);
		for(int i=0;i<ql.size();i++) {
			for(int j=0;j<ls.size();j++) {
				if(i==j) {
					if(ql.get(i).getCorrectAnswer().equals(ls.get(j))) {
						sum=sum+ql.get(i).getWeightage();
					}
				}
				}
		}
		double total=0;
		for(Questions q:ql) {
			total=total+q.getWeightage();
		}
		Course course=courseRepository.findById(courseId).get();
		Employee  employee=employeeRepository.findById(employeeId).get();
			double percentage=(double)(sum/total)*100;
			Reports reports=new Reports();
			reports.setProgress(percentage);
			reports.setQuizId(quizId);
			reports.setCourseRef(course);
			reports.setEmployeeRef(employee);
			reports.setQuizScore((int)sum);
			reportsRepository.save(reports);
			
			return reports;
	}

@Override
public List<Questions> Questions(int quizId) {
	List<Questions> ql=questionsRepository.getAllQuestions(quizId);
	return ql;
	

}

}
