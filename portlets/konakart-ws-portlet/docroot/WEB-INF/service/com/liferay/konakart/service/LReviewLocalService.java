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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the l review local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see LReviewLocalServiceUtil
 * @see com.liferay.konakart.service.base.LReviewLocalServiceBaseImpl
 * @see com.liferay.konakart.service.impl.LReviewLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LReviewLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LReviewLocalServiceUtil} to access the l review local service. Add custom service methods to {@link com.liferay.konakart.service.impl.LReviewLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public void setKKWsEng(com.konakart.ws.KKWSEngIf kkWsEng);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getAverageRating(int productId)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getAverageRating(
		com.liferay.konakart.util.LDataDescriptor ldd, int productId)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Review getLastestRating(int productId)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Review getLastestRating(
		com.liferay.konakart.util.LDataDescriptor ldd, int productId)
		throws java.rmi.RemoteException;
}