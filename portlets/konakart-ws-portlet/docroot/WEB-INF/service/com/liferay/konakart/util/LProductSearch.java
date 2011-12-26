package com.liferay.konakart.util;

import com.konakart.wsapp.ProductSearch;
import com.liferay.konakart.util.KKConstant;

import java.math.BigDecimal;
import java.util.Calendar;

public class LProductSearch {
	
	public LProductSearch() {
		_productSearch = new ProductSearch();
		_productSearch.setCategoryId(-100);
		_productSearch.setManufacturerId(-100);
		_productSearch.setWhereToSearch(0);
		_productSearch.setSearchInSubCats(true);
		_productSearch.setProductType(-1);
		_productSearch.setSearchTextRule(
			KKConstant.SEARCH_ADD_WILDCARD_BEFORE_AND_AFTER);
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
	
	public void setCategoryId(int categoryId) {
		_productSearch.setCategoryId(categoryId);
	}
	
	public void setManufacturerId(int manufacturerId) {
		_productSearch.setManufacturerId(manufacturerId);
	}
	
	public void setPriceFrom(BigDecimal price) {
		_productSearch.setPriceFrom(price);
	}
	
	public void setPriceTo(BigDecimal price) {
		_productSearch.setPriceTo(price);
	}
	
	public void setDateFrom(Calendar date) {
		_productSearch.setDateAddedFrom(date);
	}
	
	public void setDateTo(Calendar date) {
		_productSearch.setDateAddedTo(date);
	}
	
	private ProductSearch _productSearch;
}