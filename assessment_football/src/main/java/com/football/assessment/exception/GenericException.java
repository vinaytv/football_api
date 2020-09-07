package com.football.assessment.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -741033979778711103L;
	private HttpStatus status;
	private String errorMessage;
	private String errorDescription;
	private String correlationId;

	public GenericException(HttpStatus status, String errorMessage, String errorDescription, String correlationId) {

		this.correlationId = correlationId;
		this.errorDescription = errorDescription;
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getCorrelationId() {
		return correlationId;
	}

}
