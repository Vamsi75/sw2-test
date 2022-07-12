package com.mycompany;

import java.io.IOException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.service.EmployeeServiceImplementation;

import model.OrgEmployee;

public class AddEmpDetails extends WebPage {
	private static final long serialVersionUID = 1L;
	int empId;
	String empName;
	String empRole;
	String empDivision;
	
	@SpringBean
	EmployeeServiceImplementation empServiceImplementation;
	
	public AddEmpDetails(int orgId) {
		Form<OrgEmployee> empForm=new Form<OrgEmployee>("empDetailsForm") {

			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				empServiceImplementation.postEmployee(new OrgEmployee(empId,empName,empRole,empDivision),orgId);
				try {
					setResponsePage(new Page1());
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		};
		empForm.add(new TextField<String>("empName", new PropertyModel<String>(this,"empName")));
		empForm.add(new TextField<Integer>("empId", new PropertyModel<Integer>(this,"empId")));
		empForm.add(new TextField<String>("empRole", new PropertyModel<String>(this,"empRole")));
		empForm.add(new TextField<String>("empDivision", new PropertyModel<String>(this,"empDivision")));
		
		add(empForm);
	}


}
