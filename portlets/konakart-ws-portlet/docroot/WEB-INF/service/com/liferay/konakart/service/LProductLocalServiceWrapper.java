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
 * This class is a wrapper for {@link LProductLocalService}.
 * </p>
 *
 * @author    terry
 * @see       LProductLocalService
 * @generated
 */
public class LProductLocalServiceWrapper implements LProductLocalService {
	public LProductLocalServiceWrapper(
		LProductLocalService lProductLocalService) {
		_lProductLocalService = lProductLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lProductLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lProductLocalService.setBeanIdentifier(beanIdentifier);
	}

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		_lProductLocalService.setKKWsEng(kkWsEng);
	}

	public void setKKAppEng(com.konakart.al.KKAppEng kkAppEng)
		throws com.konakart.app.KKException {
		_lProductLocalService.setKKAppEng(kkAppEng);
	}

	public com.konakart.appif.ProductIf[] getBestSeller()
		throws com.konakart.app.KKException {
		return _lProductLocalService.getBestSeller();
	}

	public com.konakart.appif.ProductIf getRandomNewProd() {
		return _lProductLocalService.getRandomNewProd();
	}

	public com.konakart.appif.ProductIf getRandomSpecial() {
		return _lProductLocalService.getRandomSpecial();
	}

	public com.konakart.appif.ManufacturerIf[] getAllManuArray() {
		return _lProductLocalService.getAllManuArray();
	}

	public com.konakart.al.DropListElement[] getAllManuDropList() {
		return _lProductLocalService.getAllManuDropList();
	}

	public com.konakart.wsapp.Product[] getBestSellers()
		throws java.rmi.RemoteException {
		return _lProductLocalService.getBestSellers();
	}

	public com.konakart.wsapp.Product[] getBestSellers(int limit)
		throws java.rmi.RemoteException {
		return _lProductLocalService.getBestSellers(limit);
	}

	public com.konakart.wsapp.Product[] getBestSellers(
		com.liferay.konakart.util.LDataDescriptor dd, int categoryId,
		int languageId) throws java.rmi.RemoteException {
		return _lProductLocalService.getBestSellers(dd, categoryId, languageId);
	}

	public com.konakart.wsapp.Product[] getSpecialProducts() {
		return _lProductLocalService.getSpecialProducts();
	}

	public com.konakart.wsapp.Product[] getSpecialProducts(int limit) {
		return _lProductLocalService.getSpecialProducts(limit);
	}

	public com.konakart.wsapp.Product getProduct(int productId)
		throws java.rmi.RemoteException {
		return _lProductLocalService.getProduct(productId);
	}

	public com.konakart.wsapp.Product getProduct(java.lang.String sessionId,
		int productId, int languageId) throws java.rmi.RemoteException {
		return _lProductLocalService.getProduct(sessionId, productId, languageId);
	}

	public com.konakart.wsapp.Product[] getLastestProducts()
		throws java.rmi.RemoteException {
		return _lProductLocalService.getLastestProducts();
	}

	public com.konakart.wsapp.Product[] getLastestProducts(int limit)
		throws java.rmi.RemoteException {
		return _lProductLocalService.getLastestProducts(limit);
	}

	public com.konakart.wsapp.Product[] searchProductsByKey(
		java.lang.String productKeyWord) throws java.rmi.RemoteException {
		return _lProductLocalService.searchProductsByKey(productKeyWord);
	}

	public com.konakart.wsapp.Product[] searchProductsByManufacturerId(
		int manufacturerId) throws java.rmi.RemoteException {
		return _lProductLocalService.searchProductsByManufacturerId(manufacturerId);
	}

	public com.konakart.wsapp.Product[] searchProductsByManufacturerId(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd, int manufacturerId,
		int languageId) throws java.rmi.RemoteException {
		return _lProductLocalService.searchProductsByManufacturerId(sessionId,
			ldd, manufacturerId, languageId);
	}

	public com.konakart.wsapp.Product[] searchProductsByCategoryId(
		int categoryId) throws java.rmi.RemoteException {
		return _lProductLocalService.searchProductsByCategoryId(categoryId);
	}

	public com.konakart.wsapp.Product[] searchProductsByCategoryId(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd, int categoryId,
		boolean searchInSubCats, int languageId)
		throws java.rmi.RemoteException {
		return _lProductLocalService.searchProductsByCategoryId(sessionId, ldd,
			categoryId, searchInSubCats, languageId);
	}

	public com.konakart.wsapp.Product[] searchProducts(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd,
		com.liferay.konakart.util.LProductSearch lps, int langugeId)
		throws java.rmi.RemoteException {
		return _lProductLocalService.searchProducts(sessionId, ldd, lps,
			langugeId);
	}

	public LProductLocalService getWrappedLProductLocalService() {
		return _lProductLocalService;
	}

	public void setWrappedLProductLocalService(
		LProductLocalService lProductLocalService) {
		_lProductLocalService = lProductLocalService;
	}

	private LProductLocalService _lProductLocalService;
}