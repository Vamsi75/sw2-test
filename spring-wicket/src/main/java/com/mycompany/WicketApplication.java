package com.mycompany;

import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class WicketApplication extends WebApplication
{

	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	public void init()
	{
		super.init();
		getCspSettings().blocking().disabled();

		getComponentInstantiationListeners().add(new SpringComponentInjector(this));

		/*
		 * getCspSettings().blocking().clear() .add(CSPDirective.DEFAULT_SRC,
		 * CSPDirectiveSrcValue.NONE) .add(CSPDirective.SCRIPT_SRC,
		 * CSPDirectiveSrcValue.SELF) .add(CSPDirective.IMG_SRC,
		 * CSPDirectiveSrcValue.SELF) .add(CSPDirective.FONT_SRC,
		 * CSPDirectiveSrcValue.SELF); getCspSettings().reporting().strict();
		 */
		// add your configuration here
		
	}
}
