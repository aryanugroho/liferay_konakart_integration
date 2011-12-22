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

<%@ include file="/html/detail/init.jsp" %>

<% 
	Product[] productArray = (Product[]) renderRequest.getAttribute("productArray");
	
	List<Product> productList = Arrays.asList(productArray);
	
	String serviceUrl = (String) renderRequest.getAttribute("serviceUrl");
		
	String imgUrl = serviceUrl + "images/";
%>

<liferay-ui:search-container
	delta='<%= 5 %>'
	emptyResultsMessage="there are no products"
	>
	
	<liferay-ui:search-container-results
		results="<%= ListUtil.subList(productList, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= productList.size() %>" />

	<liferay-ui:search-container-row
		className="com.konakart.wsapp.Product" keyProperty="id"
		modelVar="product" escapedModel="false">

		<%
			int pId = product.getId();
		
			String productId = String.valueOf(pId)+"#productId";
		
			Product productDetail = LProductLocalServiceUtil.getProduct(pId);
			
			PortletUtil.cutOut(productDetail.getDescription());
		%>
		<portlet:renderURL var="testActionUrl">
			<portlet:param name="jspPage" value="/html/detail/product_detail.jsp"></portlet:param>
			<portlet:param name="searchKey" value="<%= productId %>"></portlet:param>
		</portlet:renderURL>
		<liferay-ui:search-container-column-text
			href="<%= testActionUrl.toString() %>"
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
			buffer="buffer" 
		>
				
			<% 	
				BigDecimal price;
				BigDecimal specialPrice;
				
				price = product.getPriceExTax();
				specialPrice = product.getSpecialPriceExTax();
			
				if (Validator.isNull(specialPrice)) {
					buffer.append("$");
					buffer.append(price);
				} else {
					buffer.append("<s>$");
					buffer.append(price);
					buffer.append("</s> ");
					buffer.append("<i><font color='red'>$");
					buffer.append(specialPrice);
					buffer.append("</font></i>");
				}
			%>
				
		</liferay-ui:search-container-column-text>
			
		<liferay-ui:search-container-column-text
			href="<%= testActionUrl.toString() %>"
			name="Description"
			value="<%= PortletUtil.cutOut(productDetail.getDescription()) %>"
		/>	
			
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
