package com.example.learn.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn.model.Employee;

public  interface EmployeeRepo extends JpaRepository<Employee,Long>{

	// void  deleteEmployeebyId(Long id);
 	Optional<Employee> findEmployeeById(Long id);
}
