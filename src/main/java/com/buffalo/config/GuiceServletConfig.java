package com.buffalo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.buffalo.hello.Hello;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceServletConfig extends GuiceServletContextListener {

	private static final Logger	log	= LoggerFactory.getLogger(GuiceServletConfig.class);

	
	public GuiceServletConfig() {
		super();
		log.debug("creating GuiceServletConfig");
	}

	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {

			@Override
			protected void configureServlets() {
				log.info("logger configureServlets...");
				System.out.println("System.out configure servets.");
				// Must configure at least one JAX-RS resource or the
				// server will fail to start.
				bind(Hello.class);
				// Route all requests through GuiceContainer
				serve("/rest/*").with(GuiceContainer.class);
			}
		});
	}
}
