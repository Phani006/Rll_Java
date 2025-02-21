package com.mphasis.eLearning.service;

import java.util.List;

import com.mphasis.eLearning.entity.Category;

public interface ICategoryService {

	public List<Category> getAllCategories();
	public Category addCategory(Category category);
	public Category deleteCategory(int categoryId);
}
