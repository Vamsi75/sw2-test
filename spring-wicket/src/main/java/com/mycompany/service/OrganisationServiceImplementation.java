package com.mycompany.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.PropertyModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.openjson.JSONArray;
import com.github.openjson.JSONObject;

import model.OrgEmployee;
import model.OrganisationEntity;
@Service
public class OrganisationServiceImplementation implements OrganisationService {
	
	RestTemplate restTemplate=new RestTemplate();
	
	
	
	@Override
	public OrganisationEntity getOrganisationbyId(int id) {
		
		String url="http://localhost:8081/org/get-details-of/"+id;
		
		ResponseEntity<OrganisationEntity> response=restTemplate.getForEntity(url,OrganisationEntity.class);
		
		return response.getBody();
	
	}

	@Override
	public void postOrganisation(OrganisationEntity organisationEntity)
	{

		String postOrgUrl="http://localhost:8081/org/add-details";

		HttpEntity<OrganisationEntity> request = new HttpEntity<OrganisationEntity>(organisationEntity);
		restTemplate.postForEntity(postOrgUrl, request,OrganisationEntity.class);
		}

	@Override
	public List<OrganisationEntity> getAll() throws IOException, InterruptedException {
			
		final String getAllEmpUrl="http://localhost:8081/org/get-orgdetails";
			
		HttpClient client=HttpClient.newHttpClient();
		List<OrganisationEntity> orgList= new ArrayList<OrganisationEntity>();
		HttpRequest request=HttpRequest.newBuilder(URI.create(getAllEmpUrl)).build();
		HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
		
		JSONArray jArray=new JSONArray(response.body());
		for(int i=0;i<jArray.length();i++) {
			JSONObject jobj=new JSONObject(jArray.get(i));
			orgList.add(new OrganisationEntity(jobj.getInt("orgId"),jobj.getString("orgName"),jobj.getString("orgManager"),jobj.getString("orgAddress")));
		}
		return orgList;
			
		
	}

	@Override
	public void deleteById(int orgId)
	{
		final String delOrgUrl="http://localhost:8081/org/delete-/"+orgId;
		restTemplate.delete(delOrgUrl);
		
	}

	@Override
	public void updateorgdetails(int orgId, OrganisationEntity organisation) {
		final String updateOrgUrl="http://localhost:8081/org/update-org/"+orgId;
		HttpEntity<OrganisationEntity> requestUpdate = new HttpEntity<OrganisationEntity>(organisation);
		restTemplate.exchange(updateOrgUrl, HttpMethod.PUT, requestUpdate, OrganisationEntity.class);
		
		
	}
}



