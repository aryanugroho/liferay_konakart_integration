package com.liferay.konakart.util;

import com.konakart.wsapp.ProductSearch;

import java.util.Calendar;

public class LProductSearch {
	
	public LProductSearch() {
		_productSearch = new ProductSearch();
		_productSearch.setCategoryId(-100);
		_productSearch.setManufacturerId(-100);
		_productSearch.setWhereToSearch(0);
		_productSearch.setSearchInSubCats(true);
		_productSearch.setProductType(-1);
	}
	
	public ProductSearch getProductSearch() {
		return _productSearch;
	}
	
	public void setAddedDateFrom(Calendar fromDate) {
		_productSearch.setDateAddedFrom(fromDate);
	}
	
	public void setSearchText(String searchText) {
		_productSearch.setSearchText(searchText);
	}
	
	public void setSearchTextRule(int searchTextRule) {
		_productSearch.setSearchTextRule(searchTextRule);
	}
	
	private ProductSearch _productSearch;
}