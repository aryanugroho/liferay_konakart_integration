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

		_setKKWsEngMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"setKKWsEng", com.konakart.ws.KKWSEngIf.class);

		_getCategoryTreeMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoryTree");

		_getCategoryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategory", int.class);

		_getCategoryTreeMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoryTree", boolean.class);

		_getAllCategoryTreeMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllCategoryTree", com.konakart.wsapp.Category[].class,
				boolean.class);

		_getCategoryTreeMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoryTree", int.class, boolean.class);
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

	public com.konakart.wsapp.Category[] getCategoryTree()
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoryTreeMethodKey3);

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

		return (com.konakart.wsapp.Category[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Category getCategory(int categoryId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoryMethodKey4,
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

		return (com.konakart.wsapp.Category)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Category[] getCategoryTree(boolean getNumProducts)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoryTreeMethodKey5,
				getNumProducts);

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

		return (com.konakart.wsapp.Category[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Category[] getAllCategoryTree(
		com.konakart.wsapp.Category[] categories, boolean isFirst) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllCategoryTreeMethodKey6,
				ClpSerializer.translateInput(categories), isFirst);

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

		return (com.konakart.wsapp.Category[])ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Category[] getCategoryTree(int languageId,
		boolean getNumProducts) throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoryTreeMethodKey7,
				languageId, getNumProducts);

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

		return (com.konakart.wsapp.Category[])ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getBeanIdentifierMethodKey0;
	private MethodKey _setBeanIdentifierMethodKey1;
	private MethodKey _setKKWsEngMethodKey2;
	private MethodKey _getCategoryTreeMethodKey3;
	private MethodKey _getCategoryMethodKey4;
	private MethodKey _getCategoryTreeMethodKey5;
	private MethodKey _getAllCategoryTreeMethodKey6;
	private MethodKey _getCategoryTreeMethodKey7;
}