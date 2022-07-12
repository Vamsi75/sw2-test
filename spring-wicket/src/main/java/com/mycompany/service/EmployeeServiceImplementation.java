package com.mycompany.service;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
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
public class EmployeeServiceImplementation implements EmployeeService {
	
	RestTemplate restTemplate = new RestTemplate();
	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hello";
	}

	@Override
	public OrgEmployee getEmployee(String id){
		String url = "http://localhost:8081/get-employee/"+id;
	 
		ResponseEntity<OrgEmployee> response = restTemplate.getForEntity(url,OrgEmployee.class);
	  
		OrgEmployee employee = response.getBody();
		System.out.println(employee);
		return employee;
		
	}

	//get all employees
	@Override
	public List<OrgEmployee> getAllEmployees() throws IOException, InterruptedException {
		
		final String getAllEmpUrl="http://localhost:8081/emp/get-all";
		
		HttpClient client=HttpClient.newHttpClient();
		List<OrgEmployee> empList= new ArrayList<OrgEmployee>();
		HttpRequest request=HttpRequest.newBuilder(URI.create(getAllEmpUrl)).build();
		HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
		
		JSONArray jArray=new JSONArray(response.body());
		for(int i=0;i<jArray.length();i++) {
			JSONObject jobj=new JSONObject(jArray.get(i));
			empList.add(new OrgEmployee(jobj.getInt("empId"),jobj.getString("empName"),jobj.getString("empRole"),jobj.getString("empDivision")));
		}
		return empList;
		
	}

	//post employee	 
	@Override
	public void postEmployee(OrgEmployee employee, int orgId) {
		String postEmpUrl="http://localhost:8081/org/employee/add/"+orgId;
		HttpEntity<OrgEmployee> request = new HttpEntity<OrgEmployee>(employee);
		restTemplate.postForEntity(postEmpUrl, request,OrgEmployee.class);
		System.out.println(employee.getEmpName());
		
	}
	
	
	//delete employee
	public void deleteEmployee(int empId) {
		String url="http://localhost:8081/org/employee/delete/"+empId;
		restTemplate.delete(url);	
	}

	@Override
	public void updateEmployee(int empId, OrgEmployee employee) {
		String updateEmpUrl="http://localhost:8081/org/emp-update/"+empId;
		HttpEntity<OrgEmployee> requestUpdate = new HttpEntity<OrgEmployee>(employee);
		restTemplate.exchange(updateEmpUrl, HttpMethod.PUT, requestUpdate, OrgEmployee.class);
		
	}
	
}
