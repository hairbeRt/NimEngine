
public class IllegalMoveException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalMoveException() {
		super();
	}

	public IllegalMoveException(String message) {
		super("Illegal move: " + message);
	}

	public IllegalMoveException(String message, Throwable cause) {
		super("Illegal move: " + message);
	}

	public IllegalMoveException(Throwable cause) {
		super(cause);
	}

}
