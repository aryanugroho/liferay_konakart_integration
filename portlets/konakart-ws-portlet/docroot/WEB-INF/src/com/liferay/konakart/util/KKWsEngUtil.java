package com.liferay.konakart.util;

import com.konakart.ws.KKWSEngIf;
import com.konakart.ws.KKWSEngIfServiceLocator;

import java.net.URL;

import javax.xml.rpc.ServiceException;

public class KKWsEngUtil {
	
	public static KKWSEngIf getKKWsEngUtil() {
		try {
			_kkWsEng = new KKWSEngIfServiceLocator().getKKWebServiceEng();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return _kkWsEng;
	}
	
	public static KKWSEngIf getKKWsEngUtil(URL webServiceURL) {
		try {
			_kkWsEng = new KKWSEngIfServiceLocator().
				getKKWebServiceEng(webServiceURL);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return _kkWsEng;
	}
	
	private static KKWSEngIf _kkWsEng;
}
