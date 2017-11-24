/*
 * Copyright (c) 2017, 2018, AVIVA and its affiliates. All rights reserved.
 * AVIVA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


package com.on.java.shafique.service;

import java.time.LocalDate;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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

	public static final String WORDS01_ON_WEDNESDAY = " wizz";
	public static final String WORDS02_ON_WEDNESDAY = " wuzz";
	
	public static final String WORDS01_ON_OTHERDAY = " fizz";
	public static final String WORDS02_ON_OTHERDAY = " buzz";
	/**
	   * Generates the number's based input parameter passed, Numbers generate 
	   * are analogous to entity
	   * 
	   * @param startIndex - represent the page number
	   * @param size - represent the number of entities to be displayed per page
	   * @exception PaginationServiceCustomsException runtime exception is thrown for invalid startIndex & size parameter.
	   * @return - returns the javax.ws.rs.core.Response instance.
	   */
	public Response getPages(int next, int previos) {
		if (next <= 0 || previos <= 0) {
			throw new PaginationServiceCustomsException(500, "Invalid StartIndex or Size");
		}
		
		String wordDivisibilityBy3 = null;
		String wordDivisibilityBy5 = null;
		String wordDivisibilityByBoth = null;
		if(LocalDate.now().getDayOfWeek().name().equalsIgnoreCase("WEDNESDAY")){
			wordDivisibilityBy3    = WORDS01_ON_WEDNESDAY;
			wordDivisibilityBy5    = WORDS02_ON_WEDNESDAY;
			wordDivisibilityByBoth = WORDS01_ON_WEDNESDAY + WORDS02_ON_WEDNESDAY;
			
		}else{
			wordDivisibilityBy3    = WORDS01_ON_OTHERDAY;
			wordDivisibilityBy5    = WORDS02_ON_OTHERDAY;
			wordDivisibilityByBoth = WORDS01_ON_OTHERDAY + WORDS02_ON_OTHERDAY;
		}
		
		if (next <= 0 || next > 1000 || previos <= 0 || previos > 1000) {
			throw new PaginationServiceCustomsException(500, "Invalid Number Range , Entered Number must be between 1 to 1000");
		}
		StringBuilder sb = new StringBuilder();

		for (int i = next; i <= (next + previos -1); i++) {
			 if((i % 3 == 0) && (i % 5 == 0)){
			    	sb.append(wordDivisibilityByBoth);
			    }else if(i % 5 == 0){
			    	sb.append(wordDivisibilityBy5);
			    }else if (i % 3 == 0){
			    	sb.append(wordDivisibilityBy3);
			    }else{
			    	sb.append(wordDivisibilityBy3);
			    }
			    
			if (i != (1000 - 1)) {
				sb.append(System.getProperty("line.separator"));
				sb.append(System.getProperty("line.separator"));
			   }

		}
		System.out.println(sb.toString());
		Response response = Response.status(200).entity(sb.toString()).build();

		return response;
	}

	
	/**
	   * Generates the number's based input parameter passed, Numbers generate 
	   * are analogous to entity which always start from 1.
	   * 
	   * @param number - represent the number  entered
	   * @exception PaginationServiceCustomsException runtime exception is thrown for invalid startIndex & size parameter.
	   * @return - returns the javax.ws.rs.core.Response instance.
	   */
	public Response getNumbers(@PathParam("number") int number) {
		
		String wordDivisibilityBy3 = null;
		String wordDivisibilityBy5 = null;
		String wordDivisibilityByBoth = null;
		if(LocalDate.now().getDayOfWeek().name().equalsIgnoreCase("WEDNESDAY")){
			wordDivisibilityBy3    = WORDS01_ON_WEDNESDAY;
			wordDivisibilityBy5    = WORDS02_ON_WEDNESDAY;
			wordDivisibilityByBoth = WORDS01_ON_WEDNESDAY + WORDS02_ON_WEDNESDAY;
			
		}else{
			wordDivisibilityBy3    = WORDS01_ON_OTHERDAY;
			wordDivisibilityBy5    = WORDS02_ON_OTHERDAY;
			wordDivisibilityByBoth = WORDS01_ON_OTHERDAY + WORDS02_ON_OTHERDAY;
		}
		
		if (number <= 0 || number > 1000) {
			throw new PaginationServiceCustomsException(500, "Invalid Number Range , Entered Number must be between 1 to 1000");
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= number; i++) {
			    if((i % 3 == 0) && (i % 5 == 0)){
			    	sb.append(wordDivisibilityByBoth);
			    }else if(i % 5 == 0){
			    	sb.append(wordDivisibilityBy5);
			    }else if (i % 3 == 0){
			    	sb.append(wordDivisibilityBy3);
			    }else{
			    	sb.append(wordDivisibilityBy3);
			    }
			    
			if (i != (1000 - 1)) {
				sb.append(System.getProperty("line.separator"));
				sb.append(System.getProperty("line.separator"));
			   }
					}
		System.out.println(sb.toString());
		Response response = Response.status(200).entity(sb.toString()).build();

		return response;		
	}

}
