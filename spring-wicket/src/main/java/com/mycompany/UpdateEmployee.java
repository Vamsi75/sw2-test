package com.mycompany;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.service.EmployeeServiceImplementation;

import model.OrgEmployee;

public class UpdateEmployee extends WebPage{
	
	int empId;
	String empName;
	String empRole;
	String empDivision;
	@SpringBean
	EmployeeServiceImplementation empServiceImplementation;
	
	public UpdateEmployee(int empId) {
		Form<OrgEmployee> empForm1=new Form<OrgEmployee>("empDetailsForm1") {

			private static final long serialVersionUID = 1L;

			protected void onSubmit() {
				 empServiceImplementation.updateEmployee(empId,new OrgEmployee(empId,empName,empRole,empDivision));
				try {
					empServiceImplementation.updateEmployee(empId,new OrgEmployee(empId,empName,empRole,empDivision));
					setResponsePage(new Page2());
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		};
		empForm1.add(new TextField<String>("empRole1", new PropertyModel<String>(this,"empRole")));
		empForm1.add(new TextField<String>("empDivision1", new PropertyModel<String>(this,"empDivision")));
		add(empForm1);
	}
	
}

