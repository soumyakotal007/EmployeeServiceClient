package com.employee.client.helper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.client.dto.EmployeeDto;

@FeignClient(value = "employeeService", url = "${employee.service.url}")
public interface EmployeeServiceFeignClient {
	@RequestMapping(method = RequestMethod.GET, value = "/{empId}")
    EmployeeDto getEmployeeById(@PathVariable("empId") int empId);
}
