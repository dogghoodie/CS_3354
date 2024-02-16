import java.util.Scanner;

class JavaJSON {
	public static void main(String[] args) {
		// Welcome text / prompt	
		System.out.println("\n - Walker Knapp - \n");
		System.out.println("\nWelcome to JavaJSON\n");
		System.out.println("Enter the file path of the");
		System.out.println("file you would like to edit.\n");
		System.out.print("Enter: ");
		// Instantiate InputHandler to process user input
		InputHandler handle = new InputHandler();
		// Set input string to the input processed by handler
		String input = handle.scan();
		// Test handler - 
		System.out.println(input);
	}
}
