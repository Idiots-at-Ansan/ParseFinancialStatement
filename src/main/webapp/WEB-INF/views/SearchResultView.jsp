<%@page import="java.util.ArrayList"%>
<%@page import="com.company.dto.SearchItem" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Test
<%
ArrayList<SearchItem> items = (ArrayList<SearchItem>)request.getAttribute("items");
if (items != null){
	for (int i = 0; i < items.size(); i++) {
		%>
		<%=items.get(i).corp_code %>, <br>
		<%=items.get(i).corp_name %>, <br>
		<%=items.get(i).stock_code %>, <br>
		<%
	}
}
%>

</body>
</html>