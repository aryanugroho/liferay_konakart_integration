package com.liferay.konakart;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class SearchPortlet
 */
public class SearchPortlet extends MVCPortlet {
 
	public void QuickFina(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		String productKeyWord = 
			ParamUtil.getString(actionRequest, "productKeyWord");
		
		actionResponse.setRenderParameter("productKeyWord", productKeyWord);
	}
	
	public void SearchByCategory(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		int categoryId = ParamUtil.getInteger(actionRequest, "categoryId");
		
		actionResponse.setRenderParameter("categoryId", 
			String.valueOf(categoryId));
	}
	
	public void SearchByManu(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		int manufacturerId = ParamUtil.getInteger(actionRequest, 
			"manufacturerId");
		
		actionRequest.setAttribute("manufacturerId", manufacturerId);
	}

	public void AdvancedSearch(ActionRequest actionRequest, 
			ActionResponse actionResponse) {
		
		String searchKey = ParamUtil.getString(actionRequest, "searchKey");

		String searchInDesciption = ParamUtil.getString(
			actionRequest, "searchInDesciption");
		
		String categoryId = ParamUtil.getString(actionRequest, "categoryId");
		
		String manufacturerId = ParamUtil.getString(
			actionRequest, "manufacturerId");
		
		String priceFrom = ParamUtil.getString(actionRequest, "priceFrom");
		
		String priceTo = ParamUtil.getString(actionRequest, "priceTo");
		
		String dateFrom = ParamUtil.getString(actionRequest, "dateFrom");
		
		String dateTo = ParamUtil.getString(actionRequest, "dateTo");
		
		String[] searchParams = {searchKey, searchInDesciption, categoryId, 
			manufacturerId, priceFrom, priceTo, dateFrom, dateTo};
		
		actionResponse.setRenderParameter("searchParams", searchParams);
	}
}