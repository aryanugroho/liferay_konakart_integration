package com.liferay.konakart.util;

import com.konakart.ws.KKWSEngIf;
import com.konakart.ws.KKWSEngIfServiceLocator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.net.URL;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.xml.rpc.ServiceException;

public class KKWsUtil {
	
	public static KKWSEngIf getKKWsEngUtil() {
		try {
			_kkWsEng = new KKWSEngIfServiceLocator().getKKWebServiceEng();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return _kkWsEng;
	}
	
	public static KKWSEngIf getKKWsEngUtil(URL webServiceURL) {
		try {
			_kkWsEng = new KKWSEngIfServiceLocator().
				getKKWebServiceEng(webServiceURL);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return _kkWsEng;
	}
	
	public static String getWebServiceAddress(RenderRequest renderRequest) {
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

	public static String getShowType(RenderRequest renderRequest) {
		return PrefsParamUtil.getString(getPortletPreferences(renderRequest), 
			renderRequest, "showType", PortletConstants.BESTSELLERS);
	}
	
	public static boolean getShowRandom(RenderRequest renderRequest) {	
		return PrefsParamUtil.getBoolean(getPortletPreferences(renderRequest), 
			renderRequest, "showRandom", false);
	}
	
	public static int getShowCount(RenderRequest renderRequest) {
		return PrefsParamUtil.getInteger(getPortletPreferences(renderRequest), 
			renderRequest, "showCount", 5);
	}
	
	public static PortletPreferences getPortletPreferences(
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
	
	private static KKWSEngIf _kkWsEng;
}
