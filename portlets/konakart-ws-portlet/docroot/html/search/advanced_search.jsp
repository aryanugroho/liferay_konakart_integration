<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

<%@page import="com.liferay.konakart.util.KKConstants"%>
<%@ include file="/html/search/init.jsp" %>

<% 
	String backURL = ParamUtil.getString(request, "backURL");
	
	DropListElement[] manufacturers = KKUtil.getProductMgr().getAllManuDropList();
	
	DropListElement[] allcats = KKUtil.getCategoryMgr().getAllCatsDropList();
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='advanced-search'
/>

<portlet:actionURL name="advancedSearch" var="advancedSearchUrl"/>

<aui:form action="<%= advancedSearchUrl.toString() %>">
	<aui:input name="searchCriteria" title="search-criteria:" type="text"></aui:input>
	
	<aui:select name="categoryId" title="categories">
		<aui:option value="<%= KKConstants.ALL_CATEGORIES %>">All Categories</aui:option>
		
		<% 
		for (int i = 0; i < allcats.length; i++) {
		%>
		<aui:option value="<%= allcats[i].getId() %>"><%= allcats[i].getDesc() %></aui:option>
		<% 
		}
		%>
	</aui:select>
	
	<aui:select name="manufacturerId" title="manufacturers">
		<aui:option value="<%= KKConstants.ALL_MANUFACTURER %>">All Manufacturers</aui:option>
		
		<% 
		for (int i = 0; i < manufacturers.length; i++) {
		%>
		<aui:option value="<%= manufacturers[i].getId() %>"><%= manufacturers[i].getDesc() %></aui:option>
		<% 
		}
		%>
	</aui:select>
	
	<aui:input name="priceFrom" type="text"></aui:input>
	
	<aui:input name="priceTo" type="text"></aui:input>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>