package com.liferay.konakart.util;

import com.konakart.al.CategoryMgr;
import com.konakart.al.KKAppEng;
import com.konakart.al.KKAppException;
import com.konakart.al.ProductMgr;
import com.konakart.al.StoreInfo;
import com.konakart.app.EngineConfig;
import com.konakart.app.KKException;
import com.konakart.appif.EngineConfigIf;

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
