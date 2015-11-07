package com.engyes.request.api;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.engyes.request.api.service.RequestApi;

/**
 * It starts the application
 * A city is mandatory as argument
 *
 * @author  Bruno Andrade
 */
@Configuration
@ComponentScan( basePackages = "com.engyes.request" )
@PropertySource( { "classpath:application.properties" } )
public class Application {

	/** The ctx. */
	private static AnnotationConfigApplicationContext ctx;

	/**
	 * The main method.
	 *
	 * @param args City that will be requested for information
	 */
	public static void main( String[] args ) {

		ctx = new AnnotationConfigApplicationContext( Application.class );
		ctx.getBean( RequestApi.class ).run( args );

	}

	/**
	 * Property config in dev.
	 *
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}