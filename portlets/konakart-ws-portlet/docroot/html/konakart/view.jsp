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
	Product[] productArray = (Product[])renderRequest.getAttribute("productArray");

	String serviceUrl = (String)renderRequest.getAttribute("serviceUrl");
		
	String imgUrl = serviceUrl + "images/";
	
	String ourl = serviceUrl + "SelectProd.do?prodId=";
	
	String showType = (String)renderRequest.getAttribute("showType");;
	
	out.print(showType+"<br>");
	
	for(int i = 0;i<productArray.length;i++){
		out.print(productArray[i].getName()+"<br>");
		String jj = imgUrl +productArray[i].getImage();
		
		%>
		<a href="<%= ourl + productArray[i].getId()%>"><img src="<%= jj %>"/></a><br>
<%
	}
%>

