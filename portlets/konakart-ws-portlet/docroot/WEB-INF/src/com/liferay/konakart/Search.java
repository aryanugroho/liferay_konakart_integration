package com.liferay.konakart;

import com.konakart.al.CategoryMgr;
import com.konakart.al.KKAppException;
import com.konakart.al.ProductMgr;
import com.konakart.app.KKException;
import com.konakart.app.ProductSearch;
import com.liferay.konakart.util.KKConstants;
import com.liferay.konakart.util.KKUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class Search
 */
public class Search extends MVCPortlet {
 	
	public void quickFind(ActionRequest actionRequest, 
			ActionResponse actionResponse)
		throws KKAppException, KKException {
		
		String productKeyWord = ParamUtil.getString(actionRequest, 
			"productKeyWord", "");
		
		ProductSearch localProductSearch = new ProductSearch();
		
		localProductSearch.setManufacturerId(KKConstants.ALL_MANUFACTURER);
		localProductSearch.setCategoryId(KKConstants.ALL_CATEGORIES);
		localProductSearch.setWhereToSearch(0);
		localProductSearch.setSearchText(productKeyWord);
		
		ProductMgr productMgr = KKUtil.getProductMgr();
		
		productMgr.searchForProducts(localProductSearch);
	}
	
	public void searchByCategory(ActionRequest actionRequest, 
			ActionResponse actionResponse)
		throws KKAppException, KKException {
		
		int categoryId = ParamUtil.getInteger(actionRequest, "categoryId");
		
		CategoryMgr categoryMgr = KKUtil.getCategoryMgr();
		
		categoryMgr.setCurrentCatAndUpdateProducts1(categoryId);
	}
	
	public void searchByManu(ActionRequest actionRequest, 
			ActionResponse actionResponse)
		throws KKAppException, KKException {
		
		int manufacturerId = ParamUtil.getInteger(actionRequest, 
			"manufacturerId", -1);
		
		ProductMgr productMgr = KKUtil.getProductMgr();
		
		productMgr.fetchProductsPerManufacturer(manufacturerId);
	}
}
