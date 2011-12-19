package com.liferay.konakart;

import com.konakart.ws.KKWSEngIf;
import com.konakart.wsapp.Product;
import com.liferay.konakart.service.LPruductLocalServiceUtil;
import com.liferay.konakart.util.KKWsUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.net.URL;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class DetailPortlet
 */
public class DetailPortlet extends MVCPortlet {
 
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		
		String webServiceAddress = KKWsUtil.getWebServiceAddress(renderRequest);
		
		String serviceUrl = StringUtil.replace(webServiceAddress,
				"services/KKWebServiceEng?wsdl", "");
			
		URL url = new URL(webServiceAddress);	
		
		KKWSEngIf kkWSEng = KKWsUtil.getKKWsEng(url);
		
		LPruductLocalServiceUtil.setKKWsEng(kkWSEng);
		
		renderRequest.setAttribute("kkWSEng", kkWSEng);
		
		String searchKey = ParamUtil.getString(renderRequest, "searchKey");
		
		String[] valueAndType = null;
		
		if (Validator.isNotNull(searchKey)) {
			valueAndType = StringUtil.split(searchKey, "#");

			if (Validator.isNotNull(valueAndType[0])) {
				if (valueAndType[1].equals("productId")) {
					
					Product product = LPruductLocalServiceUtil.getProduct(
						Integer.valueOf(valueAndType[0]));
					
					renderRequest.setAttribute("product", product);
					
					include("/html/detail/product_detail.jsp", renderRequest, 
						renderResponse);
					
					return ;
				} else if (valueAndType[1].equals("categroyId")) {
					renderRequest.setAttribute("categroyId", valueAndType[0]);
					
				} else if (valueAndType[1].equals("manufacturerId")) {
					renderRequest.setAttribute("manufacturerId", valueAndType[0]);
				} else if (valueAndType[1].equals("productKeyWord")) {
					renderRequest.setAttribute("productKeyWord", valueAndType[0]);
				} else if (valueAndType[1].equals("searchParams")) {
					
				}
			}
		}
		
		Product[] productArray = new Product[0];
		
		productArray = LPruductLocalServiceUtil.
			getLastestProducts(5);
		
		renderRequest.setAttribute("productArray", productArray);

		renderRequest.setAttribute("serviceUrl", serviceUrl);
		
		super.doView(renderRequest, renderResponse);
	}
}