package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {

	public static String convertJsonFileToString(String fileName) {
    	try {
    		JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\"+fileName+".json"));
			return jsonObject.toString();
		} catch (Exception e) {
			System.out.println("Error");
		}
		return null;
	}
}
