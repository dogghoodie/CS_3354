import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StreamJSON {
    private static HashMap<String, JSONObject> jsonMap = new HashMap<>();

    public static void read(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            jsonMap.clear(); // Clear the map before loading new objects

            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String name = (String) jsonObject.get("Name");
                jsonMap.put(name, jsonObject); // Populate the map

                String age = (String) jsonObject.get("Age");
                JSONArray birthdayArray = (JSONArray) jsonObject.get("Birthday");
                String birthday = (String) birthdayArray.get(0);

                System.out.println("Name: " + name + " Age: " + age + " Birthday: " + birthday);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void write(String filePath, JSONObject newValues) throws IOException {
        JSONArray jsonArray = new JSONArray();

        // Update the JSON object in the map if it exists; add otherwise
        String nameKey = (String) newValues.get("Name");
        JSONObject jsonObjectToUpdate = jsonMap.get(nameKey);
        if (jsonObjectToUpdate != null) {
            jsonObjectToUpdate.putAll(newValues);
        } else {
            jsonMap.put(nameKey, newValues);
        }

        // Convert the map back to a JSONArray for writing to the file
        for (JSONObject jsonObj : jsonMap.values()) {
            jsonArray.add(jsonObj);
        }

        // Write the updated JSON array back to the file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();

        }
    }
    public static void modify(String filePath, String nameKey, JSONObject modifications) throws IOException {
        // Check if the JSON object exists in the map
        JSONObject jsonObjectToModify = jsonMap.get(nameKey);
        if (jsonObjectToModify != null) {
            // Iterate over the keys in the modifications JSONObject
            for (Object key : modifications.keySet()) {
                // Update the existing JSON object with the new values
                jsonObjectToModify.put(key, modifications.get(key));
            }

            // Update the jsonMap with the modified object
            jsonMap.put(nameKey, jsonObjectToModify);

            // Convert the map back to a JSONArray
            JSONArray jsonArray = new JSONArray();
            for (JSONObject jsonObj : jsonMap.values()) {
                jsonArray.add(jsonObj);
            }

            // Write the updated JSON array back to the file
            try (FileWriter file = new FileWriter(filePath)) {
                file.write(jsonArray.toJSONString());
                file.flush();
            }
        } else {
            System.out.println("No JSON object found with the name: " + nameKey);
        }
    }
}

