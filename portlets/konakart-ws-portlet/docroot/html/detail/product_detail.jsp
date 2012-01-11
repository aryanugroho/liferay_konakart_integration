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
	String backURL = ParamUtil.getString(request, "backURL");
		
	ProductMgr productMgr = KKUtil.getProductMgr();
	
	ProductIf product = productMgr.getSelectedProduct();
	
	String prodUrl = product.getUrl();
%>

<liferay-ui:header
	backURL="<%= backURL %>"
	title='product-detatil'
/>

<%= product.getName() %> <br>

[<%=product.getModel()%>]<br>

<%if (product.getQuantity()>0){%>
	 - <%=product.getQuantity()%> In stock
<%}else{%>
	Out of stock
<%}%>	

<br>
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
		out.print(kkAppEng.formatPrice(price));
	} else {
		out.print("<s>");
		out.print(kkAppEng.formatPrice(price));
		out.print("</s> ");
		out.print("<i><font color='red'>");
		out.print(kkAppEng.formatPrice(specialPrice));
		out.print("</font></i>");
	}
%>
<br>
<img src="<%= imgURL + product.getImage()%>"></img>
<br>
<%= product.getDescription() %> <br>

<% 
List<ProdOptionContainer> selectedOpts = prodMgr.getSelectedProductOptions();

Iterator opts = selectedOpts.iterator();

while (opts.hasNext()) {
	ProdOptionContainer optContainer = (ProdOptionContainer)opts.next();
	
	List<ProdOption> values = optContainer.getOptValues();
	
	out.print(optContainer.getName()+":");
	out.print("<select>");
	for (int i = 0; i < values.size(); i++) {
		out.print("<option>"+values.get(i).getFormattedValueExTax()+"</option>");
	}
	out.print("</select>");
	out.print("<br>");
}

if (prodUrl != null && ((String)(prodUrl)).length() > 0){%>
	For more information, please visit this product<a href="http://<%=prodUrl%>" target="_blank"><u>webpage</u></a>.</p>
<%}%>	