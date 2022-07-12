package model;

import java.io.Serializable;

public class OrganisationEntity implements Serializable{	
	static final long serialVersionUID = 1L;
	private int orgId;
	 private String orgName;
	 private String OrgManager;
	 private String orgAddress;
	 
	 
	 public OrganisationEntity(OrgEmployee employee) {
		 
	 }
	 
	public OrganisationEntity(int orgId, String orgName, String orgManager, String orgAddress) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.OrgManager = orgManager;
		this.orgAddress = orgAddress;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgManager() {
		return OrgManager;
	}
	public void setOrgManager(String orgManager) {
		OrgManager = orgManager;
	}
	public String getOrgAddress() {
		return orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

}
