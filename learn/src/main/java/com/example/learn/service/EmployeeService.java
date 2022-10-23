package com.example.learn.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learn.exception.UserNotFoundException;
import com.example.learn.model.Employee;
import com.example.learn.repos.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	public final EmployeeRepo employeeRepo;
	public EmployeeService(EmployeeRepo employeeRepo){
		this.employeeRepo = employeeRepo;
	}

	//create employee
	public Employee addEmployee(Employee employee)
	{
		//save repo
		return employeeRepo.save(employee);
	}
	public List<Employee>findAllEmployees(){
		return employeeRepo.findAll();
	}
	public Employee updateEmployee(Employee employee){
		return employeeRepo.save(employee);
	}

	
	// public void deleteEmployee(Long id){
	// 	 employeeRepo.deleteEmployeebyId(id);
	// }
	public Employee findemployeeById(Long id){
		return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User with id"+id+"was not found"));
	}

	public void deleteEmployee(Long id) {
		employeeRepo.delete(findemployeeById(id));
	}

	



}
