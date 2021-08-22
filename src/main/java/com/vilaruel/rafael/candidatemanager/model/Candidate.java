package com.vilaruel.rafael.candidatemanager.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
public @Data class Candidate implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String name, email, jobTitle, phone, wage, imageUrl;
	
	@Column(nullable = false, updatable = false)
	private String candidateCode;
}

/*
  {
    "name": "Rafael Vilaruel",
    "email": "rafael.vilaruel22@gmail.com",
    "jobTitle": "Java JR Developer",
    "phone": "11953324259",
    "wage": "R$ 2.000",   
    "imageUrl": "https://www.bootdey.com/img/Content/avatar/avatar1.png"    
}

*/