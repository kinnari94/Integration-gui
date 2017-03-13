/**
 * 
 */
package peach.main.utils;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author Shruti Sinha
 *
 */
public class JSONParser {
	
/**		public static EHR parseEHRId(String json){
		Gson gson= new Gson();
		StringReader reader = new StringReader(json);
		EHR ehr = gson.fromJson(reader, EHR.class);
		return ehr;
	}
*/	
	
	/**
	 * 
	 * @param json
	 * @return JSON object
	 */
	public static JsonObject parse(String json){
		Gson gson= new Gson();
		StringReader reader = new StringReader(json);
		JsonObject jsonObject = gson.fromJson(reader, JsonElement.class).getAsJsonObject();
		return jsonObject;
	}
}
