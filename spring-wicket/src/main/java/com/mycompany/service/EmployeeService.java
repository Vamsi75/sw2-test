package com.mycompany.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import model.OrgEmployee;

public interface EmployeeService {
	String sayHello();
	OrgEmployee getEmployee(String id);
	List<OrgEmployee> getAllEmployees() throws IOException, InterruptedException;
	void postEmployee(OrgEmployee employee,int orgId);
	void deleteEmployee(int empId);
	void updateEmployee(int empId,OrgEmployee employee);
	
	

}
