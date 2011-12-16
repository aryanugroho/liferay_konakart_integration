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
		
		String searchKey = ParamUtil.getString(renderRequest, "searchKey");
		
		String[] valueAndKey = null;
		
		if (Validator.isNotNull(searchKey)) {
			valueAndKey = StringUtil.split(searchKey, "#");

			if (Validator.isNotNull(valueAndKey[0])) {
				System.out.println(valueAndKey[0]);
				System.out.println(valueAndKey[1]);
			}
		}
		
		String webServiceAddress = KKWsUtil.getWebServiceAddress(renderRequest);
	
		String serviceUrl = StringUtil.replace(webServiceAddress,
				"services/KKWebServiceEng?wsdl", "");
			
		URL url = new URL(webServiceAddress);	
		
		KKWSEngIf kkWSEng = KKWsUtil.getKKWsEng(url);
		
		LPruductLocalServiceUtil.setKKWsEng(kkWSEng);
		
		Product[] productArray = new Product[0];
		
		productArray = LPruductLocalServiceUtil.
			getLastestProducts(5);
		
		renderRequest.setAttribute("kkWSEng", kkWSEng);
		
		renderRequest.setAttribute("productArray", productArray);

		renderRequest.setAttribute("serviceUrl", serviceUrl);
		
		super.doView(renderRequest, renderResponse);
	}
}