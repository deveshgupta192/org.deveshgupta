package org.deveshgupta.web.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Main {
	public static void main(String[] args) {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		final AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
		final FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext();
		final XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
		
		
		
	}
}
