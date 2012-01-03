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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author terry
 */
public class LProductLocalServiceClp implements LProductLocalService {
	public LProductLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getBeanIdentifierMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_setKKWsEngMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"setKKWsEng", com.konakart.ws.KKWSEngIf.class);

		_setKKAppEngMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"setKKAppEng", com.konakart.al.KKAppEng.class);

		_getBestSellerMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSeller");

		_getRandomNewProdMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getRandomNewProd");

		_getRandomSpecialMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getRandomSpecial");

		_getAllManuArrayMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllManuArray");

		_getAllManuDropListMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllManuDropList");

		_getBestSellersMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSellers");

		_getBestSellersMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSellers", int.class);

		_getBestSellersMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSellers",
				com.liferay.konakart.util.LDataDescriptor.class, int.class,
				int.class);

		_getSpecialProductsMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getSpecialProducts");

		_getSpecialProductsMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"getSpecialProducts", int.class);

		_getProductMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getProduct", int.class);

		_getProductMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getProduct", java.lang.String.class, int.class, int.class);

		_getLastestProductsMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLastestProducts");

		_getLastestProductsMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLastestProducts", int.class);

		_searchProductsByKeyMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProductsByKey", java.lang.String.class);

		_searchProductsByManufacturerIdMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProductsByManufacturerId", int.class);

		_searchProductsByManufacturerIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProductsByManufacturerId", java.lang.String.class,
				com.liferay.konakart.util.LDataDescriptor.class, int.class,
				int.class);

		_searchProductsByCategoryIdMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProductsByCategoryId", int.class);

		_searchProductsByCategoryIdMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProductsByCategoryId", java.lang.String.class,
				com.liferay.konakart.util.LDataDescriptor.class, int.class,
				boolean.class, int.class);

		_searchProductsMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProducts", java.lang.String.class,
				com.liferay.konakart.util.LDataDescriptor.class,
				com.liferay.konakart.util.LProductSearch.class, int.class);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey0);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey1,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		MethodHandler methodHandler = new MethodHandler(_setKKWsEngMethodKey2,
				ClpSerializer.translateInput(kkWsEng));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void setKKAppEng(com.konakart.al.KKAppEng kkAppEng)
		throws com.konakart.app.KKException {
		MethodHandler methodHandler = new MethodHandler(_setKKAppEngMethodKey3,
				ClpSerializer.translateInput(kkAppEng));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.konakart.app.KKException) {
				throw (com.konakart.app.KKException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.konakart.appif.ProductIf[] getBestSeller()
		throws com.konakart.app.KKException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBestSellerMethodKey4);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.konakart.app.KKException) {
				throw (com.konakart.app.KKException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.appif.ProductIf[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.appif.ProductIf getRandomNewProd() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getRandomNewProdMethodKey5);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.appif.ProductIf)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.appif.ProductIf getRandomSpecial() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getRandomSpecialMethodKey6);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.appif.ProductIf)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.appif.ManufacturerIf[] getAllManuArray() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllManuArrayMethodKey7);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.appif.ManufacturerIf[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.al.DropListElement[] getAllManuDropList() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllManuDropListMethodKey8);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.al.DropListElement[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getBestSellers()
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBestSellersMethodKey9);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getBestSellers(int limit)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBestSellersMethodKey10,
				limit);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getBestSellers(
		com.liferay.konakart.util.LDataDescriptor dd, int categoryId,
		int languageId) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBestSellersMethodKey11,
				ClpSerializer.translateInput(dd), categoryId, languageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getSpecialProducts() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getSpecialProductsMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getSpecialProducts(int limit) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getSpecialProductsMethodKey13,
				limit);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product getProduct(int productId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getProductMethodKey14,
				productId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product getProduct(java.lang.String sessionId,
		int productId, int languageId) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getProductMethodKey15,
				ClpSerializer.translateInput(sessionId), productId, languageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getLastestProducts()
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLastestProductsMethodKey16);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] getLastestProducts(int limit)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLastestProductsMethodKey17,
				limit);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] searchProductsByKey(
		java.lang.String productKeyWord) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsByKeyMethodKey18,
				ClpSerializer.translateInput(productKeyWord));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] searchProductsByManufacturerId(
		int manufacturerId) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsByManufacturerIdMethodKey19,
				manufacturerId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] searchProductsByManufacturerId(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd, int manufacturerId,
		int languageId) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsByManufacturerIdMethodKey20,
				ClpSerializer.translateInput(sessionId),
				ClpSerializer.translateInput(ldd), manufacturerId, languageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] searchProductsByCategoryId(
		int categoryId) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsByCategoryIdMethodKey21,
				categoryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] searchProductsByCategoryId(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd, int categoryId,
		boolean searchInSubCats, int languageId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsByCategoryIdMethodKey22,
				ClpSerializer.translateInput(sessionId),
				ClpSerializer.translateInput(ldd), categoryId, searchInSubCats,
				languageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Product[] searchProducts(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd,
		com.liferay.konakart.util.LProductSearch lps, int langugeId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsMethodKey23,
				ClpSerializer.translateInput(sessionId),
				ClpSerializer.translateInput(ldd),
				ClpSerializer.translateInput(lps), langugeId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.konakart.wsapp.Product[])ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getBeanIdentifierMethodKey0;
	private MethodKey _setBeanIdentifierMethodKey1;
	private MethodKey _setKKWsEngMethodKey2;
	private MethodKey _setKKAppEngMethodKey3;
	private MethodKey _getBestSellerMethodKey4;
	private MethodKey _getRandomNewProdMethodKey5;
	private MethodKey _getRandomSpecialMethodKey6;
	private MethodKey _getAllManuArrayMethodKey7;
	private MethodKey _getAllManuDropListMethodKey8;
	private MethodKey _getBestSellersMethodKey9;
	private MethodKey _getBestSellersMethodKey10;
	private MethodKey _getBestSellersMethodKey11;
	private MethodKey _getSpecialProductsMethodKey12;
	private MethodKey _getSpecialProductsMethodKey13;
	private MethodKey _getProductMethodKey14;
	private MethodKey _getProductMethodKey15;
	private MethodKey _getLastestProductsMethodKey16;
	private MethodKey _getLastestProductsMethodKey17;
	private MethodKey _searchProductsByKeyMethodKey18;
	private MethodKey _searchProductsByManufacturerIdMethodKey19;
	private MethodKey _searchProductsByManufacturerIdMethodKey20;
	private MethodKey _searchProductsByCategoryIdMethodKey21;
	private MethodKey _searchProductsByCategoryIdMethodKey22;
	private MethodKey _searchProductsMethodKey23;
}