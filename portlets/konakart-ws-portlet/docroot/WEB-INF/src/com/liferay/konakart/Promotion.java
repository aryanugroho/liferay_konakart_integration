package com.liferay.konakart;

import com.konakart.al.ProductMgr;
import com.konakart.app.KKException;
import com.konakart.app.Product;
import com.konakart.appif.ProductIf;
import com.liferay.konakart.util.KKUtil;
import com.liferay.konakart.util.PortletConstants;
import com.liferay.konakart.util.PortletUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class Promotion
 */
public class Promotion extends MVCPortlet {
 
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		
		String showType = PortletUtil.getShowType(renderRequest);
		
		ProductIf[] products = new Product[0];
		
		ProductMgr productMgr;
		
		try {
			productMgr = KKUtil.getProductMgr();
			
			if (showType.equals(PortletConstants.BESTSELLERS)) {
				products = productMgr.getBestSellers();
			} else if (showType.equals(PortletConstants.SPECIAL)) {
				products = ArrayUtil.append(
					products, productMgr.getRandomSpecial());
			} else if (showType.equals(PortletConstants.LATEEST)) {
				products = ArrayUtil.append(
					products, productMgr.getRandomNewProd());
			}
		} catch (KKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		renderRequest.setAttribute("products", products);
		
		renderRequest.setAttribute("showType", showType);
	
		super.doView(renderRequest, renderResponse);
	}
}
