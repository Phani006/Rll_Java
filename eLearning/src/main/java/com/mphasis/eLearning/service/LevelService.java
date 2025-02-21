package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Level;
import com.mphasis.eLearning.repository.InstructorRepository;
import com.mphasis.eLearning.repository.LevelRepository;

@Service
public class LevelService implements ILevelService{
	
	@Autowired
	private LevelRepository levelRepository;
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public Level addLevel(Level level) {
		Level level1=null;
		if(level.getCourseRef().getInstructorRef()!=null) {
			instructorRepository.saveAll(level.getCourseRef().getInstructorRef());
		}
		else {
			 level1=levelRepository.save(level);
			
		}
		return level1;
		
		
	}

	@Override
	public Level deleteLevelById(int levelId) {
		Level level=null;
		if(levelRepository.existsById(levelId)) {
			level=levelRepository.findById(levelId).get();
			levelRepository.deleteById(levelId);
		}
		return level;
	}

	@Override
	public List<Level> getLevel() {
		List<Level> level=levelRepository.findAll();
		return level;
	}

}

