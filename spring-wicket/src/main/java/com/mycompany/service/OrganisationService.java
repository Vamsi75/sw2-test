package com.mycompany.service;

import java.io.IOException;
import java.util.List;

import model.OrganisationEntity;

public interface OrganisationService {
	
	OrganisationEntity getOrganisationbyId(int id);
	void postOrganisation(OrganisationEntity organisationEntity);
	List<OrganisationEntity> getAll() throws IOException, InterruptedException;
	void deleteById(int orgId);
	void updateorgdetails(int orgId,OrganisationEntity organisation);
	

}
