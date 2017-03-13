/**
 * 
 */
package peach.main.manager;

import peach.main.entity.IEHR;
import peach.main.entity.IPatient;
import peach.main.entity.IPerson;
import peach.main.entity.impl.EntityFactory;
import peach.main.entity.impl.Patient;
import peach.main.serviceCallers.EtherCISInvoker;
import peach.main.serviceCallers.OpenEMPIInvoker;

/**
 * @author Shruti Sinha
 *
 */
public class PatientManager {

	public PatientManager(){}
	
	/**
	 * 
	 * @param subjectId
	 * @param namespace
	 * @return
	 * @throws Exception
	 */
	public static IPatient getPatientDetailsFromSubjectId(String subjectId, String namespace) throws Exception{
				
		String jsonResponse = EtherCISInvoker.getEhrStatusFromSubjectId(subjectId);
		String xmlResponse = OpenEMPIInvoker.getPersonById(subjectId, namespace);
		
		IPerson person = EntityFactory.getPerson(xmlResponse);
		IEHR ehr = EntityFactory.getEHR(jsonResponse, subjectId, namespace);
		
		return new Patient(person, ehr);
	}
	
	/**
	 * 
	 * @param ehrId
	 * @return
	 * @throws Exception
	 */
	public static IPatient getPatientDetailsFromEHRId(String ehrId) throws Exception{
		
		String jsonResponse = EtherCISInvoker.getSubjectIDFromEHRId(ehrId);	
		IEHR ehr = EntityFactory.getEHR(jsonResponse, ehrId);
		
		String xmlResponse = OpenEMPIInvoker.getPersonById(ehr.getSubjectId(), ehr.getNamespace());
		IPerson person = EntityFactory.getPerson(xmlResponse);
		
		return new Patient(person, ehr);
	}
	
}
