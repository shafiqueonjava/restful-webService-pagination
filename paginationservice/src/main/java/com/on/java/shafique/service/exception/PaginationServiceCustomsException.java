/*
 * Copyright (c) 2017, 2018, AVIVA and its affiliates. All rights reserved.
 * AVIVA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


package com.on.java.shafique.service.exception;

import javax.ws.rs.WebApplicationException;


/**
 * Represent the PaginationServiceCustomsException to be thrown to 
 * override the default status and error message.
 * @author     Shafique Mohammed
 * 
 */
public class PaginationServiceCustomsException extends WebApplicationException {

	/**
	 * serial version UID
	 */
	private static final long serialVersionUID = 48340325634195241L;

	/*
	 * the fiels _error_codes
	 */
	private int _error_Codes;
	
	/*
	 * the fiels _faultMessage
	 */
	private String _faultMessage;
	
	/**
	 * The no-arg default constructor
	 */
	public PaginationServiceCustomsException() {}

	/**
	 * The parametrized constructor, to initialize PaginationServiceCustomsException 
	 * instance with the given _error_Codes and _faultMessage
	 * 
	 * @param - _error_Codes
	 * @param - _faultMessage
	 */
	public PaginationServiceCustomsException(int _error_Codes, String _faultMessage) {
		super();
		this._error_Codes = _error_Codes;
		this._faultMessage = _faultMessage;
	}

	/**
	 *  getter for _error_Codes
	 * @return - int _error_Codes
	 */
	public int get_error_Codes() {
		return _error_Codes;
	}

	/**
	 *  setter for _error_Codes
	 * @param - int _error_Codes
	 */
	public void set_error_Codes(int _error_Codes) {
		this._error_Codes = _error_Codes;
	}

	/**
	 *  getter for _faultMessage
	 * @return - String _faultMessage
	 */
	public String get_faultMessage() {
		return _faultMessage;
	}

	/**
	 *  setter for _faultMessage
	 * @param - int _faultMessage
	 */
	public void set_faultMessage(String _faultMessage) {
		this._faultMessage = _faultMessage;
	}
	
	
		
	
}
