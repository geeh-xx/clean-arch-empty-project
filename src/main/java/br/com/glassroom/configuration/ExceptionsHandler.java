package br.com.glassroom.configuration;

import static java.lang.System.currentTimeMillis;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

	private StandardError buildStardardError(HttpServletRequest request, String statusMessage, int httpStaus) {
		return new StandardError(currentTimeMillis(), httpStaus, statusMessage, request.getRequestURI());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> serviceUnavailable(Exception e, HttpServletRequest request){
		
		log.error(e.getMessage(), e);
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).
				body(buildStardardError(request, "Service Unavailable", HttpStatus.SERVICE_UNAVAILABLE.value()));
	}
	
}
