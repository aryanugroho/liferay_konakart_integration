package com.liferay.konakart;

import com.konakart.al.KKAppException;
import com.konakart.al.ProductMgr;
import com.konakart.app.KKException;
import com.konakart.appif.ProductIf;
import com.liferay.konakart.util.KKUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class Detail
 */
public class Detail extends MVCPortlet {

	public void render(RenderRequest renderRequest, 
			RenderResponse renderResponse) {
		try {
			ProductMgr productMgr = KKUtil.getProductMgr();
			ProductIf[] products = productMgr.getCurrentProducts();
			for (int i = 0; i < products.length; i++) {
				ProductIf product = products[i];
				System.out.println(product.getName());
			}
		//	productMgr.reset();
			System.out.println("=========================");
			System.out.println(productMgr.getCurrentProducts().length);
			System.out.println("=========================");
			
			super.render(renderRequest, renderResponse);
		} catch (KKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void showProductDetail(RenderRequest renderRequest, 
			RenderResponse renderResponse) 
		throws KKException, KKAppException {
		
		int productId = ParamUtil.getInteger(renderRequest, "productId");
		
		ProductMgr productMgr = KKUtil.getProductMgr();
		
		productMgr.fetchSelectedProduct(productId);
		
		productMgr.fetchAlsoPurchasedArray();
		
		productMgr.fetchRelatedProducts();
		
		ProductIf product = productMgr.getSelectedProduct();
	}
}
