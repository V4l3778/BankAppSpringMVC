package com.tasgroup.bankapp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception exc) {
		ModelAndView mv= new ModelAndView();
		mv.addObject("Exception",exc);
		return mv;
	}
	
}
