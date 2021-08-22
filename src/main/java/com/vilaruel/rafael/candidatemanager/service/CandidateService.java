package com.vilaruel.rafael.candidatemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilaruel.rafael.candidatemanager.exception.UserNotFoundException;
import com.vilaruel.rafael.candidatemanager.model.Candidate;
import com.vilaruel.rafael.candidatemanager.repo.CandidateRepo;

@Service
public class CandidateService {
	
	
	private final CandidateRepo candidateRepo;
	
	@Autowired
	public CandidateService(CandidateRepo candidateRepo) {
		this.candidateRepo = candidateRepo;
	}
	
	public Candidate addCandidate(Candidate candidate) {
		candidate.setCandidateCode(UUID.randomUUID().toString());
		return candidateRepo.save(candidate);
	}
	
	public List<Candidate> findAllCandidates(){
		return candidateRepo.findAll();
	}
	
	public Candidate updateCandidate(Candidate candidate) {
		return candidateRepo.save(candidate);
	}
	
	public Candidate findCandidateById(Long id) {
		return candidateRepo.findCandidateById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
	}
	
	public void deleteCandidate(Long id) {
		candidateRepo.deleteById(id);
	}
	
	

}
