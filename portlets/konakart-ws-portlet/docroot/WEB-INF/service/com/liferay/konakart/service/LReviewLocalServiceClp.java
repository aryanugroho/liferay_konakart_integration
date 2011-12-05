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
public class LReviewLocalServiceClp implements LReviewLocalService {
	public LReviewLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_getBeanIdentifierMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_setKKWsEngMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"setKKWsEng", com.konakart.ws.KKWSEngIf.class);

		_getAverageRatingMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAverageRating", int.class);

		_getAverageRatingMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAverageRating",
				com.liferay.konakart.util.LDataDescriptor.class, int.class);

		_getLastestRatingMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLastestRating", int.class);

		_getLastestRatingMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLastestRating",
				com.liferay.konakart.util.LDataDescriptor.class, int.class);
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

	public double getAverageRating(int productId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAverageRatingMethodKey3,
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

		return ((Double)returnObj).doubleValue();
	}

	public double getAverageRating(
		com.liferay.konakart.util.LDataDescriptor ldd, int productId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAverageRatingMethodKey4,
				ClpSerializer.translateInput(ldd), productId);

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

		return ((Double)returnObj).doubleValue();
	}

	public com.konakart.wsapp.Review getLastestRating(int productId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLastestRatingMethodKey5,
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

		return (com.konakart.wsapp.Review)ClpSerializer.translateOutput(returnObj);
	}

	public com.konakart.wsapp.Review getLastestRating(
		com.liferay.konakart.util.LDataDescriptor ldd, int productId)
		throws java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLastestRatingMethodKey6,
				ClpSerializer.translateInput(ldd), productId);

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

		return (com.konakart.wsapp.Review)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _getBeanIdentifierMethodKey0;
	private MethodKey _setBeanIdentifierMethodKey1;
	private MethodKey _setKKWsEngMethodKey2;
	private MethodKey _getAverageRatingMethodKey3;
	private MethodKey _getAverageRatingMethodKey4;
	private MethodKey _getLastestRatingMethodKey5;
	private MethodKey _getLastestRatingMethodKey6;
}