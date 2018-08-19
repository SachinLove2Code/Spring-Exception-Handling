package com.sachinlove2code.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sachinlove2code.service.GeneralException;

@ControllerAdvice
public class ExceptionHandlerControllAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException resourceNotFoundException,
			final HttpServletRequest request){
		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(resourceNotFoundException.getMessage());
		error.callerURL(request.getRequestURI());
		return error;
	}
	
	@ExceptionHandler(GeneralException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleException(final GeneralException exception,final HttpServletRequest request){
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;
	}
}
