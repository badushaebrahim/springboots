package com.example.learn;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.Survey;
import com.example.learn.repos.SurveyRepo;
import com.example.learn.service.SurveyService;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	public final SurveyService service;
	public SurveyController(SurveyService service){
		this.service = service;

	}

	@PostMapping()
	public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey){
		Survey sur =  service.addSurvey(survey);
		return new ResponseEntity<>(sur,HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Survey>> getAll(){
		List<Survey> lis = service.listAllSurvey();
		return new ResponseEntity<>(lis , HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Survey> getSurvey(@PathVariable("id")Long id){
		Survey sur = service.findbyIdSurvey(id);
		return new ResponseEntity<>(sur,HttpStatus.OK);
	}

}