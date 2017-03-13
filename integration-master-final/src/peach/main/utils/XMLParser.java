/**
 * 
 */
package peach.main.utils;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import peach.main.entity.IPerson;
import peach.main.entity.impl.Person;
/**
 * @author Shruti Sinha
 *
 */
public class XMLParser {

	/**
	 * 
	 * @param input
	 * @return
	 */
	public static IPerson parsePerson(String input){
		Person person = null;
		try {  
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);  
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); 

			StringReader reader = new StringReader(input);
			person= (Person) jaxbUnmarshaller.unmarshal(reader);  

		} catch (JAXBException e) {  
			e.printStackTrace();  
		}
		return person;  

	}

}

