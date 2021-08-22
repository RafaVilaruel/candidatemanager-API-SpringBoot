package com.vilaruel.rafael.candidatemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vilaruel.rafael.candidatemanager.model.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Long>{

	void deleteCandidateById(Long id);
	Optional<Candidate> findCandidateById(Long id);

}
