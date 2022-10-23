package com.example.learn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.model.Employee;
import com.example.learn.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private final EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService){
		this.employeeService= employeeService;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id")Long id){
		Employee employees = employeeService.findemployeeById(id);
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

	@PostMapping(value="/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee emps = employeeService.addEmployee(employee);
		return new ResponseEntity<>(emps,HttpStatus.CREATED);
	}

	@PutMapping(value="/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

		Employee emps = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(emps,HttpStatus.OK);
	}

	// @DeleteMapping("/delete/{id}")
	// public  ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
	// 	employeeService.deleteEmployee(id);
	// 	return new ResponseEntity<>(HttpStatus.OK);

	// }
	
}
