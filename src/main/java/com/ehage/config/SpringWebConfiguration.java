package com.ehage.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.ehage"})
public class SpringWebConfiguration extends WebMvcConfigurerAdapter {

//	@Override
//	public void configureDefaultServletHandling(
//			DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/*.html").addResourceLocations("/");		
	}
	
	@Bean
	public InternalResourceViewResolver viewReoslver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/"); 
		viewResolver.setSuffix(".jsp"); 
		viewResolver.setExposeContextBeansAsAttributes(true);
		viewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		
		return viewResolver;
	}	
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
//	@Bean
//	public MultipartResolver multipartResolver() {
//		return new StandardServletMultipartResolver();
//	}
	
}

