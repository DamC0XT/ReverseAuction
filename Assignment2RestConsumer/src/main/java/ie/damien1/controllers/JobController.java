package ie.damien1.controllers;


import java.lang.System.Logger;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;


import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import ie.damien1.jsonClass.Bid;
import ie.damien1.jsonClass.Job;

@Controller
public class JobController {
	
	
	
	
	@GetMapping("/jobs")
	public String showJobs(Model model) {
		
		RestTemplate rTemplate = new RestTemplate();


		
		String URL = "http://localhost:8080/api/jobs";
		
		
		ResponseEntity<List<Job>> rEntity = rTemplate.exchange(
				
				URL,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Job>>() {}
				
				);
		
		List<Job> jobs = rEntity.getBody();
		
		model.addAttribute("job",jobs);
		
		return "jobs";

		
	}
	
	
	
	@GetMapping("/showBid/{id}")
	public String showBid(@PathVariable(name="id") int id, Model model){
		RestTemplate rTemplate = new RestTemplate();
		
	
		
	
	
	Bid bid = rTemplate.getForObject("http://localhost:8080/api/bidID/{Id}", Bid.class, id);
	
	model.addAttribute("bid", bid);
	
	return "showBid";
	
	}
	
	
	HttpHeaders createHeaders(String username, String password) {
		
		
		return new HttpHeaders () {{
			
			
			String auth = username + ":" + password;
			
			byte[] encodeStringtoBytes = auth.getBytes(StandardCharsets.UTF_8);
			
			byte[] encodedAuth = Base64.encodeBase64(encodeStringtoBytes);
			
			String authHeader  = "Basic" + new String(encodedAuth);
			
			set(HttpHeaders.AUTHORIZATION,authHeader);
			
		}
			
			
		};
		
		
		
		
	}

}
