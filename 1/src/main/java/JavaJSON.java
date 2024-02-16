import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class JavaJSON {
	public static void main(String[] args) {
		System.out.print("Enter: ");

		InputHandler handle = new InputHandler();
		String input = handle.scan();
		System.out.println(input);
	}
}
