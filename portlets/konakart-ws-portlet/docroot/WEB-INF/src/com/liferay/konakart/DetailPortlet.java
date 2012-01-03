package com.liferay.konakart;

import com.konakart.al.KKAppEng;
import com.konakart.al.KKAppException;
import com.konakart.app.KKException;
import com.konakart.ws.KKWSEngIf;
import com.konakart.wsapp.Product;
import com.liferay.konakart.service.LProductLocalServiceUtil;
import com.liferay.konakart.util.KKConstant;
import com.liferay.konakart.util.KKWsUtil;
import com.liferay.konakart.util.LDataDescriptor;
import com.liferay.konakart.util.LProductSearch;
import com.liferay.konakart.util.PortletConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class DetailPortlet
 */
public class DetailPortlet extends MVCPortlet {
 
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse) 
		throws IOException, PortletException{
		
		KKAppEng appEng = KKWsUtil.getKKAppEng();
		int i = appEng.getProductMgr().getCurrentProducts().length;
		System.out.println("getAllCateArray:"+i);
		try {
			appEng.getProductMgr().fetchAllNewProds();
			
			int m = appEng.getProductMgr().getCurrentProducts().length;
			System.out.println("NewProds:"+m);
		} catch (KKException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KKAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void render(
//			RenderRequest renderRequest, RenderResponse renderResponse) 
//		throws IOException, PortletException{
//		
//		String webServiceAddress = KKWsUtil.getWebServiceAddress(renderRequest);
//		
//		String serviceUrl = StringUtil.replace(webServiceAddress,
//				"services/KKWebServiceEng?wsdl", "");
//			
//		URL url = new URL(webServiceAddress);	
//		
//		KKWSEngIf kkWSEng = KKWsUtil.getKKWsEng(url);
//		
//		LProductLocalServiceUtil.setKKWsEng(kkWSEng);
//		
//		renderRequest.setAttribute("kkWSEng", kkWSEng);
//		
//		String searchKey = ParamUtil.getString(renderRequest, "searchKey");
//		
//		String[] valueAndType = null;
//		
//		if (Validator.isNotNull(searchKey)) {
//			valueAndType = StringUtil.split(searchKey, "#");
//
//			if (Validator.isNotNull(valueAndType[0])) {
//				if (valueAndType[1].equals("productId")) {
//					int productId = Integer.valueOf(valueAndType[0]);
//					
//					Product product = LProductLocalServiceUtil.getProduct(
//						productId);
//					
//					renderRequest.setAttribute("product", product);
//					
//					include("/html/detail/product_detail.jsp", renderRequest, 
//						renderResponse);
//					
//					return ;
//				} else {
//					Product[] products = new Product[0];
//					
//					if (valueAndType[1].equals("categoryId")) {
//						int categoryId = Integer.valueOf(valueAndType[0]);
//						
//						products = LProductLocalServiceUtil.searchProductsByCategoryId(categoryId);
//					} else if (valueAndType[1].equals("manufacturerId")) {
//						int manufacturerId = Integer.valueOf(valueAndType[0]);
//						
//						products = LProductLocalServiceUtil.
//							searchProductsByManufacturerId(manufacturerId);
//					} else if (valueAndType[1].equals("productKeyWord")) {
//						String key = valueAndType[0];
//						
//						products = LProductLocalServiceUtil.searchProductsByKey(
//							key);
//					} else if (valueAndType[1].equals("searchParams")) {
//						String[] searchParams = StringUtil.split(
//							valueAndType[0]);
//						
//						LProductSearch lpSearch = new LProductSearch();
//						
//						if (!searchParams[0].equals(
//								PortletConstants.LIFERAY_EMPTY)) {
//							
//							lpSearch.setSearchText(searchParams[0]);
//						}
//						if (!searchParams[1].equals(
//								PortletConstants.LIFERAY_EMPTY)) {
//							
//							lpSearch.setCategoryId(Integer.valueOf(
//								searchParams[1]));
//						}
//						if (!searchParams[2].equals(
//								PortletConstants.LIFERAY_EMPTY)) {
//							
//							lpSearch.setManufacturerId(Integer.valueOf(
//								searchParams[2]));	
//						}
//						if (!searchParams[3].equals(
//								PortletConstants.LIFERAY_EMPTY)) {
//							
//							lpSearch.setPriceFrom(new BigDecimal(
//								searchParams[3]));
//						}
//						if (!searchParams[4].equals(
//								PortletConstants.LIFERAY_EMPTY)) {
//
//							lpSearch.setPriceTo(new BigDecimal(
//								searchParams[4]));
//						}
//				
//						products = LProductLocalServiceUtil.searchProducts(
//							null, new LDataDescriptor(), lpSearch, 
//							KKConstant.KK_DEFAULT_LANGUAGE_ID);
//					}
//					renderRequest.setAttribute("products", products);
//					
//					include("/html/detail/product_list.jsp", renderRequest, 
//							renderResponse);
//						
//					return ;
//				}
//			}
//		}
//		
//		String showType = KKWsUtil.getShowType(renderRequest);
//		
//		int showCount = KKWsUtil.getShowCount(renderRequest);
//		
//		Product[] productArray = new Product[0];
//		
//		if (showType.equals(PortletConstants.BESTSELLERS)) {
//			productArray = LProductLocalServiceUtil.
//				getBestSellers(showCount);
//		} else if (showType.equals(PortletConstants.SPECIAL)) {
//			productArray = LProductLocalServiceUtil.
//				getSpecialProducts(showCount);
//		} else if (showType.equals(PortletConstants.LATEEST)) {
//			productArray = LProductLocalServiceUtil.
//				getLastestProducts(showCount);
//		}
//					
//		renderRequest.setAttribute("kkWSEng", kkWSEng);
//			
//		renderRequest.setAttribute("productArray", productArray);
//
//		renderRequest.setAttribute("serviceUrl", serviceUrl);
//		
//		super.doView(renderRequest, renderResponse);
//	}
}