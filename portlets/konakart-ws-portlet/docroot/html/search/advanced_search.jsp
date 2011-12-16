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

<%@ include file="/html/search/init.jsp" %>

<% 
	String backURL = ParamUtil.getString(request, "backURL");
	
	Manufacturer[] manufacturers = LManufacturerLocalServiceUtil.getAllManufacturers();
	
	Category[] categories = LCategoryLocalServiceUtil.getCategoryTree(true);
	
	Category[] allCategoryTrees = LCategoryLocalServiceUtil.getAllCategoryTree(categories, true);
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='advanced-search'
/>

<portlet:actionURL name="AdvancedSearch" var="advancedSearchUrl"/>

<aui:form action="<%= advancedSearchUrl.toString() %>">
	<aui:input name="searchCriteria" title="search-criteria:" type="text"></aui:input>
	
	<aui:input name="searchInDesciption" title="search-in-product-descriptions" type="checkbox"></aui:input>
	
	<aui:select name="categoryId" title="categories">
		<aui:option value="<%= KKConstant.ALL_CATEGORIES %>">All Categories</aui:option>
		
		<% 
		for (int i = 0; i < allCategoryTrees.length; i++) {
		%>
		<aui:option value="<%= allCategoryTrees[i].getId() %>"><%= allCategoryTrees[i].getName() %></aui:option>
		<% 
		}
		%>
	</aui:select>
	
	<aui:select name="manufacturerId" title="manufacturers">
		<aui:option value="<%= KKConstant.ALL_MANUFACTURER %>">All Manufacturers</aui:option>
		
		<% 
		for (int i = 0; i < manufacturers.length; i++) {
		%>
		<aui:option value="<%= manufacturers[i].getId() %>"><%= manufacturers[i].getName() %></aui:option>
		<% 
		}
		%>
	</aui:select>
	
	<aui:input name="priceFrom" type="text"></aui:input>
	
	<aui:input name="priceTo" type="text"></aui:input>
	
	<aui:input name="dateFrom" type="text"></aui:input>
	
	<aui:input name="dateTo" type="text"></aui:input>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>