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
 * This class is a wrapper for {@link LPruductLocalService}.
 * </p>
 *
 * @author    terry
 * @see       LPruductLocalService
 * @generated
 */
public class LPruductLocalServiceWrapper implements LPruductLocalService {
	public LPruductLocalServiceWrapper(
		LPruductLocalService lPruductLocalService) {
		_lPruductLocalService = lPruductLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lPruductLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lPruductLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		_lPruductLocalService.setKKWsEng(kkWsEng);
	}

	public com.konakart.wsapp.Product[] getBestSellers()
		throws java.rmi.RemoteException {
		return _lPruductLocalService.getBestSellers();
	}

	public com.konakart.wsapp.Product[] getBestSellers(int limit)
		throws java.rmi.RemoteException {
		return _lPruductLocalService.getBestSellers(limit);
	}

	public com.konakart.wsapp.Product[] getBestSellers(
		com.liferay.konakart.util.LDataDescriptor dd, int categoryId,
		int languageId) throws java.rmi.RemoteException {
		return _lPruductLocalService.getBestSellers(dd, categoryId, languageId);
	}

	public com.konakart.wsapp.Product[] getSpecialProducts() {
		return _lPruductLocalService.getSpecialProducts();
	}

	public com.konakart.wsapp.Product[] getSpecialProducts(int limit) {
		return _lPruductLocalService.getSpecialProducts(limit);
	}

	public LPruductLocalService getWrappedLPruductLocalService() {
		return _lPruductLocalService;
	}

	public void setWrappedLPruductLocalService(
		LPruductLocalService lPruductLocalService) {
		_lPruductLocalService = lPruductLocalService;
	}

	private LPruductLocalService _lPruductLocalService;
}