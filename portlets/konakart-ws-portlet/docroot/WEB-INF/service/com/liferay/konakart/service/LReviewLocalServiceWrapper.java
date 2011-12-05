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

package com.liferay.konakart.service;

/**
 * <p>
 * This class is a wrapper for {@link LReviewLocalService}.
 * </p>
 *
 * @author    terry
 * @see       LReviewLocalService
 * @generated
 */
public class LReviewLocalServiceWrapper implements LReviewLocalService {
	public LReviewLocalServiceWrapper(LReviewLocalService lReviewLocalService) {
		_lReviewLocalService = lReviewLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lReviewLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lReviewLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		_lReviewLocalService.setKKWsEng(kkWsEng);
	}

	public double getAverageRating(int productId)
		throws java.rmi.RemoteException {
		return _lReviewLocalService.getAverageRating(productId);
	}

	public double getAverageRating(
		com.liferay.konakart.util.LDataDescriptor ldd, int productId)
		throws java.rmi.RemoteException {
		return _lReviewLocalService.getAverageRating(ldd, productId);
	}

	public com.konakart.wsapp.Review getLastestRating(int productId)
		throws java.rmi.RemoteException {
		return _lReviewLocalService.getLastestRating(productId);
	}

	public com.konakart.wsapp.Review getLastestRating(
		com.liferay.konakart.util.LDataDescriptor ldd, int productId)
		throws java.rmi.RemoteException {
		return _lReviewLocalService.getLastestRating(ldd, productId);
	}

	public LReviewLocalService getWrappedLReviewLocalService() {
		return _lReviewLocalService;
	}

	public void setWrappedLReviewLocalService(
		LReviewLocalService lReviewLocalService) {
		_lReviewLocalService = lReviewLocalService;
	}

	private LReviewLocalService _lReviewLocalService;
}