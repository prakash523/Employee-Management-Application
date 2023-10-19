package com.example.EmployeeApplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.EmployeeApplication.entity.Employee;
import com.example.EmployeeApplication.repository.EmployeeRepository;

@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee = Employee.builder().firstName("prakash").lastName("anupoju").email("prakash@gmail.com")
				.mobileNumber("1234567890").build();

		Mockito.when(employeeService.findEmployeeByName("prakash")).thenReturn(employee);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Get Data based on Valid Employee Name")
	void whenValidEmployeeName_thenEmployeeShouldFound() {
		String employeeName = "prakash";
		Employee found = employeeService.findEmployeeByName(employeeName);
		assertEquals(employeeName, found.getFirstName());
	}

}
