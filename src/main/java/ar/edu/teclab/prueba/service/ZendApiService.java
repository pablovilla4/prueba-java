package ar.edu.teclab.prueba.service;


import org.springframework.http.HttpHeaders;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import org.json.*;


//@Component
public class ZendApiService {	
	
	private static final String user = "jorge.danni@teclab.edu.ar";
	private static final String pass = "Abril2019";
	
	
	public String getCommentsTicket(int id) {
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(this.user, this.pass));
		final String response = restTemplate.getForObject("https://teclab1593636133.zendesk.com/api/v2/tickets/"+ String.valueOf(id) + "/comments.json", String.class);		
		JSONObject rdo = new JSONObject(response);		
		JSONArray comments =  (JSONArray) rdo.get("comments");		
		return comments.toString();
	}
	
	
}
