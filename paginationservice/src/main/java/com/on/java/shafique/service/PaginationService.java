/*
 * Copyright (c) 2017, 2018, AVIVA and its affiliates. All rights reserved.
 * AVIVA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.on.java.shafique.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.on.java.shafique.service.exception.PaginationServiceCustomsException;

/**
 * Represent the PaginationService api interface. describing the operations
 * the client can performed, the operations Consumes and Produces the Content-Type
 * as application/vnd.aviva.com-v1+json 
 * @author     Shafique Mohammed
 * @version    v1
 */


@Path("/numbers")
@Produces("application/vnd.aviva.com-v1+json")
@Consumes("application/vnd.aviva.com-v1+json")
public interface PaginationService {
	
	/**
	   * Generates the number's based input parameter passed, Numbers generate 
	   * are analogous to entity
	   * 
	   * @param startIndex - represent the page number
	   * @param size - represent the number of entities to be displayed per page
	   * @exception PaginationServiceCustomsException runtime exception is thrown for invalid startIndex & size parameter.
	   * @return - returns the javax.ws.rs.core.Response instance.
	   */

	@GET
	public Response getPages(@QueryParam("next") int next, @QueryParam("previous") int previous);
	
	/**
	   * Generates the number's based input parameter passed, Numbers generate 
	   * are analogous to entity which always start from 1.
	   * 
	   * @param number - represent the number  entered
	   * @exception PaginationServiceCustomsException runtime exception is thrown for invalid startIndex & size parameter.
	   * @return - returns the javax.ws.rs.core.Response instance.
	   */
	@GET
	@Path("/printNumber/{number}")
	public Response getNumbers(@PathParam("number") int number);
	

	
}
