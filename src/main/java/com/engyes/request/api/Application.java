package com.engyes.request.api;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.engyes.request.api.service.RequestApi;

@Configuration
@ComponentScan( basePackages = "com.engyes.request" )
@PropertySource( { "classpath:application.properties" } )
public class Application {

	private static AnnotationConfigApplicationContext ctx;

	public static void main( String[] args ) {

		ctx = new AnnotationConfigApplicationContext( Application.class );
		ctx.getBean( RequestApi.class ).run( args );

	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}