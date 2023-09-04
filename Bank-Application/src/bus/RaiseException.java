package bus;

public class RaiseException extends Exception{
	
	private static String msg = "Invalid input: Feneral Exception from the developper - Shaun.S {back-end}";
	
	public RaiseException() {
		
		super(msg);
	}

	public RaiseException (String message) {
		super(message);
	}
}
