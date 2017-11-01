package com.chincent.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/msg")
public class MessageService {
	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Person person) throws Exception {
		person.setName("U" + person.getName());
		return Response.ok(person).build();
	}

	@Path("/get/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) throws Exception {
		String returnValue = "Hello " + id;
		return Response.ok(returnValue).build();
	}

	@Path("/update")
	@PUT
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDatas(String incomingData) throws Exception {
		String returnString = null;
		return Response.ok(returnString).build();
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteData(@PathParam("id") int id) throws Exception {
		String deleteValue = null;
		return Response.ok(deleteValue).build();
	}
}