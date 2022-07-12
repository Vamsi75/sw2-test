package com.mycompany;


import java.io.IOException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.service.OrganisationService;

import model.OrgEmployee;
import model.OrganisationEntity;

public class Page1 extends HomePage {

	private static final long serialVersionUID = 1L;
	@SpringBean
	OrganisationService orgService;

	public Page1() throws IOException, InterruptedException {
		
		
       add(new Link<AddOrgDetails>("addOrg") {
		private static final long serialVersionUID = 1L;

		public void onClick() {
    		   setResponsePage(new AddOrgDetails());   
    	   }
       });
       

		
		
		add(new Label("page1label"));
		//add(new Label("orgdetails",orgService.getOrganisationbyId(1).getOrgName()));
		//add(new Label("postOrg"));
		//orgService.postOrganisation();
		//add(new Label("delOrg"));
	
		DataView<OrganisationEntity> orgList=new DataView<OrganisationEntity>("orgData",new ListDataProvider<OrganisationEntity>(orgService.getAll())){

			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(Item<OrganisationEntity> item) {
				OrganisationEntity org=item.getModelObject();
				item.add(new Label("orgId",org.getOrgId()));
				item.add(new Label("orgName",org.getOrgName()));
				item.add(new Label("orgManager",org.getOrgManager()));
				item.add(new Label("orgAddress",org.getOrgAddress()));
				item.add(new Link<OrgEmployee>("addEmployees") {
					public void onClick() {
						setResponsePage(new AddEmpDetails(org.getOrgId()));
					}
				});
				item.add(new Link<OrganisationEntity>("delOrganisation") {
					public void onClick() {
					orgService.deleteById(org.getOrgId());
					try {
						setResponsePage(new Page1());
					} catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					}
				});
				
				item.add(new Link<OrganisationEntity>("updateOrganisation") {
					private static final long serialVersionUID = 1L;

					public void onClick() {
							setResponsePage(new UpdateOrgDetails(org.getOrgId()));
					}
					
				});
			}
		};
		add(orgList);
		System.out.println(orgList);
		
	}
}
