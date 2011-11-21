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

<%@ include file="/html/konakart/init.jsp" %>

<% 
	String webServiceAddress = PrefsParamUtil.getString(preferences, renderRequest, "webServiceAddress", "");
	
	String showType = PrefsParamUtil.getString(preferences, renderRequest, "showType");
			
	int showCount = PrefsParamUtil.getInteger(preferences, renderRequest, "showCount", 5);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>

	<aui:input name="<%= com.liferay.portal.kernel.util.Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="preferences--showColumns--" type="hidden" />
	
	<aui:input helpMessage="address-help-message" lable="web-service-address" name="preferences--webServiceAddress--" type="test" value="<%= webServiceAddress %>"/> 
	
	<aui:select label="show-type" name="preferences--showType--">
		<aui:option label="best-sellers" selected='<%=showType.equals("bestsSellers") %>' value="bestsSellers"/>
		<aui:option label="special" selected='<%=showType.equals("special") %>' value="special"/>
	</aui:select>
	
	<aui:select label="show-count" name="preferences--showCount--">
		<aui:option label="1" selected="<%= showCount == 1 %>" value="1"/>
		<aui:option label="2" selected="<%= showCount == 2 %>" value="2"/>
		<aui:option label="3" selected="<%= showCount == 3 %>" value="3"/>
		<aui:option label="4" selected="<%= showCount == 4 %>" value="4"/>
		<aui:option label="5" selected="<%= showCount == 5 %>" value="5"/>
	</aui:select>
	
	<aui:field-wrapper label="show-columns">
		<%
		String allShowColumns = "name,image,price,special-price";
		Set availableColumns = SetUtil.fromArray(StringUtil.split(allShowColumns));
		// Left list

		List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();
		
		String[] showsColumns = StringUtil.split(PrefsParamUtil.getString(preferences, request, "showColumns", allShowColumns));
		
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
	
	<aui:button-row>
		<aui:button  type="submit" />
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