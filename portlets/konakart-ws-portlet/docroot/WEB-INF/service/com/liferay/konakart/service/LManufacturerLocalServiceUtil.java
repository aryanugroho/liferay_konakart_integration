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
 * The utility for the l manufacturer local service. This utility wraps {@link com.liferay.konakart.service.impl.LManufacturerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see LManufacturerLocalService
 * @see com.liferay.konakart.service.base.LManufacturerLocalServiceBaseImpl
 * @see com.liferay.konakart.service.impl.LManufacturerLocalServiceImpl
 * @generated
 */
public class LManufacturerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.konakart.service.impl.LManufacturerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.konakart.wsapp.Manufacturer[] getAllManufacturers()
		throws java.rmi.RemoteException {
		return getService().getAllManufacturers();
	}

	public static void clearService() {
		_service = null;
	}

	public static LManufacturerLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LManufacturerLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LManufacturerLocalService.class.getName(),
					portletClassLoader);

			_service = new LManufacturerLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LManufacturerLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LManufacturerLocalService.class);
		}

		return _service;
	}

	public void setService(LManufacturerLocalService service) {
		MethodCache.remove(LManufacturerLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LManufacturerLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LManufacturerLocalService.class);
	}

	private static LManufacturerLocalService _service;
}