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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Category;
import com.mphasis.eLearning.service.ICategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping("getcateory")
	public ResponseEntity<?> getCategories(){
		List<Category> categoryList=categoryService.getAllCategories();
		if(!categoryList.isEmpty()) {
			return new ResponseEntity<List<Category>>(categoryList,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("category List is Empty",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping("addcategory")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category categoryAdded=categoryService.addCategory(category);
		if(category.getCategoryId()==categoryAdded.getCategoryId()) {
			return new ResponseEntity<Category>(categoryAdded,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Category Adding Failed",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("deletecategory/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable int categoryId){
		Category categorydeleted=categoryService.deleteCategory(categoryId);
		if(categorydeleted!=null) {
			return new ResponseEntity<Category>(categorydeleted,HttpStatus.GONE);
		}else {
			return new ResponseEntity<String>("Category Deletion Failed",HttpStatus.BAD_REQUEST);
		}
	}

}
