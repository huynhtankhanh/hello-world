package com.khanh.hello_world;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("hellos")
public class HelloResource {

	@GET
	public Response sayHello() {
		return Response.ok("Hello world There!").build();
	}
}
