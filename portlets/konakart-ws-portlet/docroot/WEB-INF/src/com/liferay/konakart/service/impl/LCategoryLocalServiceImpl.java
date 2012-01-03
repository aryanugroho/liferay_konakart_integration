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

package com.liferay.konakart.service.impl;

import com.konakart.al.CategoryMgr;
import com.konakart.al.DropListElement;
import com.konakart.al.KKAppEng;
import com.konakart.al.KKAppException;
import com.konakart.app.KKException;
import com.konakart.appif.CategoryIf;
import com.liferay.konakart.service.base.LCategoryLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the l category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.konakart.service.LCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author terry
 * @see com.liferay.konakart.service.base.LCategoryLocalServiceBaseImpl
 * @see com.liferay.konakart.service.LCategoryLocalServiceUtil
 */
public class LCategoryLocalServiceImpl extends LCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.konakart.service.LCategoryLocalServiceUtil} to access the l category local service.
	 */
//	public void setKKWsEng(KKWSEngIf kkWsEng) {
//		_kkWsEng = kkWsEng;
//	}
	
	public void setKKAppEng(KKAppEng kkAppEng) 
		throws KKException, KKAppException {
		
		_kkAppEng = kkAppEng;
		
		_categoryMgr = _kkAppEng.getCategoryMgr();
		
		if (!_categoryMgr.isMgrReady()) {
			_categoryMgr.refreshConfigs();
		}
	}
	
	public List<CategoryIf> getCatMenuList() {
		return _categoryMgr.getCatMenuList();
	}
	
	public DropListElement[] getAllCatsDropList() {
		return _categoryMgr.getAllCatsDropList();
	}
	
	
	public int setCurrentCatAndUpdateProducts(int cateId) 
		throws KKException, KKAppException {
		
		return _categoryMgr.setCurrentCatAndUpdateProducts1(cateId);
	}
	
//	以下为server eng的调用，待用。
//	public Category[] getCategoryTree() throws RemoteException {	
//		return getCategoryTree(false);
//	}
//	
//	public Category getCategory(int categoryId) throws RemoteException {
//		return _kkWsEng.getCategory(
//			KKConstant.KK_DEFAULT_LANGUAGE_ID, categoryId);
//	}
//	
//	public Category[] getCategoryTree(boolean getNumProducts) 
//		throws RemoteException {
//		
//		return getCategoryTree(
//			KKConstant.KK_DEFAULT_LANGUAGE_ID, getNumProducts);
//	}
//	
//	public Category[] getAllCategoryTree(Category[] categories, 
//			boolean isFirst) {
//		
//		if (isFirst) {
//			categoryArray = null;
//		}
//		
//		for (int i = 0; i < categories.length; i++) {
//			if (categoryArray == null) {
//				categoryArray = new Category[0];
//			}
//			categoryArray = ArrayUtil.append(categoryArray, categories[i]);
//			
//			if (categories[i].getChildren() != null || 
//				categories[i].getChildren().length != 0) {
//				
//				getAllCategoryTree(categories[i].getChildren(), false);
//			}
//		}
//		
//		return categoryArray;
//	}
//	
//	public Category[] getCategoryTree(int languageId, boolean getNumProducts) 
//		throws RemoteException {
//		
//		return _kkWsEng.getCategoryTree(languageId, getNumProducts);
//	}
	
//	private static Category[] categoryArray = null;
//	private static KKWSEngIf _kkWsEng;
	private static CategoryMgr _categoryMgr;
	private static KKAppEng _kkAppEng;

}