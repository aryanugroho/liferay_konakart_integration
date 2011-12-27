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

<%@ include file="/html/detail/init.jsp" %>

<%
	String backURL = ParamUtil.getString(request, "backURL");
		 
	Product product = (Product) renderRequest.getAttribute("product");
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='product-detatil'
/>

name : <%= product.getName() %> <br>
price: <%= product.getPriceExTax() %> <br>
Description: <%= product.getDescription() %> <br>

<% 
	if (product.getOpts().length != 0) {
%>
	<select>
		<% for (int i = 0; i <product.getOpts().length; i++) {%>
			<option><%=product.getOpts()[i].getValue() %></option>
		<%} %>
	</select>
<% }%>
