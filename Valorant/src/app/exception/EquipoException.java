package app.exception;

public class EquipoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9045296205235261730L;

	public EquipoException() {
	}

	public EquipoException(String message) {
		super(message);

	}

	public EquipoException(Throwable cause) {
		super(cause);

	}

	public EquipoException(String message, Throwable cause) {
		super(message, cause);

	}

	public EquipoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
