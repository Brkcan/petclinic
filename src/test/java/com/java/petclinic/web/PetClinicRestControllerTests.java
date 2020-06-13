package com.java.petclinic.web;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.java.petclinic.model.Owner;

public class PetClinicRestControllerTests {

	private RestTemplate restTemplate;
	
	@Before
	public void setUp() { // setUp metotları test metotları çalışmadan evvel çalısır bir nevi testin initialize'nı sağlar
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testDeleteOwner() {
		
		restTemplate.delete("http://localhost:8080/rest/owner/2");
	}
	
	@Test
	public void testOpdateOwner() {
		Owner owner = restTemplate.getForObject("http://localhost:8080/rest/owner/2", Owner.class);
		
		owner.setFirstName("Selam");
		owner.setLastName("Can");
		restTemplate.put("http://localhost:8080/rest/owner/2", owner);
	}
	
	@Test
	public void testCreateOwner() {
		Owner owner = new Owner(); 
		owner.setFirstName("Burak");
		owner.setLastName("Can");
		
		URI location = restTemplate.postForLocation("http://localhost:8080/rest/owner", owner);
		
		Owner owner2 = restTemplate.getForObject(location, Owner.class);
		
	}
	
	@Test
	public void testGetOwnerById() {
		ResponseEntity<Owner> response =  restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
		
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(200));
		MatcherAssert.assertThat(response.getBody().getFirstName(), Matchers.equalTo("Burak"));
	}
	
	@Test
	public void testGetOwnersByLastName() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=can", List.class);
		
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		List<Map<String,String>> body = response.getBody();
		
		List<String> firstName =  body.stream().map(e -> e.get("firstName")).collect(Collectors.toList()); 
		
		MatcherAssert.assertThat(firstName, Matchers.containsInAnyOrder("Burak"));
		
	}
	
	@Test
	public void testGetOwners() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/rest/owners", List.class);
		MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
		
		List<Map<String,String>> body = response.getBody();
		
		List<String> firstName =  body.stream().map(e -> e.get("firstName")).collect(Collectors.toList()); 
		
		MatcherAssert.assertThat(firstName, Matchers.containsInAnyOrder("Burak"));
		
	}
	
	
}

