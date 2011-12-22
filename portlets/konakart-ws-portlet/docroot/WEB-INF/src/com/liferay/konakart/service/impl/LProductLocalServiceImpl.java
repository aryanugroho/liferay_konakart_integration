/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.konakart.service.impl;

import com.konakart.app.DataDescConstants;
import com.konakart.ws.KKWSEngIf;
import com.konakart.wsapp.Product;
import com.liferay.konakart.service.base.LProductLocalServiceBaseImpl;
import com.liferay.konakart.util.KKConstant;
import com.liferay.konakart.util.LDataDescriptor;
import com.liferay.konakart.util.LProductSearch;

import java.rmi.RemoteException;

/**
 * The implementation of the l product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.konakart.service.LProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see com.liferay.konakart.service.base.LProductLocalServiceBaseImpl
 * @see com.liferay.konakart.service.LProductLocalServiceUtil
 */
public class LProductLocalServiceImpl extends LProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.konakart.service.LProductLocalServiceUtil} to access the l product local service.
	 */
	public void setKKWsEng(KKWSEngIf kkWsEng) {
		_kkWsEng = kkWsEng;
	}
	
	public Product[] getBestSellers() throws RemoteException{
		return getBestSellers(new LDataDescriptor(),
			KKConstant.KK_NOT_CONSTRAINT_CATEGORY_ID,
			KKConstant.KK_DEFAULT_LANGUAGE_ID);
	}
	
	public Product[] getBestSellers(int limit) throws RemoteException{
		return getBestSellers(new LDataDescriptor(limit),
			KKConstant.KK_NOT_CONSTRAINT_CATEGORY_ID,
			KKConstant.KK_DEFAULT_LANGUAGE_ID);
	}
	
	public Product[] getBestSellers(
			LDataDescriptor dd, int categoryId,int languageId) 
		throws RemoteException{

		Product[] productArray = new Product[0];

		productArray = _kkWsEng.getBestSellers(
			dd.get_dataDescriptor(), categoryId, languageId);

		return productArray;
	}
	
	public Product[] getSpecialProducts() {
		return getSpecialProducts(100);
	}
	
	public Product[] getSpecialProducts(int limit) {
		Product[] productArray = new Product[0];
		
		LDataDescriptor ldd = new LDataDescriptor();
		
		ldd.setLimit(limit);
		
		try {
			productArray = _kkWsEng.getAllSpecials(
				null, ldd.get_dataDescriptor(), -1).getProductArray();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return productArray;		
	}
	
	public Product getProduct(int productId) throws RemoteException {
		return getProduct(null, productId, KKConstant.KK_DEFAULT_LANGUAGE_ID);
	}
	
	public Product getProduct(String sessionId, int productId, int languageId) 
		throws RemoteException {
		
		return _kkWsEng.getProduct(sessionId, productId, languageId);
	}
	
	public Product[] getLastestProducts() throws RemoteException {
		return getLastestProducts(5);
	}
	
	public Product[] getLastestProducts(int limit) throws RemoteException {
		LProductSearch lps = new LProductSearch();
		LDataDescriptor ldd= new LDataDescriptor();
		
		ldd.setOrderBy(DataDescConstants.ORDER_BY_DATE_ADDED_DESCENDING);
		
		ldd.setLimit(limit);
		
		return searchProducts(null, ldd, lps, -1);
	}
	
	public Product[] searchProductsByKey(String productKeyWord) 
		throws RemoteException {
		
		LProductSearch lps = new LProductSearch();
		LDataDescriptor ldd= new LDataDescriptor();
		
		lps.setSearchText(productKeyWord);
		lps.setSearchTextRule(KKConstant.SEARCH_ADD_WILDCARD_BEFORE_AND_AFTER);
		
		return searchProducts(null, ldd, lps, -1);
	}
	
	public Product[] searchProducts(
			String sessionId, LDataDescriptor ldd, LProductSearch lps, 
			int langugeId) 
		throws RemoteException {
		
		return _kkWsEng.searchForProducts(sessionId, ldd.get_dataDescriptor(), 
			lps.getProductSearch(), -1).getProductArray();
	}
	
	private static KKWSEngIf _kkWsEng;
}