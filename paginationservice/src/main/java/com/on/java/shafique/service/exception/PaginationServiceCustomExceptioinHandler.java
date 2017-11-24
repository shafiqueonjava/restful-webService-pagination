/*
 * Copyright (c) 2017, 2018, AVIVA and its affiliates. All rights reserved.
 * AVIVA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.on.java.shafique.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class PaginationServiceCustomExceptioinHandler implements ExceptionMapper<PaginationServiceCustomsException> {

	public Response toResponse(PaginationServiceCustomsException ex) {

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Invalid StartIndex or size").build();
	}

}
