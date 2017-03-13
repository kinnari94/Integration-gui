import java.util.Iterator;
import java.util.List;

import peach.main.entity.IEHR;
import peach.main.entity.IPatient;
import peach.main.entity.IPerson;
import peach.main.entity.impl.Person;
import peach.main.entity.impl.Person.Genders;
import peach.main.entity.impl.Person.PersonIdentifiers;
import peach.main.entity.impl.Person.Race;
import peach.main.manager.PatientManager;
import peach.main.intface.EhrId;
/**
 * @author Shruti Sinha
 *
 */
public class IntegrationTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		// Display patient demographics based on ehrID
		
		String ehrvalue = EhrId.ehrval.getText();
		IPatient patient = PatientManager.getPatientDetailsFromEHRId(ehrvalue);
		
		// Display patient demographics based on subject Id and namespace
		//Patient patient = PatientManager.getPatientDetailsFromSubjectId("2000", "SSN");
		
		IEHR ehr = patient.getEhr();
		System.out.println(ehr.getehrId());   
		System.out.println(ehr.getSubjectId());  
		
		IPerson person = patient.getPerson();
		System.out.println(person.getGivenName());   
		System.out.println(person.getCity());   
		System.out.println(person.getCountry());
		System.out.println(person.getPhoneCountryCode());
		System.out.println(person.getFamilyName());
		System.out.println(person.getDateOfBirth());

		Person.Genders pp = (Genders) person.getGenders();
		System.out.println("GenderDescription: "+pp.getGenderDescription());
		
		Person.Race race = (Race) person.getRace();
		System.out.println("Race: "+race.getRaceDescription());
		
		List<Person.PersonIdentifiers> plist = ((Person) person).getPersonIdentifiers();
		Iterator<PersonIdentifiers> itr = plist.iterator();
		while(itr.hasNext()){
			PersonIdentifiers p = (PersonIdentifiers)itr.next();
			System.out.println("Identifier :" + p.getIdentifier());
		}
	}
}
