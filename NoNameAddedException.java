package app;

public class NoNameAddedException extends Exception {
	
	public NoNameAddedException() {
		super("You must enter name.");
	}

}
