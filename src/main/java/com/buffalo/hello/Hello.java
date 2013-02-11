package com.buffalo.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	private static final org.slf4j.Logger	log	= org.slf4j.LoggerFactory.getLogger(Hello.class);

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		System.out.println("System.out log");
		log.error("slf4j error log");
		log.info("slf4j info log");
		log.debug("slf4j debug log");
		return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "Hello Jersey" + "</body></h1>"
				+ "</html> ";
	}

}