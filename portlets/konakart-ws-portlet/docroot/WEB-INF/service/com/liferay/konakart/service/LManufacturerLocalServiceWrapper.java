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
 * This class is a wrapper for {@link LManufacturerLocalService}.
 * </p>
 *
 * @author    terry
 * @see       LManufacturerLocalService
 * @generated
 */
public class LManufacturerLocalServiceWrapper
	implements LManufacturerLocalService {
	public LManufacturerLocalServiceWrapper(
		LManufacturerLocalService lManufacturerLocalService) {
		_lManufacturerLocalService = lManufacturerLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lManufacturerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lManufacturerLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		_lManufacturerLocalService.setKKWsEng(kkWsEng);
	}

	public com.konakart.wsapp.Manufacturer[] getAllManufacturers()
		throws java.rmi.RemoteException {
		return _lManufacturerLocalService.getAllManufacturers();
	}

	public LManufacturerLocalService getWrappedLManufacturerLocalService() {
		return _lManufacturerLocalService;
	}

	public void setWrappedLManufacturerLocalService(
		LManufacturerLocalService lManufacturerLocalService) {
		_lManufacturerLocalService = lManufacturerLocalService;
	}

	private LManufacturerLocalService _lManufacturerLocalService;
}