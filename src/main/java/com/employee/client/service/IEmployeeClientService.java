package com.employee.client.service;

import com.employee.client.dto.EmployeeDetails;

public interface IEmployeeClientService {
	public EmployeeDetails getGetEmployeeByIdUsingResttemplate(int employeeId) throws Exception;
	public EmployeeDetails getGetEmployeeByIdUsingFeignClient(int employeeId) throws Exception;
	
}
