package peach.main.serviceCallers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;


/**
 * @author Shruti Sinha
 *
 */
public class OpenEMPIInvoker {
	
	private static String sessionCode; 
	private static final OpenEMPIInvoker _instance = initialize();
	private String baseURL;
	private String username;
	private String password;
	
	/**
	 * 
	 * @return
	 */
	private static OpenEMPIInvoker initialize(){
		OpenEMPIInvoker newInstance = new OpenEMPIInvoker();
		
		try {
			Properties properties = new Properties();		
			FileReader reader = new FileReader("config.properties");
			properties.load(reader);
			newInstance.baseURL = properties.getProperty("OpenEMPI-baseURL");
			newInstance.username = properties.getProperty("OpenEMPI-username");
			newInstance.password = properties.getProperty("OpenEMPI-password");
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return newInstance;
	}
	
	/**
	 * 
	 * @param subjectId
	 * @param namespace
	 * @return
	 * @throws Exception
	 */
	public static String getPersonById(String subjectId, String namespace) throws Exception{
		
		if(subjectId == null && namespace ==null ){
			throw new Exception("Subject Id or namespace is null");
		}
		
		getSessionCode();
		//URL url = new URL(_instance.baseURL + "/openempi-admin/openempi-ws-rest/person-query-resource/findPersonById");
		URL url = new URL("http://192.168.99.100:8080/openempi-admin/openempi-ws-rest/person-query-resource/findPersonById");
		HttpURLConnection hurl =(HttpURLConnection) url.openConnection();
		hurl.setRequestMethod("POST");
		hurl.setDoOutput(true); 
		hurl.setRequestProperty("OPENEMPI_SESSION_KEY", sessionCode);
		hurl.setRequestProperty("Content-Type", "application/xml"); //application/json
	    hurl.setRequestProperty("Accept", "application/xml");
	    
	    String payload = null;
	    if(namespace.equals("NHS") || namespace.equals("uk.nhs.nhs_number")){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>" //TODO : To be modified accordingly
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>" //TODO : To be modified accordingly
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>" //TODO : To be modified accordingly
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if(namespace.equals("SSN")){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "VirginiaDLN"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "OpenMRS"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "IHENA"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "IHELOCAL"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "XREF2005"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "HIMSS2005"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "NIST2010"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "NIST2010-2"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "NIST2010-3"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    else if (namespace == "ECID"){
	    	payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
		    		+ "<personIdentifier>"
		    		+ "<identifier>" + subjectId + "</identifier>"
		    		+ "<identifierDomain>"
		    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
		    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
		    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
		    		+ "</identifierDomain>"
		    		+ "</personIdentifier>";
	    }
	    
	    OutputStreamWriter osw = new OutputStreamWriter(hurl.getOutputStream());
        osw.write(payload);
        osw.flush();
        osw.close();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(hurl.getInputStream(), "UTF-8"));  
        String response = "";
        String line;
        while((line = in.readLine())!=null){
        	response += line;	
        }          
        return response;
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getPerson() throws Exception{
		
		getSessionCode();
		URL url = new URL(_instance.baseURL + "/openempi-admin/openempi-ws-rest/person-query-resource/loadAllPersonsPaged?firstRecord=0&maxRecords=100");
		
		HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
        hurl.setRequestMethod("GET");
        hurl.setDoOutput(true);
        hurl.setRequestProperty("Content-Type", "application/xml"); //application/json
	    hurl.setRequestProperty("Accept", "application/xml");
        hurl.setRequestProperty("OPENEMPI_SESSION_KEY", sessionCode);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(hurl.getInputStream(), "UTF-8"));
        String line;
        while((line = in.readLine())!=null)
        	System.out.println(line);
        return line;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	private static void getSessionCode() throws Exception{
		
		//URL url = new URL(_instance.baseURL + "/openempi-admin/openempi-ws-rest/security-resource/authenticate");
		URL url = new URL("http://192.168.99.100:8080/openempi-admin/openempi-ws-rest/security-resource/authenticate");
		HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
        hurl.setRequestMethod("PUT");
        hurl.setDoOutput(true);                   
        hurl.setRequestProperty("Content-Type", "application/xml"); //application/json
        hurl.setRequestProperty("Accept", "application/xml");
        String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
        		+ "<authenticationRequest><password>"+ _instance.password + "</password><username>" + _instance.username + "</username></authenticationRequest>";
        
        //String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
        	//	+ "<authenticationRequest><password>admin</password><username>admin</username></authenticationRequest>";
        
        OutputStreamWriter osw = new OutputStreamWriter(hurl.getOutputStream());
        osw.write(payload);
        osw.flush();
        osw.close();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(hurl.getInputStream(), "UTF-8"));
        sessionCode = in.readLine();
        
	}

}
