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
 * This class is a wrapper for {@link LCategoryLocalService}.
 * </p>
 *
 * @author    terry
 * @see       LCategoryLocalService
 * @generated
 */
public class LCategoryLocalServiceWrapper implements LCategoryLocalService {
	public LCategoryLocalServiceWrapper(
		LCategoryLocalService lCategoryLocalService) {
		_lCategoryLocalService = lCategoryLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		_lCategoryLocalService.setKKWsEng(kkWsEng);
	}

	public com.konakart.wsapp.Category[] getCategoryTree()
		throws java.rmi.RemoteException {
		return _lCategoryLocalService.getCategoryTree();
	}

	public com.konakart.wsapp.Category getCategory(int categoryId)
		throws java.rmi.RemoteException {
		return _lCategoryLocalService.getCategory(categoryId);
	}

	public com.konakart.wsapp.Category[] getCategoryTree(boolean getNumProducts)
		throws java.rmi.RemoteException {
		return _lCategoryLocalService.getCategoryTree(getNumProducts);
	}

	public com.konakart.wsapp.Category[] getAllCategoryTree(
		com.konakart.wsapp.Category[] categories, boolean isFirst) {
		return _lCategoryLocalService.getAllCategoryTree(categories, isFirst);
	}

	public com.konakart.wsapp.Category[] getCategoryTree(int languageId,
		boolean getNumProducts) throws java.rmi.RemoteException {
		return _lCategoryLocalService.getCategoryTree(languageId, getNumProducts);
	}

	public LCategoryLocalService getWrappedLCategoryLocalService() {
		return _lCategoryLocalService;
	}

	public void setWrappedLCategoryLocalService(
		LCategoryLocalService lCategoryLocalService) {
		_lCategoryLocalService = lCategoryLocalService;
	}

	private LCategoryLocalService _lCategoryLocalService;
}