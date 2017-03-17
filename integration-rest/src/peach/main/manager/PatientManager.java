/**
 * 
 */
package peach.main.manager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import peach.main.entity.IEHR;
import peach.main.entity.IPatient;
import peach.main.entity.IPerson;
import peach.main.entity.impl.EntityFactory;
import peach.main.entity.impl.Patient;
import peach.main.serviceCallers.EtherCISInvoker;
import peach.main.serviceCallers.OpenEMPIInvoker;

@Path("/integration")

/**
 * @author Shruti Sinha
 *
 */
public class PatientManager {
	
	//http://localhost:8080/integration-rest/rest/integration/patientDetailsFromEHRId?ehrId=95020099-4af4-4cdb-bf5d-b07621ced587
	//http://localhost:8080/integration-rest/rest/integration/patientDetailsFromSubjectId?subjectId=2000&namespace=NHS

	public PatientManager(){}
	
	@GET
	@Path("/patientDetailsFromSubjectId")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * 
	 * @param subjectId
	 * @param namespace
	 * @return
	 * @throws Exception
	 */
	public static String getPatientDetailsFromSubjectId(@QueryParam("subjectId") String subjectId,@QueryParam("namespace") String namespace) throws Exception{
			
		if(subjectId == null && namespace == null){
			throw new Exception("Subject Id or namesapce is null");
		}
		String jsonResponse = EtherCISInvoker.getEhrStatusFromSubjectId(subjectId, namespace);
		String xmlResponse = OpenEMPIInvoker.getPersonById(subjectId, namespace);
		
		IPerson person = EntityFactory.getPerson(xmlResponse);
		IEHR ehr = EntityFactory.getEHR(jsonResponse, subjectId, namespace);
		
		IPatient patient = new Patient(person, ehr);
		Gson gson = new Gson();
		String json;
		json = gson.toJson(patient);
		return json;
	}
	
	
	@GET
	@Path("/patientDetailsFromEHRId")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * 
	 * @param ehrId
	 * @return
	 * @throws Exception
	 */
	public static String getPatientDetailsFromEHRId(@QueryParam("ehrId") String ehrId) throws Exception{
		
		if(ehrId == null){
			throw new Exception("EHR id is null");
		}
		String jsonResponse = EtherCISInvoker.getSubjectIDFromEHRId(ehrId);	
		IEHR ehr = EntityFactory.getEHR(jsonResponse, ehrId);
		
		String xmlResponse = OpenEMPIInvoker.getPersonById(ehr.getSubjectId(), ehr.getNamespace());
		IPerson person = EntityFactory.getPerson(xmlResponse);
		
		IPatient patient = new Patient(person, ehr);
		Gson gson = new Gson();
		String json;
		json = gson.toJson(patient);
		return json;
	}
}
