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
public class LCategoryLocalServiceClp implements LCategoryLocalService {
	public LCategoryLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getBeanIdentifierMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_setKKAppEngMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"setKKAppEng", com.konakart.al.KKAppEng.class);

		_getCatMenuListMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCatMenuList");

		_getAllCatsDropListMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllCatsDropList");

		_setCurrentCatAndUpdateProductsMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"setCurrentCatAndUpdateProducts", int.class);
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

	public void setKKAppEng(com.konakart.al.KKAppEng kkAppEng)
		throws com.konakart.al.KKAppException, com.konakart.app.KKException {
		MethodHandler methodHandler = new MethodHandler(_setKKAppEngMethodKey2,
				ClpSerializer.translateInput(kkAppEng));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.konakart.al.KKAppException) {
				throw (com.konakart.al.KKAppException)t;
			}

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

	public java.util.List<com.konakart.appif.CategoryIf> getCatMenuList() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCatMenuListMethodKey3);

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

		return (java.util.List<com.konakart.appif.CategoryIf>)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.al.DropListElement[] getAllCatsDropList() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllCatsDropListMethodKey4);

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

	public int setCurrentCatAndUpdateProducts(int cateId)
		throws com.konakart.al.KKAppException, com.konakart.app.KKException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_setCurrentCatAndUpdateProductsMethodKey5,
				cateId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.konakart.al.KKAppException) {
				throw (com.konakart.al.KKAppException)t;
			}

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

		return ((Integer)returnObj).intValue();
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getBeanIdentifierMethodKey0;
	private MethodKey _setBeanIdentifierMethodKey1;
	private MethodKey _setKKAppEngMethodKey2;
	private MethodKey _getCatMenuListMethodKey3;
	private MethodKey _getAllCatsDropListMethodKey4;
	private MethodKey _setCurrentCatAndUpdateProductsMethodKey5;
}