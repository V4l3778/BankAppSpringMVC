package com.tasgroup.bankapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.tasgroup.bankapp.businesscomponent.dao.ClienteDAO;
import com.tasgroup.bankapp.businesscomponent.dao.ContoDAO;
import com.tasgroup.bankapp.businesscomponent.dao.RuoloDAO;
import com.tasgroup.bankapp.businesscomponent.dao.TransazioneDAO;

@Configuration
@EnableWebMvc
@ComponentScan("com.tasgroup.bankapp.controller")
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dS= new DriverManagerDataSource();
		dS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dS.setUrl("jdbc:mysql://localhost:3306/impiegati?serverTimezone=Europe/Rome");
		dS.setUsername("krisopea");
		dS.setPassword("pass");
		return dS;
	}
	
	@Bean
	public ClienteDAO getClienteDAO() {
		return new ClienteDAO();
	}
	
	@Bean
	public ContoDAO getContoDAO() {
		return new ContoDAO();
	}
	
	@Bean
	public RuoloDAO getRuoloDAO() {
		return new RuoloDAO();
	}
	
	@Bean
	public TransazioneDAO getTransazioneDAO() {
		return new TransazioneDAO();
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dS) {
		return new JdbcTemplate(dS);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/resources/**").addResourceLocations("/resources/css");
	}
	
}
