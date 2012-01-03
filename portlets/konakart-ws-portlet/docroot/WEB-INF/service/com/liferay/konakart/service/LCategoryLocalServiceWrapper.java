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

	public void setKKAppEng(com.konakart.al.KKAppEng kkAppEng)
		throws com.konakart.al.KKAppException, com.konakart.app.KKException {
		_lCategoryLocalService.setKKAppEng(kkAppEng);
	}

	public java.util.List<com.konakart.appif.CategoryIf> getCatMenuList() {
		return _lCategoryLocalService.getCatMenuList();
	}

	public com.konakart.al.DropListElement[] getAllCatsDropList() {
		return _lCategoryLocalService.getAllCatsDropList();
	}

	public int setCurrentCatAndUpdateProducts(int cateId)
		throws com.konakart.al.KKAppException, com.konakart.app.KKException {
		return _lCategoryLocalService.setCurrentCatAndUpdateProducts(cateId);
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