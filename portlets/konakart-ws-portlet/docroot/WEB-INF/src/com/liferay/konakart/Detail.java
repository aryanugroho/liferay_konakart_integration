package com.liferay.konakart;

import com.konakart.al.KKAppException;
import com.konakart.al.ProductMgr;
import com.konakart.app.KKException;
import com.liferay.konakart.util.KKUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class Detail
 */
public class Detail extends MVCPortlet {

	public void render(RenderRequest renderRequest, 
			RenderResponse renderResponse) {
		
		String actionType = renderRequest.getParameter("actionType");
		
		try {
			if (Validator.isNotNull(actionType)) {
				if (actionType.equals("showProductDetailAction")) {
					include("/html/detail/product_detail.jsp", 
						renderRequest, renderResponse);
				} else if (actionType.equals("showProductListAction")) {
					include("/html/detail/product_list.jsp", 
						renderRequest, renderResponse);
				}
			} else {
				include("/html/detail/view.jsp", renderRequest, renderResponse);
			}
		} catch (PortletException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	}
}
