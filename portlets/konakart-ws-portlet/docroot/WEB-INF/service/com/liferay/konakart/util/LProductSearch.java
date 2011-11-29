package com.liferay.konakart.util;

import com.konakart.wsapp.ProductSearch;

import java.util.Calendar;

public class LProductSearch {
	
	public LProductSearch() {
		_productSearch = new ProductSearch();
	}
	
	public ProductSearch getProductSearch() {
		return _productSearch;
	}
	
	public void setAddedDateFrom(Calendar fromDate) {
		_productSearch.setDateAddedFrom(fromDate);
	}
	
	private ProductSearch _productSearch;
}