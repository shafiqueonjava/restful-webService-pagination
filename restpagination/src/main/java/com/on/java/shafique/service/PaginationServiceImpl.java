/*
 * Copyright (c) 2017, 2018, AVIVA and its affiliates. All rights reserved.
 * AVIVA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


package com.on.java.shafique.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.on.java.shafique.service.exception.PaginationServiceCustomsException;

/**
 * Represent the PaginationService api implementation.
 * @author     Shafique Mohammed
 * 
 */

@Service
public class PaginationServiceImpl implements PaginationService {

	/**
	   * Generates the number's based input parameter passed, Numbers generate 
	   * are analogous to entity
	   * 
	   * @param startIndex - represent the page number
	   * @param size - represent the number of entities to be displayed per page
	   * @exception PaginationServiceCustomsException runtime exception is thrown for invalid startIndex & size parameter.
	   * @return - returns the javax.ws.rs.core.Response instance.
	   */
	@Override
	public Response getPages(int startIndex, int size) {
		if (startIndex <= 0 || size <= 0) {
			throw new PaginationServiceCustomsException(500, "Invalid StartIndex or Size");
		}
		StringBuilder sb = new StringBuilder();

		for (int i = startIndex; i <= (startIndex + size -1); i++) {
			    sb.append(i);
			if (i != (startIndex + size - 1)) {
				sb.append(", ");
			}

		}
		Response response = Response.status(200).entity(sb.toString()).build();

		return response;
	}

	@Override
	public Response addNumbers(int entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
