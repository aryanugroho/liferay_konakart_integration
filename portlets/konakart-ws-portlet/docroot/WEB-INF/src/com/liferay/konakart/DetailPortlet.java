package com.liferay.konakart;

import com.konakart.ws.KKWSEngIf;
import com.liferay.konakart.service.LPruductLocalServiceUtil;
import com.liferay.konakart.util.KKWsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.net.URL;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class DetailPortlet
 */
public class DetailPortlet extends MVCPortlet {
 
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		String webServiceAddress = getWebServiceAddress(renderRequest);
		
		String serviceUrl = StringUtil.replace(webServiceAddress,
			"services/KKWebServiceEng?wsdl", "");
		
		URL url = new URL(webServiceAddress);	
		

		KKWSEngIf kkWSEng = KKWsUtil.getKKWsEngUtil(url);
		
		LPruductLocalServiceUtil.setKKWsEng(kkWSEng);
		
	}
	
	protected String getWebServiceAddress(RenderRequest renderRequest) {
		String address = 
			"http://www.konakart.com/konakart/services/KKWebServiceEng?wsdl";

		String webServiceAddress = 
			PrefsParamUtil.getString(getPortletPreferences(renderRequest), 
				renderRequest, "webServiceAddress");

		if (Validator.isNotNull(webServiceAddress)) {
			address = webServiceAddress;
		}

		return address;
	}
	
	protected PortletPreferences getPortletPreferences(
			RenderRequest renderRequest) {
		
		PortletPreferences preferences = renderRequest.getPreferences();

		String portletResource = ParamUtil.getString(renderRequest,
				"portletResource");

		if (Validator.isNotNull(portletResource)) {
			try {
				preferences = PortletPreferencesFactoryUtil.getPortletSetup(
					renderRequest, portletResource);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return preferences;
	}
}
