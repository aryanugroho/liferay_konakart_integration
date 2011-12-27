package com.liferay.konakart.util;

import com.konakart.ws.KKWSEngIf;
import com.konakart.ws.KKWSEngIfServiceLocator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.net.URL;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

public class KKWsUtil {
	
	public static KKWSEngIf getKKWsEng() {
		try {
			_kkWsEng = new KKWSEngIfServiceLocator().getKKWebServiceEng();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return _kkWsEng;
	}
	
	public static KKWSEngIf getKKWsEng(URL webServiceURL) {
		try {
			_kkWsEng = new KKWSEngIfServiceLocator().
				getKKWebServiceEng(webServiceURL);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return _kkWsEng;
	}

	public static KKWSEngIf getKKWsEng(RenderRequest renderRequest) {
		HttpServletRequest httpServletRequest = PortalUtil.
			getHttpServletRequest(renderRequest);
			
		HttpSession session = httpServletRequest.getSession();

		_kkWsEng = 
			(KKWSEngIf) session.getAttribute(PortletConstants.KKWSENG);
		
		if (_kkWsEng == null) {
			_kkWsEng = getKKWsEng();
			session.setAttribute(PortletConstants.KKWSENG, _kkWsEng);
		}
		
		return _kkWsEng;
	}
	
	public static KKWSEngIf getKKWsEng(
			RenderRequest renderRequest, URL webServiceURL) {
		
		HttpServletRequest httpServletRequest = PortalUtil.
				getHttpServletRequest(renderRequest);
		
		HttpSession session = httpServletRequest.getSession();

		_kkWsEng = 
			(KKWSEngIf) session.getAttribute(PortletConstants.KKWSENG);
		
		if (_kkWsEng == null) {
			_kkWsEng = getKKWsEng(webServiceURL);
			session.setAttribute(PortletConstants.KKWSENG, _kkWsEng);
		}
		
		return _kkWsEng;
	}
	
	public static String getWebServiceAddress(RenderRequest renderRequest) {
		String address = defaultWebServiceAddress;

		String webServiceAddress = 
			PrefsParamUtil.getString(getPortletPreferences(renderRequest), 
				renderRequest, "webServiceAddress");

		if (Validator.isNotNull(webServiceAddress)) {
			address = webServiceAddress;
		}

		return address;
	}

	public static String getWebSiteUrl(String webServiceAddress) {
		String serviceUrl = StringUtil.replace(webServiceAddress,
				"services/KKWebServiceEng?wsdl", "");
				
		return serviceUrl;
	}
	
	public static String getWebSiteUrl(RenderRequest renderRequest) {
		return getWebSiteUrl(getWebServiceAddress(renderRequest));
	}
	
	public static String getImgUrl(String webSiteUrl) {
		return webSiteUrl + "images/";
	}
	
	public static String getImgUrl(RenderRequest renderRequest) {
		return getWebSiteUrl(renderRequest) + "images/";
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
	private static final String defaultWebServiceAddress = 
		"http://localhost:8780/konakart/services/KKWebServiceEng?wsdl";
}
