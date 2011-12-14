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
 * The utility for the l category local service. This utility wraps {@link com.liferay.konakart.service.impl.LCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see LCategoryLocalService
 * @see com.liferay.konakart.service.base.LCategoryLocalServiceBaseImpl
 * @see com.liferay.konakart.service.impl.LCategoryLocalServiceImpl
 * @generated
 */
public class LCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.konakart.service.impl.LCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.konakart.wsapp.Category[] getCategoryTree()
		throws java.rmi.RemoteException {
		return getService().getCategoryTree();
	}

	public static com.konakart.wsapp.Category getCategory(int categoryId)
		throws java.rmi.RemoteException {
		return getService().getCategory(categoryId);
	}

	public static com.konakart.wsapp.Category[] getCategoryTree(
		boolean getNumProducts) throws java.rmi.RemoteException {
		return getService().getCategoryTree(getNumProducts);
	}

	public static com.konakart.wsapp.Category[] getAllCategoryTree(
		com.konakart.wsapp.Category[] categories, boolean isFirst) {
		return getService().getAllCategoryTree(categories, isFirst);
	}

	public static com.konakart.wsapp.Category[] getCategoryTree(
		int languageId, boolean getNumProducts) throws java.rmi.RemoteException {
		return getService().getCategoryTree(languageId, getNumProducts);
	}

	public static void clearService() {
		_service = null;
	}

	public static LCategoryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LCategoryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LCategoryLocalService.class.getName(), portletClassLoader);

			_service = new LCategoryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LCategoryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LCategoryLocalService.class);
		}

		return _service;
	}

	public void setService(LCategoryLocalService service) {
		MethodCache.remove(LCategoryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LCategoryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LCategoryLocalService.class);
	}

	private static LCategoryLocalService _service;
}