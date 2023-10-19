package com.example.EmployeeApplication.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.EmployeeApplication.entity.Employee;
import com.example.EmployeeApplication.service.EmployeeService;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	private Employee employee;

	@BeforeEach
	void setUp() throws Exception {
		employee = Employee.builder().firstName("prakash").lastName("anupoju").email("prakash@gmail.com")
				.mobileNumber("1234567890").build();
	}

	@Test
	void testSaveEmployee() throws Exception {
		Employee inputEmployee = Employee.builder().firstName("prakash").lastName("anupoju").email("prakash@gmail.com")
				.mobileNumber("1234567890").build();

		Mockito.when(employeeService.saveEmployee(inputEmployee)).thenReturn(employee);

		mockMvc.perform(post("/ema/employees").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + "\t\"firstName\":\"prakash\",\n" + "\t\"lastName\":\"anupoju\",\n"
						+ "\t\"email\":\"prakash@gmail.com\",\n" + "\t\"mobileNumber\":\"1234567890\"\n" + "}"))
				.andExpect(status().isOk());
	}

	@Test
	void testFindEmployeeById() throws Exception {
		Mockito.when(employeeService.findEmployeeById(1L)).thenReturn(employee);

		mockMvc.perform(get("/ema/employees/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value(employee.getFirstName()));
	}
}
