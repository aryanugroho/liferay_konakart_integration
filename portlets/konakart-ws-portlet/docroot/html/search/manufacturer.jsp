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

<%
	Manufacturer[] manufacturers = LManufacturerLocalServiceUtil.getAllManufacturers();
%>

<aui:select name="manufacturerId" title="manufacturers">
	<aui:option value="0">Please Select</aui:option>
		
	<% 
	for (int i = 0; i < manufacturers.length; i++) {
	%>
	<aui:option value="<%= manufacturers[i].getId() %>"><%= manufacturers[i].getName() %></aui:option>
	<% 
	}
	%>
</aui:select>