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
public class LPruductLocalServiceClp implements LPruductLocalService {
	public LPruductLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getBeanIdentifierMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_setKKWsEngMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"setKKWsEng", com.konakart.ws.KKWSEngIf.class);

		_getBestSellersMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSellers");

		_getBestSellersMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSellers", int.class);

		_getBestSellersMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBestSellers",
				com.liferay.konakart.util.LDataDescriptor.class, int.class,
				int.class);

		_getSpecialProductsMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getSpecialProducts");

		_getSpecialProductsMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getSpecialProducts", int.class);

		_getProductMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getProduct", int.class);

		_getProductMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getProduct", java.lang.String.class, int.class, int.class);

		_getLastestProductsMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLastestProducts");

		_getLastestProductsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLastestProducts", int.class);

		_searchProductsByKeyMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchProductsByKey", java.lang.String.class);

		_searchProductsMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
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

	public com.konakart.wsapp.Product[] getBestSellers()
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBestSellersMethodKey3);

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

		MethodHandler methodHandler = new MethodHandler(_getBestSellersMethodKey4,
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

		MethodHandler methodHandler = new MethodHandler(_getBestSellersMethodKey5,
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

		MethodHandler methodHandler = new MethodHandler(_getSpecialProductsMethodKey6);

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

		MethodHandler methodHandler = new MethodHandler(_getSpecialProductsMethodKey7,
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

		MethodHandler methodHandler = new MethodHandler(_getProductMethodKey8,
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

		MethodHandler methodHandler = new MethodHandler(_getProductMethodKey9,
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

		MethodHandler methodHandler = new MethodHandler(_getLastestProductsMethodKey10);

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

		MethodHandler methodHandler = new MethodHandler(_getLastestProductsMethodKey11,
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

		MethodHandler methodHandler = new MethodHandler(_searchProductsByKeyMethodKey12,
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

	public com.konakart.wsapp.Product[] searchProducts(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd,
		com.liferay.konakart.util.LProductSearch lps, int langugeId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchProductsMethodKey13,
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
	private MethodKey _getBestSellersMethodKey3;
	private MethodKey _getBestSellersMethodKey4;
	private MethodKey _getBestSellersMethodKey5;
	private MethodKey _getSpecialProductsMethodKey6;
	private MethodKey _getSpecialProductsMethodKey7;
	private MethodKey _getProductMethodKey8;
	private MethodKey _getProductMethodKey9;
	private MethodKey _getLastestProductsMethodKey10;
	private MethodKey _getLastestProductsMethodKey11;
	private MethodKey _searchProductsByKeyMethodKey12;
	private MethodKey _searchProductsMethodKey13;
}