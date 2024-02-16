import java.util.Scanner;
import java.util.NoSuchElementException;

public class InputHandler {
	public String scan() {
		// Scans user input 
		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine();
		// Checks for exception
		} catch (NoSuchElementException e) {
			System.err.println("Error: Scanner exhausted unexpectedly.");
		}
	// Default return case
	return "";
	}
}
