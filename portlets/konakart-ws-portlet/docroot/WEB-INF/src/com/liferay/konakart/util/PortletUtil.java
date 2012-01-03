package com.liferay.konakart.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

public class PortletUtil {
	
	public static String getShowType(RenderRequest renderRequest) {
		return PrefsParamUtil.getString(getPortletPreferences(renderRequest), 
			renderRequest, "showType", PortletConstants.BESTSELLERS);
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
}
