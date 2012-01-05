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

<%@ include file="/html/init.jsp" %>
<%@page import="com.konakart.appif.CategoryIf"%>


<%
	PortletPreferences preferences = renderRequest.getPreferences();
		
	String portletResource = ParamUtil.getString(
		renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
			renderRequest, portletResource);
	}
	
	String searchType = PrefsParamUtil.getString(preferences, renderRequest, "searchType", PortletConstants.FIND);
%>