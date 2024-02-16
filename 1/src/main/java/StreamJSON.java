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
	public static void read() throws IOException, ParseException {
		/*JSONParser paser = new JSONParser();
		try (FileReader reader = new FileReader(filePath)) {
			return (JSONObject) parser.parse(reader);
		}*/	
	}
	public static void write(String filePath, JSONObject jsonObject) throws IOException{
		/*try(FileWriter file = new FileWriter(filePath)) {
			file.write(jsonObject.toJSONString());
		}*/
	}
	public static void stream(String readPath, String writePath) {
		/*try {
			JSONObject sonObject = read(readPath);
			write(writePath, jsonObject);

		} catch (IOException | ParseException e){
			e.printStackTrace();
		}*/
	}
}
