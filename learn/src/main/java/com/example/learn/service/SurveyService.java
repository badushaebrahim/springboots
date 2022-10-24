package com.example.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.exception.UserNotFoundException;
import com.example.learn.model.Survey;
import com.example.learn.repos.SurveyRepo;

@Service
public class SurveyService {
	@Autowired
	public final SurveyRepo surveyRepo;
	public SurveyService(SurveyRepo surveyRepo){
		this.surveyRepo = surveyRepo;
	}

	public Survey addSurvey(Survey survey){
		return surveyRepo.save(survey);
	}

	public List<Survey> listAllSurvey(){
		return surveyRepo.findAll();
	}

	public Survey findbyIdSurvey(Long id){
		return surveyRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User with id"+id+"was not found"));
	}

	public Survey update(Survey survey){
		return surveyRepo.save(survey);
	}

}
