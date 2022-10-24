package com.example.learn.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn.model.Survey;

public interface SurveyRepo extends JpaRepository<Survey,Long> {

	Optional <Survey> findEmployeeById(Long id);
	
}
