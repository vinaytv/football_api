package com.football.assessment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.football.assessment.model.StandingsErrorResponse;

@ControllerAdvice
public class StandingsExceptionHandler {

	/**
	 * Exception handler for dependent API
	 * 
	 * @param remoteServerException
	 * @return
	 */
	@ExceptionHandler(value = RemoteServerException.class)
	public ResponseEntity<StandingsErrorResponse> remoteErrorException(RemoteServerException remoteServerException) {
		StandingsErrorResponse standingsErrorResponse = new StandingsErrorResponse();
		standingsErrorResponse.setCorrelationId(remoteServerException.getCorrelationId());
		standingsErrorResponse.setErrorDescription(remoteServerException.getErrorDescription());
		standingsErrorResponse.setErrorMessage(remoteServerException.getErrorMessage());
		standingsErrorResponse.setStatus(remoteServerException.getStatus().toString());
		return new ResponseEntity<StandingsErrorResponse>(standingsErrorResponse, remoteServerException.getStatus());
	}

	/**
	 * Exception handler for client side errors
	 * 
	 * @param remoteServerException
	 * @return
	 */
	@ExceptionHandler(value = ClientErrorException.class)
	public ResponseEntity<StandingsErrorResponse> clientErrorException(ClientErrorException clientErrorException) {
		StandingsErrorResponse standingsErrorResponse = new StandingsErrorResponse();
		standingsErrorResponse.setCorrelationId(clientErrorException.getCorrelationId());
		standingsErrorResponse.setErrorDescription(clientErrorException.getErrorDescription());
		standingsErrorResponse.setErrorMessage(clientErrorException.getErrorMessage());
		standingsErrorResponse.setStatus(clientErrorException.getStatus().toString());
		return new ResponseEntity<StandingsErrorResponse>(standingsErrorResponse, clientErrorException.getStatus());
	}

	/**
	 * Exception handler for Generic  errors
	 * 
	 * @param remoteServerException
	 * @return
	 */
	@ExceptionHandler(value = GenericException.class)
	public ResponseEntity<StandingsErrorResponse> genericException(GenericException genericException) {
		StandingsErrorResponse standingsErrorResponse = new StandingsErrorResponse();
		standingsErrorResponse.setCorrelationId(genericException.getCorrelationId());
		standingsErrorResponse.setErrorDescription(genericException.getErrorDescription());
		standingsErrorResponse.setErrorMessage(genericException.getErrorMessage());
		standingsErrorResponse.setStatus(genericException.getStatus().toString());
		return new ResponseEntity<StandingsErrorResponse>(standingsErrorResponse, genericException.getStatus());
	}

}
