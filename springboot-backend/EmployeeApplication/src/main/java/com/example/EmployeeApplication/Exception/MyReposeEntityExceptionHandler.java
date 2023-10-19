package com.example.EmployeeApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.EmployeeApplication.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class MyReposeEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMessage> employeeNotFoundExecption(EmployeeNotFoundException employeeNotFoundException,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND,employeeNotFoundException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
}
