package com.employee.client.util;

import org.mapstruct.Mapper;

import com.employee.client.dto.EmployeeDetails;
import com.employee.client.dto.EmployeeDto;



@Mapper
public interface SimpleSourceDestinationMapper {
   EmployeeDetails getEmployeeDetailsObjectFromDao(EmployeeDto empDto);
   EmployeeDto getEmployeeDaoObjectFromEmployeeDteails(EmployeeDetails employeeDetails);
}
