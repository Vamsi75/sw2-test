package com.mycompany;



import java.io.IOException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.service.EmployeeService;

import model.OrgEmployee;

public class Page2 extends HomePage {
	private static final long serialVersionUID = 1L;
	@SpringBean  
	EmployeeService empService;
	
	public Page2() throws IOException, InterruptedException {
		

		add(new Label("page2label"));
		
		//add(new Label("getOneEmp",empService.getEmployee("56").getEmpName()));
		
		DataView<OrgEmployee> employeeList=new DataView<OrgEmployee>("empList",new ListDataProvider<OrgEmployee>(empService.getAllEmployees())){
		private static final long serialVersionUID = 1L;
		protected void populateItem(Item<OrgEmployee> item) 
		{
			OrgEmployee emp=item.getModelObject();
			item.add(new Label("empName",emp.getEmpName()));
			item.add(new Label("empId",emp.getEmpId()));
			item.add(new Label("empRole",emp.getEmpRole()));
			item.add(new Label("empDivision",emp.getEmpDivision()));
			item.add(new Link<OrgEmployee>("delEmployee") {
				public void onClick() {
					empService.deleteEmployee(emp.getEmpId());
					try {
						setResponsePage(new Page2());
					} catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			item.add(new Link<OrgEmployee>("updateEmployee") {
				public void onClick() {
						setResponsePage(new UpdateEmployee(emp.getEmpId()));
				}
				
			});
		}
			
		};
		add(employeeList);
		System.out.println(employeeList);
		 
		
		//add(new Label("postEmployee"));
		//empService.postEmployee(6);
		
	
		
	}
}
