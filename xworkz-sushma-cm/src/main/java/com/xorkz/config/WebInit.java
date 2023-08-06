package com.xorkz.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//servlet specify madoke  //application context na DS register //yav req handle madoke gotagalla andre default agi / irodanna handle madoke //servlet jote config agoke help madatte
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() { // contains Data source, service, repo
		System.out.println("running getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { // helps to spring container to create object of component. //it
														// contains viewResolver, handler mapping, controller
		System.out.println("running getServletConfigClasses ");
		return new Class[] { FamConfig.class };
	}

	@Override
	protected String[] getServletMappings() { // identify path where DS will be mapped to , / is application default
		System.out.println("running getServletMappings ");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// it tells DS to forward request for static resource to view resolver
		configurer.enable();
	}
	
	
	
	protected void customizeRegistration(Dynamic registration) {
		String tempDir="D:\\temp";
		int max= 3 * 1024 * 1024;
		File uploadDir=new File(tempDir);
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement
				(uploadDir.getAbsolutePath(),max,max * 2, max / 2);
		
		 registration.setMultipartConfig(multipartConfigElement);
		//registration.set
	}
	

}