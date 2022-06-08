package com.employee.client.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.client.dto.EmployeeDetails;
import com.employee.client.service.IEmployeeClientService;



@RestController
public class EmployeeClientRestController {
	Logger logger = LoggerFactory.getLogger(EmployeeClientRestController.class);
	@Autowired
	IEmployeeClientService employeeService;
   
	@GetMapping("/restTemplate/employee/{eid}")
	public ResponseEntity<?> getGetEmployeeByIdUsingResttemplate(@PathVariable("eid") @Min(101) @Max(999) int employeeId){
		logger.info("Into the EmployeeClientRestController:getGetEmployeeByIdUsingResttemplate");
		try {
			EmployeeDetails empDetails = employeeService.getGetEmployeeByIdUsingResttemplate(employeeId);
			return new ResponseEntity<EmployeeDetails>( empDetails, HttpStatus.OK);
		}
		catch(Exception ex) {
			  logger.error("Exception in EmployeeClientRestController:getGetEmployeeByIdUsingResttemplate - " + ex.getMessage());
			  return new ResponseEntity<String>("Exception occurs in RestTemplate- " + ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/feign/employee/{eid}")
	public ResponseEntity<?> getGetEmployeeByIdUsingFeignClient(@PathVariable("eid") @Min(101) @Max(999) int employeeId){
		logger.info("Into the EmployeeClientRestController:getGetEmployeeByIdUsingFeignClient");
		try {
			EmployeeDetails empDetails = employeeService.getGetEmployeeByIdUsingFeignClient(employeeId);
			return new ResponseEntity<EmployeeDetails>( empDetails, HttpStatus.OK);
		}
		catch(Exception ex) {
			 logger.error("Exception in EmployeeClientRestController:getGetEmployeeByIdUsingFeignClient- " + ex.getMessage());
			  return new ResponseEntity<String>("Exception occurs in Feign client- " + ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
