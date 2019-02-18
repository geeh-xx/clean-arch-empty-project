package br.com.glassroom.Exception;

public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}

}
