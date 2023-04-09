package cn.spring.web;

import cn.spring.context.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;


public class AnnotationConfigWebApplicationContext 
					extends ClassPathXmlApplicationContext implements WebApplicationContext{
	private ServletContext servletContext;
	
	public AnnotationConfigWebApplicationContext(String fileName) {
		super(fileName);
	}

	@Override
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
