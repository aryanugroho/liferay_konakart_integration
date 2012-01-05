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

<%@ include file="/html/promotion/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="preferences--showColumns--" type="hidden" />

	<liferay-ui:panel-container extended="<%= true %>" id="settingsPanelContainer" persistState="<%= true %>">
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="overallPanel" persistState="<%= true %>" title="overall">
			<aui:fieldset>
			<aui:select label="show-type" name="preferences--showType--">
					<aui:option label="best-sellers" selected='<%=showType.equals(PortletConstants.BESTSELLERS) %>' value="<%= PortletConstants.BESTSELLERS %>"/>
					<aui:option label="special" selected='<%= showType.equals(PortletConstants.SPECIAL) %>' value="<%= PortletConstants.SPECIAL %>"/>
					<aui:option label="whats-new" selected='<%= showType.equals(PortletConstants.LATEEST) %>' value="<%= PortletConstants.LATEEST %>"/>
				</aui:select>	
				
				<aui:input label="rows-per-page" name="preferences--rowsPerPage--" type="text" size="3" value="<%= rowsPerPage %>"/>	
			
				<aui:select label="link-type" name="preferences--linkType--">
					<aui:option label="no-link" selected='<%=linkType.equals(PortletConstants.NOLINK) %>' value="<%= PortletConstants.NOLINK %>"/>
					<aui:option label="link-to-site" selected='<%=linkType.equals(PortletConstants.LINKTOSITE) %>' value="<%= PortletConstants.LINKTOSITE %>"/>
					<aui:option label="detail-portlet" selected='<%= linkType.equals(PortletConstants.DETAIL) %>' value="<%= PortletConstants.DETAIL %>"/>
				</aui:select>	
				
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="showPanel" persistState="<%= true %>" title="show">
		<aui:field-wrapper label="show-columns">
				<%
				Set availableColumns = SetUtil.fromArray(StringUtil.split(allShowColumns));
				
				// Left list
		
				List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();
				
				for (int i = 0; i < showsColumns.length; i++) {
					String showsColumn = showsColumns[i];
		
					leftList.add(new KeyValuePair(showsColumn, LanguageUtil.get(pageContext, showsColumn)));
				}
		
				// Right list
		
				List<KeyValuePair> rightList = new ArrayList<KeyValuePair>();
				
				Arrays.sort(showsColumns);
		
				Iterator itr = availableColumns.iterator();
		
				while (itr.hasNext()) {
					String showsColumn = (String)itr.next();
		
					if (Arrays.binarySearch(showsColumns, showsColumn) < 0) {
						rightList.add(new KeyValuePair(showsColumn, LanguageUtil.get(pageContext, showsColumn)));
					}
				}
		
				rightList = ListUtil.sort(rightList, new KeyValuePairComparator(false, true));
				%>
		
				<liferay-ui:input-move-boxes
					leftTitle="current"
					rightTitle="available"
					leftBoxName="currentColumns"
					rightBoxName="availableColumns"
					leftReorder="true"
					leftList="<%= leftList %>"
					rightList="<%= rightList %>"
				/>
			
			</aui:field-wrapper>
			
			</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="pricePanel" persistState="<%= true %>" title="price">
			<aui:input label="display-price-with-tax" name="preferences--withTax--" type="checkbox" value="<%= withTax %>"/>
		</liferay-ui:panel>
		
		</liferay-ui:panel-container>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />saveConfiguration',
		function() {
			document.<portlet:namespace />fm.<portlet:namespace />showColumns.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentColumns);
			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>