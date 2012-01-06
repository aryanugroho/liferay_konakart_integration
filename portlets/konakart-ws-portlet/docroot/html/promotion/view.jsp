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

<%
	ProductIf[] products = (ProductIf[]) renderRequest.getAttribute("products");	

	List<ProductIf> productList = Arrays.asList(products);
		
	String renderUrl = "";	
	
	out.print(showType+"<br>");	
%>

<liferay-ui:search-container
	delta='<%= rowsPerPage %>'
	headerNames="<%= StringUtil.merge(showsColumns) %>"
	emptyResultsMessage="there are no products"
	>
	
	<liferay-ui:search-container-results
		results="<%= ListUtil.subList(productList, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= productList.size() %>" />

	<liferay-ui:search-container-row
		className="com.konakart.appif.ProductIf" keyProperty="id"
		modelVar="product" escapedModel="false">

		<%
		int productId = product.getId();
		
		if (linkType.equals(PortletConstants.NOLINK)) {
			renderUrl = null;
		} else if(linkType.equals(PortletConstants.LINKTOSITE)) {
			renderUrl = null;
		} else if(linkType.equals(PortletConstants.DETAIL)) {
			
			PortletURL pUrl = renderResponse.createActionURL();
			pUrl.setParameter("productId", String.valueOf(productId));
			
			renderUrl = pUrl.toString();
		}
		
		for (int i = 0;i < showsColumns.length; i++) {
			String showsColumn = showsColumns[i];
		%>
		
		<c:choose>
			<c:when test='<%= showsColumn.equals("name") %>'>
				<liferay-ui:search-container-column-text
					href="<%= renderUrl %>"
					name="Name"
					value="<%= product.getName() %>"
				/>
			</c:when>
		
			<c:when test='<%= showsColumn.equals("image") %>'>
				<liferay-ui:search-container-column-text 
					href="<%= renderUrl  %>"
					name="Image"
					value="<%= product.getImage() %>"
					>
				</liferay-ui:search-container-column-text>
			</c:when>
			
			<c:when test='<%= showsColumn.equals("price") %>'>
				<liferay-ui:search-container-column-text
					name="Price"
					href="<%= renderUrl  %>"
					buffer="buffer" 
				>
				
				<% 	
					BigDecimal price;
					BigDecimal specialPrice;
					
					if (withTax) {
						price = product.getPriceIncTax();
						specialPrice = product.getSpecialPriceIncTax();
					} else {
						price = product.getPriceExTax();
						specialPrice = product.getSpecialPriceExTax();
					}
					
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
			</c:when>
			
		</c:choose>
		<% } %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>