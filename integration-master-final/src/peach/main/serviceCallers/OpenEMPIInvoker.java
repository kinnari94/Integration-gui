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
	private String baseURL;// = "http://192.168.99.100:8080";		
	
	/**
	 * 
	 * @return
	 */
	private static OpenEMPIInvoker initialize(){
		OpenEMPIInvoker newInstance = new OpenEMPIInvoker();
		
		try {
			Properties properties = new Properties();		
			FileReader reader = new FileReader("conf.properties");
			properties.load(reader);
			newInstance.baseURL = properties.getProperty("OpenEMPI-baseURL");
			
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
		URL url = new URL(_instance.baseURL + "/openempi-admin/openempi-ws-rest/person-query-resource/findPersonById");
		
		HttpURLConnection hurl =(HttpURLConnection) url.openConnection();
		hurl.setRequestMethod("POST");
		hurl.setDoOutput(true); 
		hurl.setRequestProperty("OPENEMPI_SESSION_KEY", sessionCode);
		hurl.setRequestProperty("Content-Type", "application/xml"); //application/json
	    hurl.setRequestProperty("Accept", "application/xml");
	    String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"  
	    		+ "<personIdentifier>"
	    		+ "<identifier>" + subjectId + "</identifier>"
	    		+ "<identifierDomain>"
	    		+ "<namespaceIdentifier>2.16.840.1.113883.4.1</namespaceIdentifier>"
	    		+ "<universalIdentifier>2.16.840.1.113883.4.1</universalIdentifier>"
	    		+ "<universalIdentifierTypeCode>SSN</universalIdentifierTypeCode>"
	    		+ "</identifierDomain>"
	    		+ "</personIdentifier>";
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
        //System.out.println(hurl.getResponseCode());
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
		
		URL url = new URL(_instance.baseURL + "/openempi-admin/openempi-ws-rest/security-resource/authenticate");
		HttpURLConnection hurl = (HttpURLConnection) url.openConnection();
        hurl.setRequestMethod("PUT");
        hurl.setDoOutput(true);                   
        hurl.setRequestProperty("Content-Type", "application/xml"); //application/json
        hurl.setRequestProperty("Accept", "application/xml");
        String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
        		+ "<authenticationRequest><password>admin</password><username>admin</username></authenticationRequest>";
        
        OutputStreamWriter osw = new OutputStreamWriter(hurl.getOutputStream());
        osw.write(payload);
        osw.flush();
        osw.close();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(hurl.getInputStream(), "UTF-8"));
        sessionCode = in.readLine();
        
	}

}
