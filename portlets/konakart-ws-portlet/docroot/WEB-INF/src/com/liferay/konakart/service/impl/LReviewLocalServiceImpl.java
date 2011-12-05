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
import com.konakart.wsapp.Review;
import com.liferay.konakart.service.base.LReviewLocalServiceBaseImpl;
import com.liferay.konakart.util.LDataDescriptor;

import java.rmi.RemoteException;

/**
 * The implementation of the l review local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.konakart.service.LReviewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see com.liferay.konakart.service.base.LReviewLocalServiceBaseImpl
 * @see com.liferay.konakart.service.LReviewLocalServiceUtil
 */
public class LReviewLocalServiceImpl extends LReviewLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.konakart.service.LReviewLocalServiceUtil} to access the l review local service.
	 */
	public void setKKWsEng(KKWSEngIf kkWsEng) {
		_kkWsEng = kkWsEng;
	}
	
	public double getAverageRating(int productId) throws RemoteException {
		return getAverageRating(new LDataDescriptor(), productId);
	}
	
	public double getAverageRating(LDataDescriptor ldd, int productId) 
		throws RemoteException { 
		
		Review[] reviewArray = 
			_kkWsEng.getReviewsPerProduct(
				ldd.get_dataDescriptor(), productId).getReviewArray();
		
		if (reviewArray.length == 0) {
			return 0;
		}
		
		int total = 0;
		
		for (int i = 0; i < reviewArray.length; i++) {
			total = total + reviewArray[i].getRating();
		}
		
		return total/reviewArray.length;
	}
	
	public Review getLastestRating(int productId) throws RemoteException {
		return getLastestRating(new LDataDescriptor(
				1, DataDescConstants.ORDER_BY_DATE_ADDED_DESCENDING), productId);
	}
	
	public Review getLastestRating(LDataDescriptor ldd, int productId) 
		throws RemoteException { 
		
		Review[] reviewArray = 
			_kkWsEng.getReviewsPerProduct(
				ldd.get_dataDescriptor(), productId).getReviewArray();
		
		if (reviewArray.length == 0) {
			return null;
		}
		
		return reviewArray[0];
	}
		
	private static KKWSEngIf _kkWsEng;
}