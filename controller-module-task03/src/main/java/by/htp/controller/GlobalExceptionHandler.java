package by.htp.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String handle400(){
		return "errorCheckBox";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404(){
		return "404";
	}
	
}
