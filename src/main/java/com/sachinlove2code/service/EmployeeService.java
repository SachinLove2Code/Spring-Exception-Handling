package com.sachinlove2code.service;

import org.springframework.stereotype.Service;

import com.sachinlove2code.model.Employee;

@Service
public class EmployeeService {

	
	public Employee getEmployee() throws GeneralException{
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setName("sachin");
		emp.setDesignation("senior software developer");
		emp.setSalary(1000000);
		return emp;
	}
	
	public Employee getEmployeeNull() throws GeneralException{
		return null;
	}
	
	
	public Employee getEmployeeException() throws GeneralException{
		throw new GeneralException();
	}
	
	
}
