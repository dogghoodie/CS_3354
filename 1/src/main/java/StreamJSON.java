import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StreamJSON {
	public static void read(String filePath) throws IOException, ParseException {
   		JSONParser parser = new JSONParser();
    	try (FileReader reader = new FileReader(filePath)) {
     	JSONArray jsonArray = (JSONArray) parser.parse(reader);

        // Iterates through and prints
        for (Object obj : jsonArray) {
			// Cast obj to JSONObject
            JSONObject jsonObject = (JSONObject) obj;
            // Extract each value from the JSONObject
            String name = (String) jsonObject.get("Name");
            String age = (String) jsonObject.get("Age");
            JSONArray birthdayArray = (JSONArray) jsonObject.get("Birthday");
            String birthday = (String) birthdayArray.get(0);

            System.out.println("Name: " + name + " Age: " + age + " Birthday: " + birthday);
        	System.out.println();
		}
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
}
    public static void write(String filePath, JSONObject newValues) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        // Read the existing JSON array
        try (FileReader reader = new FileReader(filePath)) {
            jsonArray = (JSONArray) parser.parse(reader);
        } catch (IOException | ParseException e) {
            jsonArray = new JSONArray(); // Creates new if issue w file
            e.printStackTrace();
        }

        // Update the first object in the array
        if (!jsonArray.isEmpty()) {
            JSONObject jsonObjectToUpdate = (JSONObject) jsonArray.get(0);

            // Update the values w newValues
            jsonObjectToUpdate.put("Name", newValues.get("Name"));
            jsonObjectToUpdate.put("Age", newValues.get("Age"));
            jsonObjectToUpdate.put("Birthday", newValues.get("Birthday"));
        } else {
            // If the array is empty, simply add the newValues object to it
            jsonArray.add(newValues);
        }

        // Write the updated JSON array back to the file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        }
    }
}

