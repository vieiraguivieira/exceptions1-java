package model.exceptions;

public class DomainException extends RuntimeException {
	// RuntimeException - o compilador não obriga a tratar
	// Exception - o compilador obriga a tratar (assim como a ParseException)

	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
