package com.liferay.konakart;

import com.liferay.konakart.util.PortletConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class SearchPortlet
 */
public class SearchPortlet extends MVCPortlet {
 
	public void quickFind(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		String productKeyWord = ParamUtil.getString(actionRequest, 
			"productKeyWord");
		
		String searchKey = productKeyWord + "#productKeyWord";
		
		actionResponse.setRenderParameter("searchKey", searchKey);
	}
	
	public void searchByCategory(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		int categoryId = ParamUtil.getInteger(actionRequest, "categoryId");
		
		String searchKey = categoryId + "#categoryId";
		
		actionResponse.setRenderParameter("searchKey", searchKey);
	}
	
	public void searchByManu(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		int manufacturerId = ParamUtil.getInteger(actionRequest, 
			"manufacturerId");
		
		actionRequest.setAttribute("manufacturerId", manufacturerId);
		
		String searchKey = manufacturerId + "#manufacturerId";
		
		actionResponse.setRenderParameter("searchKey", searchKey);
	}

	public void advancedSearch(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		String searchCriteria = ParamUtil.getString(actionRequest,
			"searchCriteria");
		
		if (Validator.isNull(searchCriteria)) {
			searchCriteria = PortletConstants.LIFERAY_EMPTY; 
		}
		
		String categoryId = ParamUtil.getString(actionRequest, "categoryId");
		
		if (Validator.isNull(categoryId)) {
			categoryId = PortletConstants.LIFERAY_EMPTY; 
		}
		
		String manufacturerId = ParamUtil.getString(actionRequest, 
			"manufacturerId");
		
		if (Validator.isNull(manufacturerId)) {
			manufacturerId = PortletConstants.LIFERAY_EMPTY; 
		}
		
		String priceFrom = ParamUtil.getString(actionRequest, "priceFrom");
		
		if (Validator.isNull(priceFrom)) {
			priceFrom = PortletConstants.LIFERAY_EMPTY; 
		}
		
		String priceTo = ParamUtil.getString(actionRequest, "priceTo");
		
		if (Validator.isNull(priceTo)) {
			priceTo = PortletConstants.LIFERAY_EMPTY; 
		}
			
		String[] searchParams = {searchCriteria, categoryId, manufacturerId, 
			priceFrom, priceTo};
		
		String searchParam = StringUtil.merge(searchParams);
		
		searchParam = searchParam + "#searchParams";
		
		actionResponse.setRenderParameter("searchKey", searchParam);
	}
}