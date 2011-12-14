<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.konakart.ws.KKWSEngIf"%>
<%@page import="com.konakart.wsapp.Product"%>
<%@page import="com.konakart.wsapp.Review"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.SetUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.liferay.konakart.service.LReviewLocalServiceUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.konakart.service.LManufacturerLocalServiceUtil"%>
<%@page import="com.konakart.wsapp.Manufacturer"%>

<%@page import="com.liferay.konakart.util.PortletConstants"%>
<%@page import="com.liferay.konakart.service.LPruductLocalServiceUtil"%>
<%@page import="com.liferay.konakart.util.KKWsUtil"%>
<%@page import="com.liferay.konakart.util.KKConstant"%>

<%@page import="com.liferay.konakart.service.LCategoryLocalServiceUtil"%>
<%@page import="com.konakart.wsapp.Category"%>

<portlet:defineObjects />

<%
	PortletPreferences preferences = renderRequest.getPreferences();
		
	String portletResource = ParamUtil.getString(
		renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
			renderRequest, portletResource);
	}
	
	String searchType = PrefsParamUtil.getString(preferences, renderRequest, "searchType", PortletConstants.FIND);
	
	KKWSEngIf kkWsEng = KKWsUtil.getKKWsEng(renderRequest);
	
	LManufacturerLocalServiceUtil.setKKWsEng(kkWsEng);	 
	LPruductLocalServiceUtil.setKKWsEng(kkWsEng);
	LCategoryLocalServiceUtil.setKKWsEng(kkWsEng);
%>