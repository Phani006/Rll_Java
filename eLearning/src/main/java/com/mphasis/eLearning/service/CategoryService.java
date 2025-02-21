package com.mphasis.eLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.eLearning.entity.Category;
import com.mphasis.eLearning.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		List<Category>  categoryList=categoryRepository.findAll();
		return categoryList;
	}

	@Override
	public Category addCategory(Category category) {
		Category categoryadded=categoryRepository.save(category);
		return categoryadded;
	}

	@Override
	public Category deleteCategory(int categoryId) {
		Category category=null;
		if(categoryRepository.existsById(categoryId)) {
			category=categoryRepository.findById(categoryId).get();
			categoryRepository.deleteById(categoryId);
		}
		return category;
	}
	
	

}
