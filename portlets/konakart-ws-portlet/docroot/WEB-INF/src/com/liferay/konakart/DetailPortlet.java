package com.liferay.konakart;

import com.konakart.ws.KKWSEngIf;
import com.konakart.wsapp.Product;
import com.liferay.konakart.service.LProductLocalServiceUtil;
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
		
		LProductLocalServiceUtil.setKKWsEng(kkWSEng);
		
		renderRequest.setAttribute("kkWSEng", kkWSEng);
		
		String searchKey = ParamUtil.getString(renderRequest, "searchKey");
		
		String[] valueAndType = null;
		
		if (Validator.isNotNull(searchKey)) {
			valueAndType = StringUtil.split(searchKey, "#");

			if (Validator.isNotNull(valueAndType[0])) {
				if (valueAndType[1].equals("productId")) {
					int productId = Integer.valueOf(valueAndType[0]);
					
					Product product = LProductLocalServiceUtil.getProduct(
						productId);
					
					renderRequest.setAttribute("product", product);
					
					include("/html/detail/product_detail.jsp", renderRequest, 
						renderResponse);
					
					return ;
				} else {
					Product[] products = new Product[0];
					
					if (valueAndType[1].equals("categroyId")) {
						
					} else if (valueAndType[1].equals("manufacturerId")) {
						int manufacturerId = Integer.valueOf(valueAndType[0]);
						
						products = LProductLocalServiceUtil.
							searchProductsByManufacturerId(manufacturerId);
					} else if (valueAndType[1].equals("productKeyWord")) {
						String key = valueAndType[0];
						
						products = LProductLocalServiceUtil.searchProductsByKey(
							key);
					} else if (valueAndType[1].equals("searchParams")) {
						
					}
					renderRequest.setAttribute("products", products);
					
					include("/html/detail/product_list.jsp", renderRequest, 
							renderResponse);
						
					return ;
				}
			}
		}
		
		Product[] productArray = new Product[0];
		
		productArray = LProductLocalServiceUtil.
			getLastestProducts(5);
		
		renderRequest.setAttribute("productArray", productArray);

		renderRequest.setAttribute("serviceUrl", serviceUrl);
		
		super.doView(renderRequest, renderResponse);
	}
}