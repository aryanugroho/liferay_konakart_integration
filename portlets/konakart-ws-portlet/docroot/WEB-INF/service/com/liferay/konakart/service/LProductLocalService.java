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
 * The interface for the l product local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see LProductLocalServiceUtil
 * @see com.liferay.konakart.service.base.LProductLocalServiceBaseImpl
 * @see com.liferay.konakart.service.impl.LProductLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LProductLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LProductLocalServiceUtil} to access the l product local service. Add custom service methods to {@link com.liferay.konakart.service.impl.LProductLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public void setKKAppEng(com.konakart.al.KKAppEng kkAppEng)
		throws com.konakart.app.KKException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.appif.ProductIf[] getBestSeller()
		throws com.konakart.app.KKException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.appif.ProductIf getRandomNewProd();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.appif.ProductIf getRandomSpecial();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getBestSellers()
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getBestSellers(int limit)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getBestSellers(
		com.liferay.konakart.util.LDataDescriptor dd, int categoryId,
		int languageId) throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getSpecialProducts();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getSpecialProducts(int limit);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product getProduct(int productId)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product getProduct(java.lang.String sessionId,
		int productId, int languageId) throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getLastestProducts()
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] getLastestProducts(int limit)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] searchProductsByKey(
		java.lang.String productKeyWord) throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] searchProductsByManufacturerId(
		int manufacturerId) throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] searchProductsByManufacturerId(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd, int manufacturerId,
		int languageId) throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] searchProductsByCategoryId(
		int categoryId) throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] searchProductsByCategoryId(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd, int categoryId,
		boolean searchInSubCats, int languageId)
		throws java.rmi.RemoteException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.konakart.wsapp.Product[] searchProducts(
		java.lang.String sessionId,
		com.liferay.konakart.util.LDataDescriptor ldd,
		com.liferay.konakart.util.LProductSearch lps, int langugeId)
		throws java.rmi.RemoteException;
}