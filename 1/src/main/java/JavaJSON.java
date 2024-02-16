import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class JavaJSON {
	public static void main(String[] args) {
		InputHandler input = new InputHandler();
		String data = input.scan();
		System.out.println(data);
	}
}
