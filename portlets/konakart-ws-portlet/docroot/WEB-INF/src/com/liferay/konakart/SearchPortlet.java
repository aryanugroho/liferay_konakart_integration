package com.liferay.konakart;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
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

		String searchInDesciption = ParamUtil.getString(actionRequest, 
			"searchInDesciption");
		
		String categoryId = ParamUtil.getString(actionRequest, "categoryId");
		
		String manufacturerId = ParamUtil.getString(actionRequest, 
			"manufacturerId");
		
		String priceFrom = ParamUtil.getString(actionRequest, "priceFrom");
		
		String priceTo = ParamUtil.getString(actionRequest, "priceTo");
		
		String dateFrom = ParamUtil.getString(actionRequest, "dateFrom");
		
		String dateTo = ParamUtil.getString(actionRequest, "dateTo");
		
		String[] searchParams = {searchCriteria, searchInDesciption, categoryId, 
			manufacturerId, priceFrom, priceTo, dateFrom, dateTo};
		
		String searchKey = StringUtil.merge(searchParams) + 
			"#searchParams";
		
		actionResponse.setRenderParameter("searchKey", searchKey);
	}
}