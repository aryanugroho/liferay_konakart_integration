package com.liferay.konakart;

import com.konakart.ws.KKWSEngIf;
import com.konakart.wsapp.Product;

import com.liferay.konakart.service.LPruductLocalServiceUtil;
import com.liferay.konakart.util.KKWsUtil;
import com.liferay.konakart.util.PortletConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class Konakart
 */
public class PromotionPortlet extends MVCPortlet {

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		
			String webServiceAddress = KKWsUtil.getWebServiceAddress(renderRequest);
			
			String serviceUrl = StringUtil.replace(webServiceAddress,
				"services/KKWebServiceEng?wsdl", "");
			
			URL url = new URL(webServiceAddress);	
			
			KKWSEngIf kkWSEng = KKWsUtil.getKKWsEngUtil(url);
			
			LPruductLocalServiceUtil.setKKWsEng(kkWSEng);
			
			String showType = KKWsUtil.getShowType(renderRequest);
			
			int showCount = KKWsUtil.getShowCount(renderRequest);
			
			Product[] productArray = new Product[0];
			
			boolean showRandom = KKWsUtil.getShowRandom(renderRequest);
			
			int count =  showCount;
			
			if (showRandom) {
				showCount = showCount *2; 
			}
			
			if (showType.equals(PortletConstants.BESTSELLERS)) {
				productArray = LPruductLocalServiceUtil.
					getBestSellers(showCount);
			} else if (showType.equals(PortletConstants.SPECIAL)) {
				productArray = LPruductLocalServiceUtil.
					getSpecialProducts(showCount);
			} else if (showType.equals(PortletConstants.LATEEST)) {
				productArray = LPruductLocalServiceUtil.
					getLastestProducts(showCount);
			}
			
			if (showRandom) {
				productArray = getRandomShowProducts(productArray, count); 
			}
			
			renderRequest.setAttribute("kkWSEng", kkWSEng);
			
			renderRequest.setAttribute("productArray", productArray);
	
			renderRequest.setAttribute("showType", showType);
	
			renderRequest.setAttribute("serviceUrl", serviceUrl);
			
			super.doView(renderRequest, renderResponse);	
	}
	
	protected Product[] getRandomShowProducts(
			Product[] products, int showCount) {
		
		Product[] randomProducts;
		
		if (products.length <= showCount) {
			randomProducts = products;
		} else {
			randomProducts = new Product[showCount];
			
			Random random = new Random();
			
			int i = 0;
			
			while (i < showCount) {
				int r = random.nextInt(products.length);
				
				if (!ArrayUtil.contains(randomProducts, products[r])) {
					randomProducts[i] = products[r];
					i++;
				}
			}
		}
		
		return randomProducts;
	}
}