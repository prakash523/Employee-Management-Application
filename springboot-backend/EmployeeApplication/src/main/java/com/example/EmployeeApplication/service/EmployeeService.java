package com.example.EmployeeApplication.service;

import java.util.List;

import com.example.EmployeeApplication.Exception.EmployeeNotFoundException;
import com.example.EmployeeApplication.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(long id) throws EmployeeNotFoundException;

	public String deleteEmployeeById(long id);

	public Employee findEmployeeByName(String name);

	public Employee updateEmployee(Employee employee, long id);

}
