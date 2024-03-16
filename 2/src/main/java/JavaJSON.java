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

        InputHandler handleFile = new InputHandler();
        String filePath = handleFile.scan();
        System.out.println("Accessing: " + filePath + "\n");

        System.out.println("Commands: \n");
        System.out.println("read, write, modify, exit\n");

        // Declare variables for input handling here
        String newName, newAge, newBirthday, modifyName;
        JSONArray newBirthdayArray;

        while (true) {
            System.out.print("Enter: ");

            InputHandler handleCommand = new InputHandler();
            String command = handleCommand.scan();
            StreamJSON stream = new StreamJSON();
            try {
                switch (command.toLowerCase()) {
                    case "read":
                        System.out.println("Reading file\n");
                        stream.read(filePath);
                        break;
                    case "write":
                        System.out.println("Name: ");
                        newName = handleFile.scan(); // Reusing handleFile for simplicity

                        System.out.println("Age: ");
                        newAge = handleFile.scan();

                        System.out.println("Birthday: ");
                        newBirthday = handleFile.scan();
                        System.out.println();

                        JSONObject newValues = new JSONObject();
                        newValues.put("Name", newName);
                        newValues.put("Age", newAge);

                        newBirthdayArray = new JSONArray();
                        newBirthdayArray.add(newBirthday);
                        newValues.put("Birthday", newBirthdayArray);

                        stream.write(filePath, newValues);
                        System.out.println("Changes written to file.");
                        break;
                    case "modify":
                        System.out.println("Enter the name of the person you want to modify:");
                        modifyName = handleFile.scan();

                        JSONObject modifications = new JSONObject();

                        System.out.println("Enter the new age (leave blank if unchanged):");
                        newAge = handleFile.scan();
                        if (!newAge.isEmpty()) {
                            modifications.put("Age", newAge);
                        }

                        System.out.println("Enter the new birthday (leave blank if unchanged):");
                        newBirthday = handleFile.scan();
                        if (!newBirthday.isEmpty()) {
                            newBirthdayArray = new JSONArray();
                            newBirthdayArray.add(newBirthday);
                            modifications.put("Birthday", newBirthdayArray);
                        }

                        if (!modifications.isEmpty()) {
                            stream.modify(filePath, modifyName, modifications);
                            System.out.println("Object modified successfully.");
                        } else {
                            System.out.println("No modifications provided.");
                        }
                        break;
                    case "exit":
                        System.out.println("Exiting ...\n");
                        return;
                    default:
                        System.out.println("Invalid command.\n");
                        break;
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }
}


