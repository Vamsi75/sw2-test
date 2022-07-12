package com.mycompany;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;

import model.OrgEmployee;

import java.io.IOException;



public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
    OrgEmployee emp=new OrgEmployee();
	public HomePage() {
		  add(new BookmarkablePageLink<Object>("page1",Page1.class));
		  add(new BookmarkablePageLink<Object>("page2",Page2.class));
		  add(new Label("footer","use above links to redirecting operations"));
	}
}
