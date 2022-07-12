package com.mycompany;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.service.OrganisationServiceImplementation;

import model.OrganisationEntity;

public class UpdateOrgDetails extends WebPage {
	private static final long serialVersionUID = 1L;
	int orgId;
	String orgName;
	String orgManager;
	String orgAddress;
	
	@SpringBean
	OrganisationServiceImplementation org;
	
	public UpdateOrgDetails(int orgId) {
		Form<OrganisationEntity> orgForm_update=new Form<OrganisationEntity>("OrgDetailsForm_update") {
			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				
				org.updateorgdetails(orgId, new OrganisationEntity(orgId,orgName,orgManager,orgAddress));
				try {
					org.updateorgdetails(orgId,new OrganisationEntity(orgId,orgName,orgManager,orgAddress));
					setResponsePage(new Page1());
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};	
		
		orgForm_update.add(new TextField<String>("update_orgManager", new PropertyModel<String>(this,"orgManager")));
		orgForm_update.add(new TextField<String>("update_orgAddress", new PropertyModel<String>(this,"orgAddress")));
		
		add(orgForm_update);

	}
}
