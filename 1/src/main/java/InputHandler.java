import java.util.Scanner;
import java.util.NoSuchElementException;

public class InputHandler {
	public String scan() {
		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine();
		} catch (NoSuchElementException e) {
			System.err.println("Error: Scanner exhausted unexpectedly.");
		}
	return "";
	}
}
