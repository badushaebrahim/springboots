package com.example.learn;

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

import com.example.learn.model.Survey;
import com.example.learn.service.SurveyService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired
	public final SurveyService service;
	public SurveyController(SurveyService service){
		this.service = service;

	}

	@PostMapping()
	public ResponseEntity<Survey> addSurvey(@RequestBody Survey survey){
		System.out.println(survey.getName());
		try{
		Survey sur =  service.addSurvey(survey);
		System.out.println(sur);
		return new ResponseEntity<>(sur,HttpStatus.CREATED);}
		catch(Exception e){
			return new ResponseEntity<>(survey,HttpStatus.EXPECTATION_FAILED);}
		}
	

	@GetMapping()
	public ResponseEntity<List<Survey>> getAll(){
		List<Survey> lis = service.listAllSurvey();
		return new ResponseEntity<>(lis , HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Survey> getSurvey(@PathVariable("id")Long id){
		try{
		Survey sur = service.findbyIdSurvey(id);
		return new ResponseEntity<>(sur,HttpStatus.OK);}
		catch (Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping()
	public ResponseEntity<Survey> updateSurvey(@RequestBody Survey survey){
		
		try{Survey sur = service.updatesurvey(survey);
		return new ResponseEntity<>(sur,HttpStatus.ACCEPTED);}
		catch(Exception e){
			return new ResponseEntity<>(survey,HttpStatus.EXPECTATION_FAILED);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSurvey(@PathVariable Long id){
		try{
			service.deleteSurvey(id);
			return new ResponseEntity<>(HttpStatus.OK);
		
		}catch(Exception e){
			return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);

		}
		
	}
}
