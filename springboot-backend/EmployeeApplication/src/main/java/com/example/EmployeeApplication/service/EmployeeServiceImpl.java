package com.example.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeApplication.Exception.EmployeeNotFoundException;
import com.example.EmployeeApplication.entity.Employee;
import com.example.EmployeeApplication.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id)
			throws com.example.EmployeeApplication.Exception.EmployeeNotFoundException {
		Optional<Employee> opEmp = employeeRepository.findById(id);
		if (!opEmp.isPresent())
			throw new EmployeeNotFoundException("Employee not found");
		return opEmp.get();
	}

	@Override
	public String deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
		return "employee not found";
	}

	@Override
	public Employee findEmployeeByName(String name) {
		return employeeRepository.findByFirstName(name);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee employee2 = employeeRepository.findById(id).get();
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setMobileNumber(employee.getMobileNumber());
		employee2.setEmail(employee.getEmail());
		employeeRepository.save(employee2);
		return employee2;
	}

}
