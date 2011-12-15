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
<%! 
	String calculateBlank(int count) {
		String blanks = "";
		
		for (int m = 0; m < count; m++) {
			blanks = blanks + "->->";
		}
		
		return blanks;
	}
%>
<%
	Category[] categories = LCategoryLocalServiceUtil.getCategoryTree(true);
	
	Category[] allCategoryTrees = LCategoryLocalServiceUtil.getAllCategoryTree(categories, true);
	
	for (int i = 0; i < allCategoryTrees.length; i++) { 
%>
	<aui:a href="www.baidu.com"><%= calculateBlank(allCategoryTrees[i].getLevel()) + allCategoryTrees[i].getName() %></aui:a>		
		<br>
	<%
	}
	%>

