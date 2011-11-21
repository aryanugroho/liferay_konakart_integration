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

import com.konakart.ws.KKWSEngIf;
import com.konakart.wsapp.Product;
import com.liferay.konakart.service.base.LPruductLocalServiceBaseImpl;
import com.liferay.konakart.util.KKConstant;
import com.liferay.konakart.util.LDataDescriptor;

import java.rmi.RemoteException;

/**
 * The implementation of the l pruduct local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.konakart.service.LPruductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see com.liferay.konakart.service.base.LPruductLocalServiceBaseImpl
 * @see com.liferay.konakart.service.LPruductLocalServiceUtil
 */
public class LPruductLocalServiceImpl extends LPruductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.konakart.service.LPruductLocalServiceUtil} to access the l pruduct local service.
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
	
	private static KKWSEngIf _kkWsEng;
}