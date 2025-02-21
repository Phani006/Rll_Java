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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.eLearning.entity.Team;
import com.mphasis.eLearning.service.ITeamService;

@CrossOrigin("*")
@RestController
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private ITeamService iTeamService;
	@GetMapping("getAllTeams")
public ResponseEntity<?> getAllTeam(){
		List<Team> teamList=iTeamService.getAllTeams();
		if(!teamList.isEmpty()) {
			return new ResponseEntity<List<Team>>(teamList,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("Data is not present in team ",HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("getTeam/{teamId}")
	public ResponseEntity<?> getTeamByid(@PathVariable("teamId")int teamId){
		Team team=iTeamService.getTeamByTeamId(teamId);
		if(team!=null) {
			return new  ResponseEntity<Team>(team,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("team is not present",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("addTeam")
	public ResponseEntity<?> addTeam(@RequestBody Team team){
		Team team1=iTeamService.addTeam(team);
		if(team!=null) {
			return new  ResponseEntity<Team>(team1,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("Unable to add team the data",HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("updateTeam")
	public ResponseEntity<?> updateTeam(@RequestBody Team team) {
		
		Team team1=iTeamService.updateTeam(team);
		if(team!=null) {
			return new  ResponseEntity<Team>(team1,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("Unable to update team the data",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("deleteteam/{teamId}")
	public ResponseEntity<?> deleteTeamByid(@PathVariable("teamId")int teamId){
		Team team=iTeamService.DeleteTeamById(teamId);
		if(team!=null) {
			return new  ResponseEntity<Team>(team,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("team is  to delete not present",HttpStatus.NOT_FOUND);
		}
	}
}
