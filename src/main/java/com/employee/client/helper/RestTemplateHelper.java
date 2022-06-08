package com.employee.client.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.employee.client.controller.EmployeeClientRestController;
import com.employee.client.dto.EmployeeDto;

@Component
public class RestTemplateHelper {
	Logger logger = LoggerFactory.getLogger(RestTemplateHelper.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${employee.service.url}")
	private String employeeServiceUrl;
	
	public EmployeeDto getEmployeeById(int employeeId) throws Exception{
		logger.info("Into RestTemplateHelper:getEmployeeById");
		try {
			return restTemplate.getForObject(employeeServiceUrl + "/" + employeeId, EmployeeDto.class);
		}
		catch(Exception ex) {
			logger.error("Exception occurs while calling thr Resttemplate. Ex msg - " + ex.getMessage());
			throw ex;
		}
	}
}
