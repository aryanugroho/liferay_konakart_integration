package com.liferay.konakart;

import com.konakart.ws.KKWSEngIf;
import com.liferay.konakart.service.LPruductLocalServiceUtil;
import com.liferay.konakart.util.KKWsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.net.URL;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class DetailPortlet
 */
public class DetailPortlet extends MVCPortlet {
 
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		
		String webServiceAddress = KKWsUtil.getWebServiceAddress(renderRequest);
		
		String serviceUrl = StringUtil.replace(webServiceAddress,
			"services/KKWebServiceEng?wsdl", "");
		
		URL url = new URL(webServiceAddress);	
		
		KKWSEngIf kkWSEng = KKWsUtil.getKKWsEngUtil(url);
		
		LPruductLocalServiceUtil.setKKWsEng(kkWSEng);
		
	}	
}
