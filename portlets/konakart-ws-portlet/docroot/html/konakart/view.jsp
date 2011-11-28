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

<%@page import="com.liferay.konakart.service.LReviewLocalServiceUtil"%>
<%@ include file="/html/konakart/init.jsp" %>

<% 	
	Product[] productArray = (Product[]) renderRequest.getAttribute("productArray");

	List<Product> productList = Arrays.asList(productArray);
		
	String serviceUrl = (String) renderRequest.getAttribute("serviceUrl");
		
	String imgUrl = serviceUrl + "images/";
	
	String ourl = serviceUrl + "SelectProd.do?prodId=";
	
	String showType = (String)renderRequest.getAttribute("showType");;
	
	out.print(showType+"<br>");	
%>

<liferay-ui:search-container
	delta='<%= GetterUtil.getInteger(preferences.getValue("rowsPerPage", "5")) %>'
	emptyResultsMessage="there are no products"
	>
	
	<liferay-ui:search-container-results
		results="<%= ListUtil.subList(productList, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= productList.size() %>" />

	<liferay-ui:search-container-row
		className="com.konakart.wsapp.Product" keyProperty="id"
		modelVar="product" escapedModel="false">

		<%
			int productId = product.getId();
			LReviewLocalServiceUtil.setKKWsEng(kkWsEng);
			
			float d = (float)LReviewLocalServiceUtil.getAverageRating(productId);
			
		%>

		<liferay-ui:search-container-column-text
			name="Name"
			value="<%= product.getName() %>"
		/>
		
		<liferay-ui:search-container-column-text 
			name="Image"
			>
			<liferay-ui:icon
				src="<%= imgUrl + product.getImage()%>"
			/>
		</liferay-ui:search-container-column-text>
	
		<liferay-ui:search-container-column-text
			name="Price"
			value="<%= String.valueOf(product.getPriceExTax()) %>" 
		/>

		<liferay-ui:search-container-column-text
			name="Sepcial Price"
			value="<%= String.valueOf(product.getSpecialPriceExTax()) %>" 
		/>
		
		<liferay-ui:search-container-column-score
			name="Reviews"
			score="<%= d*2/10 %>" 
		/>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


