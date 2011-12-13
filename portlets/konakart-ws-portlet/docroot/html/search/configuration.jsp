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

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<liferay-ui:panel-container extended="<%= true %>" id="settingsPanelContainer" persistState="<%= true %>">
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="overallPanel" persistState="<%= true %>" title="overall">
			<aui:fieldset>
				<aui:select label="search-type" name="preferences--searchType--">
					<aui:option label="find" selected='<%=searchType.equals(PortletConstants.FIND) %>' value="<%= PortletConstants.FIND %>"/>
					<aui:option label="manufacturer" selected='<%= searchType.equals(PortletConstants.MANUFACTURER) %>' value="<%= PortletConstants.MANUFACTURER %>"/>
					<aui:option label="categories" selected='<%= searchType.equals(PortletConstants.CATEGORIES) %>' value="<%= PortletConstants.CATEGORIES %>"/>
				</aui:select>
			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>