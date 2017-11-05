package com.chincent.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.chincent.data.Person;


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
	public Person get(@PathParam("id") int id, @Context HttpHeaders headers) throws Exception {
		
		Person person = new Person();
		person.setId(id);
		person.setName("name" + id);
		
		System.out.println(person);
		return person;
	}
	
//	@Path("/get/{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response get(@PathParam("id") int id) throws Exception {
//		String returnValue = "Hello " + id;
//		
//		System.out.println(returnValue);
//		return Response.status(200).entity(returnValue).build();
//	}

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