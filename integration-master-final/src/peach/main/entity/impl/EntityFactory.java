/**
 * 
 */
package peach.main.entity.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import peach.main.entity.IEHR;
import peach.main.entity.IPerson;
import peach.main.utils.JSONParser;
import peach.main.utils.XMLParser;

/**
 * @author Shruti Sinha
 *
 */
public class EntityFactory {

	//private EntityFactory(){}

	/**
	 * 
	 * @param xml
	 * @return IPerson
	 */
	public static IPerson getPerson(String xml){
		return XMLParser.parsePerson(xml);
	}

	/**
	 * 
	 * @param json
	 * @param subjectId
	 * @param namespace
	 * @return IEHR
	 */
	public static IEHR getEHR(String json, String subjectId, String namespace){

		JsonObject jsonObject = JSONParser.parse(json);
		String ehrId = jsonObject.getAsJsonPrimitive("ehrId").getAsString();
		return new EHR(ehrId, subjectId, namespace);
	}

	/**
	 * 
	 * @param json
	 * @param ehrId
	 * @return IEHR
	 */
	public static IEHR getEHR(String json, String ehrId ){

		String subjectId = null;
		String namespace = null;
		JsonObject jsonObject = JSONParser.parse(json);
		JsonArray resultSet = jsonObject.getAsJsonArray("resultSet");
		if(resultSet.size() > 0){
			subjectId = resultSet.get(0).getAsJsonObject().getAsJsonPrimitive("party_ref_value").getAsString();
			namespace = resultSet.get(0).getAsJsonObject().getAsJsonPrimitive("party_ref_scheme").getAsString();
		}
		return new EHR(ehrId, subjectId, namespace);
	}
}
