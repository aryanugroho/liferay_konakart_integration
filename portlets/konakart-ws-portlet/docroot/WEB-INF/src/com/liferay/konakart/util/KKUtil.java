package com.liferay.konakart.util;

import com.konakart.al.CategoryMgr;
import com.konakart.al.KKAppEng;
import com.konakart.al.KKAppException;
import com.konakart.al.ProductMgr;
import com.konakart.al.StoreInfo;
import com.konakart.app.EngineConfig;
import com.konakart.app.KKException;
import com.konakart.appif.EngineConfigIf;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KKUtil {
	static {
		try {
			EngineConfigIf engConf = new EngineConfig();
			engConf.setAppPropertiesFileName("konakart_app.properties");
			_kkAppEng = new KKAppEng(engConf);
			
			StoreInfo si = new StoreInfo();
			si.setStoreId(engConf.getStoreId());
			_kkAppEng = new KKAppEng(si);
		} catch (Exception e) {
			
		}
	}
	
	public static KKAppEng getKKAppEng() {
		return _kkAppEng;
	}
	
	public static String getServerURL() {
		String webServerURL = "";
		String serverURL = "";
		String propURL = KKUtil.class.getClassLoader().
			getResource("konakart_axis_client.properties").getPath();
		
		if (Validator.isNotNull(propURL)) {
			InputStream in;
			
			try {
				Properties prop = new Properties();
				
				in = new BufferedInputStream(new FileInputStream(propURL));
				
				prop.load(in);
				
				webServerURL = prop.getProperty("konakart.webservice.URL");
				
				serverURL = StringUtil.replace(
					webServerURL, "services/KKWebServiceEng", "");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return serverURL;
	}
	
	public static String getImageUrl() {
		return getServerURL() + "images/";
	}
	
	public static ProductMgr getProductMgr() throws KKException {
		_prodcutMgr = _kkAppEng.getProductMgr();
		
		if (!_prodcutMgr.isMgrReady()) {
			_prodcutMgr.refreshConfigs();
		}
		
		return _prodcutMgr;
	}
	
	public static CategoryMgr getCategoryMgr() 
		throws KKException, KKAppException {
		
		_categoryMgr = _kkAppEng.getCategoryMgr();
		
		if (!_categoryMgr.isMgrReady()) {
			_categoryMgr.refreshConfigs();
		}
		
		return _categoryMgr;
	}
	
	private static CategoryMgr _categoryMgr;
	private static ProductMgr _prodcutMgr;
	private static KKAppEng _kkAppEng;
}
