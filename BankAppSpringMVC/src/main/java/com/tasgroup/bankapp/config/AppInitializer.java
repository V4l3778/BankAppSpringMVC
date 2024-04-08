package com.tasgroup.bankapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext sC) 
			throws ServletException {
		AnnotationConfigWebApplicationContext webContext= new AnnotationConfigWebApplicationContext();
		webContext.register(AppConfig.class);
		webContext.setServletContext(sC);
		
		DispatcherServlet ds= new DispatcherServlet(webContext);
		
		ServletRegistration.Dynamic servlet= sC.addServlet("spring",ds);
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
