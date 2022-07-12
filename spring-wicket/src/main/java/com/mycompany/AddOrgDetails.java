package com.mycompany;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.service.OrganisationServiceImplementation;

import model.OrganisationEntity;

public class AddOrgDetails extends WebPage {
	private static final long serialVersionUID = 1L;
	
	String orgName;
	int orgId;
	String orgManager;
	String orgAddress;
	
	@SpringBean
	OrganisationServiceImplementation org;
	
	public AddOrgDetails() {
		Form<OrganisationEntity> orgForm=new Form<OrganisationEntity>("OrgDetailsForm") {
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				
				org.postOrganisation(new OrganisationEntity(orgId,orgName,orgManager,orgAddress));
				try {
					setResponsePage(new Page1());
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};	
		
		orgForm.add(new TextField<String>("orgName", new PropertyModel<String>(this,"orgName")));
		orgForm.add(new TextField<Integer>("orgId", new PropertyModel<Integer>(this,"orgId")));
		orgForm.add(new TextField<String>("orgManager", new PropertyModel<String>(this,"orgManager")));
		orgForm.add(new TextField<String>("orgAddress", new PropertyModel<String>(this,"orgAddress")));
		
		add(orgForm);

	}
	
	public void deleteOrgbyId() {
	
	}

}
