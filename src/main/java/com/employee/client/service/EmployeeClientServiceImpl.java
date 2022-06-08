package com.employee.client.service;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.client.dto.EmployeeDetails;
import com.employee.client.helper.EmployeeServiceFeignClient;
import com.employee.client.helper.RestTemplateHelper;
import com.employee.client.util.SimpleSourceDestinationMapper;


@Service
public class EmployeeClientServiceImpl implements IEmployeeClientService{
	
   Logger logger = LoggerFactory.getLogger(EmployeeClientServiceImpl.class);
	
	private SimpleSourceDestinationMapper mapper
     = Mappers.getMapper(SimpleSourceDestinationMapper.class);
	
	@Autowired
	private RestTemplateHelper restTemplateHealper;
	
	@Autowired
	private EmployeeServiceFeignClient empFeignClient;

	@Override
	public EmployeeDetails getGetEmployeeByIdUsingResttemplate(int employeeId) throws Exception {
		logger.info("Into EmployeeClientServiceImpl:getGetEmployeeByIdUsingResttemplate.Employee id - " + employeeId);
		EmployeeDetails empDetails =  mapper.getEmployeeDetailsObjectFromDao(restTemplateHealper.getEmployeeById(employeeId));
		logger.info("EmployeeDetails fetched - " + empDetails);
		return empDetails;
		
	}

	@Override
	public EmployeeDetails getGetEmployeeByIdUsingFeignClient(int employeeId) throws Exception {
		logger.info("Into EmployeeClientServiceImpl:getGetEmployeeByIdUsingFeignClient");
		EmployeeDetails empDetails =  mapper.getEmployeeDetailsObjectFromDao(empFeignClient.getEmployeeById(employeeId));
		logger.info("EmployeeDetails fetched - " + empDetails);
		return empDetails;
	}
   
}
