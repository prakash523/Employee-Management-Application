package com.example.EmployeeApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.EmployeeApplication.Exception.EmployeeNotFoundException;
import com.example.EmployeeApplication.entity.Employee;
import com.example.EmployeeApplication.service.EmployeeService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/ema/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private final Logger logger = LoggerFactory.getLogger(Employee.class);
	
	@PostMapping
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		logger.info("Inside saveDepartment of EmployeeController");
		return employeeService.saveEmployee(employee);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		logger.info("Inside findAllEmployees of EmployeeController");
		return new ResponseEntity<List<Employee>>(employeeService.findAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") long id) throws EmployeeNotFoundException {
		logger.info("Inside findEmployeeById of EmployeeController");
		return new ResponseEntity<Employee>(employeeService.findEmployeeById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable("id") long id) {
		logger.info("Inside deleteEmployeeById of EmployeeController");
		employeeService.deleteEmployeeById(id);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("deleted", true);
		return new ResponseEntity<Map<String, Boolean>>(map, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
		logger.info("Inside updateEmployee of EmployeeController");
		return employeeService.updateEmployee(employee,id);
	}
	
	@GetMapping("/name/{name}")
	public Employee findEmployeeByName(@PathVariable("name") String name) {
		logger.info("Inside findEmployeeByName of EmployeeController");
		return employeeService.findEmployeeByName(name);
	}
}
