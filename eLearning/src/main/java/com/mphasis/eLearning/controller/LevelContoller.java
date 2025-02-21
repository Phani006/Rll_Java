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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Level;
import com.mphasis.eLearning.service.ILevelService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/level")
public class LevelContoller {
	@Autowired
	private ILevelService iLevelService;
	
	@PostMapping("addLevel")
	public ResponseEntity<?> addLevel(@RequestBody Level level){
		Level level1=iLevelService.addLevel(level);
		if(level!=null) {
			return new ResponseEntity<Level>(level1,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("unable to add Level",HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/getLevel")
	public ResponseEntity<?> getlevel(){
		List<Level> level=iLevelService.getLevel();
		if(!level.isEmpty()) {
			return new ResponseEntity<List<Level>>(level,HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Level list is Empty",HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteLevel/{levelId}")
	public ResponseEntity<?> deleteLevelById(@PathVariable("levelId") int levelId ){
		Level level= iLevelService.deleteLevelById(levelId);
		if(level!=null) {
			return new ResponseEntity<Level>(level,HttpStatus.GONE);
		}else {
			return new ResponseEntity<String>("Level list is not deleted",HttpStatus.BAD_REQUEST);
		}
	}
	
	
}


