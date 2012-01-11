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
	ProductIf[] products = KKUtil.getProductMgr().getCurrentProducts();	
		
	String currentURL = PortalUtil.getCurrentURL(request);
		
	List<ProductIf> productList = Arrays.asList(products);
		
	CategoryIf[] currentSubCates = cateMgr.getCurrentSubCats();
	
	CategoryIf[] currentCates = prodMgr.getCurrentCategories();
	
	String renderUrl = "";		

	if (Validator.isNotNull(currentSubCates)) {
		List<CategoryIf> currentSubCatesList = Arrays.asList(currentSubCates);
		
		%>
	<b>Categories</b>
	
<liferay-ui:search-container
	delta='<%= rowsPerPage %>'
	>
	
	<liferay-ui:search-container-results
		results="<%= ListUtil.subList(currentSubCatesList, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= currentSubCatesList.size() %>" />

		<liferay-ui:search-container-row
			className="com.konakart.appif.CategoryIf" keyProperty="id"
			modelVar="category" escapedModel="false">
			
			<liferay-portlet:actionURL name="showSubCateProductList" varImpl="rowURL">
	   			<portlet:param name="backURL" value="<%= currentURL %>" />
	   			<portlet:param name="actionType" value="showProductListAction" />
	   			<portlet:param name="categoryId" value="<%= String.valueOf(category.getId()) %>" />
	  		</liferay-portlet:actionURL>
  		
			<liferay-ui:search-container-column-text
				href="<%= rowURL.toString() %>"
				name="Name"
				value="<%= category.getName() %>"
			/>
			<liferay-ui:search-container-column-text 
				name="Image"
			>
				<liferay-ui:icon
					src="<%= imgURL + category.getImage()%>"
				/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
	
	<%
	}
	
	if (Validator.isNotNull(currentCates)) {
		Object fiterCateId = request.getAttribute("fiterCategoryId");
		
		int currentCateId = -100;
		
		if (fiterCateId != null) {
			currentCateId = Integer.valueOf(fiterCateId.toString());
		}
	%>
	<portlet:actionURL name="fiterByCate" var="fiterByCateURL"/>
	
	<aui:form method="post" name="fm" action="<%= fiterByCateURL.toString() %>">
		<aui:select name="fiterCategoryId" onChange="fiterByCate();">
			<aui:option value="-100">All Categories</aui:option>
				
			<% 
			for (int i = 0; i < currentCates.length; i++) {
			%>
			<aui:option value="<%= currentCates[i].getId() %>"selected="<%= currentCates[i].getId() == currentCateId %>"><%= currentCates[i].getName() %></aui:option>
			<% 
			}
			%>
	</aui:select>
</aui:form>
	
	<%
	}
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
		
		<liferay-portlet:actionURL name="showProductDetail" varImpl="rowURL">
   			<portlet:param name="backURL" value="<%= currentURL %>" />
   			<portlet:param name="actionType" value="showProductDetailAction" />
   			<portlet:param name="productId" value="<%= String.valueOf(product.getId()) %>" />
  		</liferay-portlet:actionURL>
  		
		<%
		int productId = product.getId();
		
		renderUrl = rowURL.toString();
		
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
					>
					<liferay-ui:icon
						src="<%= imgURL + product.getImage()%>"
					/>
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
						buffer.append(kkAppEng.formatPrice(price));
					} else {
						buffer.append("<s>");
						buffer.append(kkAppEng.formatPrice(price));
						buffer.append("</s> ");
						buffer.append("<i><font color='red'>");
						buffer.append(kkAppEng.formatPrice(specialPrice));
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

<aui:script>
	function fiterByCate() {
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>