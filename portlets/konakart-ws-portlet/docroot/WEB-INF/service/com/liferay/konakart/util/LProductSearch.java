package com.liferay.konakart.util;

import com.konakart.wsapp.ProductSearch;

public class LProductSearch {
	
	public LProductSearch() {
		_productSearch = new ProductSearch();
	}
	
	public ProductSearch getProductSearch() {
		return _productSearch;
	}
	
	private ProductSearch _productSearch;
}