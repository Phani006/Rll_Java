package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Level;

public interface ILevelService {
	public  Level addLevel(Level level);
	public Level deleteLevelById(int levelId);
	public List<Level> getLevel();
}
