package com.liferay.konakart;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class SearchPortlet
 */
public class SearchPortlet extends MVCPortlet {
 
	public void processAction(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		String productKeyWord = 
			ParamUtil.getString(actionRequest, "productKeyWord");
		System.out.println("before:"+productKeyWord);
		actionResponse.setRenderParameter("productKeyWord", productKeyWord);
	}
}
