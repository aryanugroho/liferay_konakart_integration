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
	String currentURL = PortalUtil.getCurrentURL(request);
%>
<c:choose>
	<c:when test="<%= searchType.equals(PortletConstants.FIND) %>">
		<portlet:actionURL name="QuickFina" var="search"/>
		
		<aui:form action="<%= search.toString() %>">
			<aui:input name="productKeyWord"></aui:input>
			
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
		
		<portlet:renderURL var="advancedSearchUrl">
			<portlet:param name="jspPage" value="/html/search/advanced_search.jsp" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
		</portlet:renderURL>
		
		<aui:a href="<%= advancedSearchUrl.toString() %>">Advanced Search</aui:a>	
	</c:when>
	<c:when test="<%= searchType.equals(PortletConstants.MANUFACTURER) %>">
		<%@ include file="/html/search/manufacturer.jsp" %>
	</c:when>
	<c:when test="<%= searchType.equals(PortletConstants.CATEGORIES) %>">
		<%@ include file="/html/search/categories.jsp" %>
	</c:when>
</c:choose>