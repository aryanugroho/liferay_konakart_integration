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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the l pruduct local service. This utility wraps {@link com.liferay.konakart.service.impl.LPruductLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see LPruductLocalService
 * @see com.liferay.konakart.service.base.LPruductLocalServiceBaseImpl
 * @see com.liferay.konakart.service.impl.LPruductLocalServiceImpl
 * @generated
 */
public class LPruductLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.konakart.service.impl.LPruductLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng) {
		getService().setKKWsEng(kkWsEng);
	}

	public static com.konakart.wsapp.Product[] getBestSellers()
		throws java.rmi.RemoteException {
		return getService().getBestSellers();
	}

	public static com.konakart.wsapp.Product[] getBestSellers(int limit)
		throws java.rmi.RemoteException {
		return getService().getBestSellers(limit);
	}

	public static com.konakart.wsapp.Product[] getBestSellers(
		com.liferay.konakart.util.LDataDescriptor dd, int categoryId,
		int languageId) throws java.rmi.RemoteException {
		return getService().getBestSellers(dd, categoryId, languageId);
	}

	public static com.konakart.wsapp.Product[] getSpecialProducts() {
		return getService().getSpecialProducts();
	}

	public static com.konakart.wsapp.Product[] getSpecialProducts(int limit) {
		return getService().getSpecialProducts(limit);
	}

	public static com.konakart.wsapp.Product getProduct(
		java.lang.String sessionId, int productId, int languageId)
		throws java.rmi.RemoteException {
		return getService().getProduct(sessionId, productId, languageId);
	}

	public static com.konakart.wsapp.Product[] getLastestProducts()
		throws java.rmi.RemoteException {
		return getService().getLastestProducts();
	}

	public static com.konakart.wsapp.Product[] getLastestProducts(int limit)
		throws java.rmi.RemoteException {
		return getService().getLastestProducts(limit);
	}

	public static com.konakart.wsapp.Product[] searchProducts(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd,
		com.liferay.konakart.util.LProductSearch lps, int langugeId)
		throws java.rmi.RemoteException {
		return getService().searchProducts(sessionId, ldd, lps, langugeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LPruductLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LPruductLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LPruductLocalService.class.getName(), portletClassLoader);

			_service = new LPruductLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LPruductLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LPruductLocalService.class);
		}

		return _service;
	}

	public void setService(LPruductLocalService service) {
		MethodCache.remove(LPruductLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LPruductLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LPruductLocalService.class);
	}

	private static LPruductLocalService _service;
}