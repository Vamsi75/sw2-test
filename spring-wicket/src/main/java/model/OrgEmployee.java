package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OrgEmployee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int empId;
	private String empName;
    private String empDivision;
    private String empRole;
    
    public OrgEmployee() {}
    
    public OrgEmployee(int empId, String empName, String empRole, String empDivision) {
    	this.empId=empId;
    	this.empName=empName;
    	this.empDivision=empDivision;
    	this.empRole=empRole;
    }
    
    public OrgEmployee(OrgEmployee orgEmployee) {
    	
    }
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDivision() {
		return empDivision;
	}
	public void setEmpDivision(String empDivision) {
		this.empDivision = empDivision;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

}
