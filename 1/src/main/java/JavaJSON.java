import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
		System.out.println("read, write, exit\n");

		while (true) {
			System.out.print("Enter: ");
			
			// Instantiate new InputHandler to process commands
			InputHandler handleCommand = new InputHandler();
			// Set command string to the input processed by handler
			String command = handleCommand.scan();
			StreamJSON stream = new StreamJSON();
			try {
				switch (command.toLowerCase()) {
					case "read":
						// Reads and returns JSON contents
						System.out.println("Reading file\n");
						stream.read(filePath);
						break;
					case "write":
						// Writes to JSON file
						System.out.println("Name: ");
						InputHandler handleName = new InputHandler();
						String newName = handleName.scan();

						System.out.println("Age: ");
						InputHandler handleAge = new InputHandler();
						String newAge = handleAge.scan();
						
						System.out.println("Birthday: ");
						InputHandler handleBirthday = new InputHandler();
						String newBirthday = handleBirthday.scan();
						System.out.println();
						
						JSONObject newValues = new JSONObject();
						newValues.put("Name", newName);
						newValues.put("Age", newAge);

						JSONArray newBirthdayArray = new JSONArray();
						newBirthdayArray.add(newBirthday);
						newValues.put("Birthday", newBirthdayArray);
						
						try {
							stream.write(filePath, newValues);
							System.out.println("Changes written to file.");
						} catch (Exception e) {
							System.err.println("An error occured while writing to file." + e.getMessage());
						}
						break;
					case "exit":
						System.out.println("Exiting ...\n");
						break;
					default:
						System.out.println("Invalid command.\n");
						break;
			
				} 
			} catch (Exception e) {
				System.err.println("An error occured: " + e.getMessage());
			}
			
			if ("exit".equalsIgnoreCase(command)) {
				break;
			}
		}
	}
}

