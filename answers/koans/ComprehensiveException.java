package koans;

public class ComprehensiveException extends Exception {

	public ComprehensiveException() {
		super();
	}

	public ComprehensiveException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComprehensiveException(String message) {
		super(message);
	}

	public ComprehensiveException(Throwable cause) {
		super(cause);
	}

	
}
