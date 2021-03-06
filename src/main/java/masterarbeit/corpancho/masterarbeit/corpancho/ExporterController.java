package masterarbeit.corpancho.masterarbeit.corpancho;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;


@Service
public class ExporterController {
	
	private String iteraplanHost = "http://localhost";
	private String iteraplanPort = "1234";
	
	private String serverConfig = iteraplanHost+":"+iteraplanPort+"/iteraplan/api/element/InformationSystem";
	 
    public static final Logger logger = LoggerFactory.getLogger(ExporterController.class);
    
    public void makeHTTPPOSTRequest(BusinessApplication ba) {
    	
    	String url = this.serverConfig;
    	System.out.println("makeHTTPPOSTRequest to URL: "+url);
    	HttpMethod httpMethod = HttpMethod.POST;
    	
    	//TODO: Convert BusinessApplication in HttpEntity
    	String baString = ba.toString();
    	HttpEntity<String> entity = new HttpEntity<String>(baString);
    	
    	try {
    		add(url, httpMethod, entity);
    	}
        catch(Exception e) {
            System.out.println("Exception: "+e);
        }
    	finally {
    		
    	}
                              
    } 
    
    public ResponseEntity<String> add(String url, HttpMethod httpMethod, HttpEntity<String> entity) {
        return send(url, httpMethod, entity);
    }
    
    private ResponseEntity<String> send(String url, HttpMethod httpMethod, HttpEntity<String> entity) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(getCustomRequestFactory());
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate.exchange(url, httpMethod, entity, String.class);
    }
    
    private ClientHttpRequestFactory getCustomRequestFactory() {
        return new MySimpleClientHttpRequestFactory(new NullHostnameVerifier(), null);
    }    
    
    // ------------------- MASSDATA BusinessApplications in iteraplan  ------------------------------------------------
	//TODO

	 
	}
