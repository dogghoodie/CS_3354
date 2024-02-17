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
	public static void create(String filePath) throws ParseException, IOException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray;
		try (FileReader reader = new FileReader(filePath)) {
			jsonArray = (JSONArray) parser.parse(reader);
		} catch (FileNotFoundException e) {
			jsonArray = new JSONArray();
		}

		JSONObject newObject = new JSONObject();
		newObject.put("Name", "NewName");
		newObject.put("Age", "NewAge");
		newObject.put("Birthday", new JSONArray());
		((JSONArray) newObject.get("Birthday")).add("xx/xx/xx");

		jsonArray.add(newObject);

		try (FileWriter file = new FileWriter(filePath)) {
			file.write(jsonArray.toJSONString());
			file.flush();
		}
	}

	public static void read() throws IOException, ParseException {
	}
	public static void write(String filePath, JSONObject jsonObject) throws IOException{
	}
}

