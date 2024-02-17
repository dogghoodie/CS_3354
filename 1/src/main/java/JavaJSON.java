import java.util.Scanner;

class JavaJSON {
	public static void main(String[] args) {
		// Welcome text / prompt	
		System.out.println("\n - Walker Knapp - \n");
		System.out.println("\nWelcome to JavaJSON\n");
		System.out.println("Enter the file path of the");
		System.out.println("file you would like to edit.\n");
		System.out.println("Example for Assignment: ");
		System.out.println("src/main/resources/example.json\n");
		System.out.print("Enter: ");
		
		// Instantiate InputHandler to process filePath
		InputHandler handleFile = new InputHandler();
		// Set filePath string to the input processed by handler
		String filePath = handleFile.scan();
		System.out.println("Accessing: " + filePath + "\n");
		
		System.out.println("Commands: \n");	
		System.out.println("create, read, write, exit\n");

		while (true) {
			System.out.print("Enter: ");
			
			// Instantiate new InputHandler to process commands
			InputHandler handleCommand = new InputHandler();
			// Set command string to the input processed by handler
			String command = handleCommand.scan();

			switch (command.toLowerCase()) {
				case "create":
					// Creates JSON object
					System.out.println("Created new Object\n");
					break;
				case "read":
					// Reads and returns JSON contents
					System.out.println("Reading file\n");
					break;
				case "write":
					// Writes to JSON file
					System.out.print("Name: ");
					System.out.print("Age: ");
					System.out.print("Birthday: ");
					System.out.println();
					break;
				case "exit":
					System.out.println("Exiting ...\n");
					break;
				default:
					System.out.println("Invalid command.\n");
					break;
			}
			if ("exit".equalsIgnoreCase(command)) {
				break;
			}	
		}	
	}
}
