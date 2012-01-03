package com.liferay.konakart;

import com.konakart.al.KKAppEng;
import com.konakart.app.KKException;
import com.konakart.app.Product;
import com.konakart.appif.ProductIf;

import com.liferay.konakart.service.LProductLocalServiceUtil;
import com.liferay.konakart.util.KKWsUtil;
import com.liferay.konakart.util.PortletConstants;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class Konakart
 */
public class PromotionPortlet extends MVCPortlet {

	public void processAction(ActionRequest actionRequest,
            ActionResponse actionResponse) 
        throws PortletException, IOException {
		
		String productId = ParamUtil.getString(actionRequest, "productId");
		
		String searchKey = productId + "#productId";
		
		actionResponse.setRenderParameter("searchKey", searchKey);
	}
	
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		
		String webServiceAddress = KKWsUtil.getWebServiceAddress(
			renderRequest);
		
		String serviceUrl = StringUtil.replace(webServiceAddress,
			"services/KKWebServiceEng?wsdl", "");
		
		KKAppEng kkAppEng = KKWsUtil.getKKAppEng();
		
		try {
			LProductLocalServiceUtil.setKKAppEng(kkAppEng);
						
			String showType = KKWsUtil.getShowType(renderRequest);
	
			ProductIf[] products = new Product[0];
			
			if (showType.equals(PortletConstants.BESTSELLERS)) {
				products = LProductLocalServiceUtil.getBestSeller();
			} else if (showType.equals(PortletConstants.SPECIAL)) {
				products = ArrayUtil.append(
					products, LProductLocalServiceUtil.getRandomSpecial());
			} else if (showType.equals(PortletConstants.LATEEST)) {
				products = ArrayUtil.append(
					products, LProductLocalServiceUtil.getRandomNewProd());
			}
		
			renderRequest.setAttribute("products", products);
			
			renderRequest.setAttribute("showType", showType);
		
			renderRequest.setAttribute("serviceUrl", serviceUrl);
				
			super.doView(renderRequest, renderResponse);	
		} catch (KKException e) {
			e.printStackTrace();
		}
	}

}