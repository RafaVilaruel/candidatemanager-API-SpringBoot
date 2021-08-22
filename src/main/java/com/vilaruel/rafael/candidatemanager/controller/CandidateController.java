package com.vilaruel.rafael.candidatemanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilaruel.rafael.candidatemanager.model.Candidate;
import com.vilaruel.rafael.candidatemanager.service.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	private final CandidateService candidateService;
	
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;		
	}
	
	//Returns an HTTP response, and in the body of that HTTP response,
	//There's gonna be a List of candidates
	@GetMapping("/all")
	public ResponseEntity<List<Candidate>> getAllCandidates (){
		List<Candidate> candidates = candidateService.findAllCandidates();
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}
	
	//GET candidate by ID
	@GetMapping("/find/{id}")
	public ResponseEntity<Candidate> getCandidateById (@PathVariable("id") Long id){
		Candidate candidate = candidateService.findCandidateById(id);
		return new ResponseEntity<>(candidate, HttpStatus.OK);
	}
	
	//ADD candidate
	@PostMapping("/add")
	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate){
		Candidate newCandidate = candidateService.addCandidate(candidate);
		return new ResponseEntity<>(newCandidate,HttpStatus.OK);
		
	}
	
	//Update candidate
	@PutMapping("/update")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate){
		Candidate updatedCandidate = candidateService.updateCandidate(candidate);
		return new ResponseEntity<>(updatedCandidate,HttpStatus.OK);
			
		}
	
	//Delete candidate
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCandidate(@PathVariable("id") Long id){
		candidateService.deleteCandidate(id);
		return new ResponseEntity<>(HttpStatus.OK);
			
		}
	
	
	
	
	
	
}
