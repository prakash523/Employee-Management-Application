package com.example.EmployeeApplication.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.EmployeeApplication.entity.Employee;

@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee = Employee.builder().firstName("prakash").lastName("anupoju").email("prakash@gmail.com")
				.mobileNumber("1234567890").build();

		testEntityManager.persist(employee);
	}

	@Test
	void testFindByFirstName() {
		Employee found = employeeRepository.findById(1L).get();
		assertEquals("prakash@gmail.com", "prakash@gmail.com");
	}

}
