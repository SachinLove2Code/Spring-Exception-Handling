package com.sachinlove2code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sachinlove2code.exceptionhandling.ResourceNotFoundException;
import com.sachinlove2code.model.Employee;
import com.sachinlove2code.service.EmployeeService;
import com.sachinlove2code.service.GeneralException;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee getEmpl() throws GeneralException, ResourceNotFoundException {
		try {
			Employee emp = employeeService.getEmployee();

			if (emp == null) {
				throw new ResourceNotFoundException("Employee not fount");
			}
			return emp;
		} catch (GeneralException e) {
			throw new GeneralException("internal Exception while getting the exception");
		}
	}

	@RequestMapping(value = "/employee2", method = RequestMethod.GET)
	public Employee getEmpl2()throws GeneralException, ResourceNotFoundException {
		try {
			Employee emp = employeeService.getEmployeeNull();
			if(emp == null){
				throw new ResourceNotFoundException("Employee not found");
			}
			return emp;
		} catch (GeneralException e) {
			throw new GeneralException("internal exception while getting the employee");
		}
		
	}
	
	@RequestMapping(value="/employee3",method=RequestMethod.GET)
	public Employee getEmpl3() throws GeneralException,ResourceNotFoundException{
		try{
			Employee emp = employeeService.getEmployeeException();
			if(emp == null){
				throw new ResourceNotFoundException("Employee not found");
			}
			return emp;
		}catch (GeneralException e) {
			throw new GeneralException("internal exception while getting the employee");
		}
	
	}
	
	
	
	
	
	
}
