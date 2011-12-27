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
	String currentURL = PortalUtil.getCurrentURL(request);
		 
	String backURL = ParamUtil.getString(request, "backURL");
		 
	Product[] products = (Product[])renderRequest.getAttribute("products");
	
	List<Product> productList = Arrays.asList(products);
	
	String imgUrl = KKWsUtil.getImgUrl(renderRequest);
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='product-list'
/>

<liferay-ui:search-container
	delta='<%= rowsPerPage %>'
	emptyResultsMessage="there are no products"
	headerNames="<%= StringUtil.merge(showsColumns) %>"
	>
	
	<liferay-ui:search-container-results
		results="<%= ListUtil.subList(productList, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= productList.size() %>" />
	
	<liferay-ui:search-container-row
		className="com.konakart.wsapp.Product" keyProperty="id"
		modelVar="product" escapedModel="false">

		<%
			int pId = product.getId();
		
			String searchKey = String.valueOf(pId)+"#productId";
		
			PortletURL pUrl = renderResponse.createRenderURL();
			
			pUrl.setParameter("searchKey", searchKey);
			
			pUrl.setParameter("jspPage", "/html/detail/product_detail.jsp");
			
			pUrl.setParameter("backURL", currentURL);
			
			Product productDetail = LProductLocalServiceUtil.getProduct(pId);
			
			for (int i = 0;i < showsColumns.length; i++) {
				String showsColumn = showsColumns[i];
		%>
	
		<c:choose>
			<c:when test='<%= showsColumn.equals("name") %>'>
				<liferay-ui:search-container-column-text
					href="<%= pUrl.toString() %>"
					name="Name"
					value="<%= product.getName() %>"
				/>
			</c:when>
		
			<c:when test='<%= showsColumn.equals("image") %>'>
				<liferay-ui:search-container-column-text 
					href="<%= pUrl.toString() %>"
					name="Image"
					>
					<liferay-ui:icon
						src="<%= imgUrl + product.getImage()%>"
					/>
				</liferay-ui:search-container-column-text>
			</c:when>
			
			<c:when test='<%= showsColumn.equals("price") %>'>
				<liferay-ui:search-container-column-text
					name="Price"
					href="<%= pUrl.toString()  %>"
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
			
			<c:when test='<%= showsColumn.equals("description") %>'>
				<liferay-ui:search-container-column-text 
					href="<%= pUrl.toString() %>"
					name="Description"
					value="<%= PortletUtil.cutOut(productDetail.getDescription()) %>"
				/>
			</c:when>
		</c:choose>
		
		<% } %>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
