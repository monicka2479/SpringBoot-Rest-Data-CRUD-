package com.springData.SpringDataRest.common.exceptions;


public class NoDataFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "No Record Found";

	public String getMessage() {
		return message;
	}


}
