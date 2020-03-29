<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>corp_code</th>
		<th>corp_name</th>
		<th>stock_code</th>
		<th>corp_cls</th>
		<th>report_nm</th>
		<th>rcept_no</th>
		<th>flr_nm</th>
		<th>rcept_dt</th>
		<th>r</th>
	</tr>
	<c:forEach var="i" begin="0" end="${result.size()-1 }">
		<tr style = "cursor:pointer;" onclick="location.href='download?rcept_no=${result.get(i).getRcept_no()}&report_nm=${result.get(i).getReport_nm()}'">
			<td><c:out value="${result.get(i).getCorp_code()}" /></td>
			<td><c:out value="${result.get(i).getCorp_name()}" /></td>
			<td><c:out value="${result.get(i).getStock_code()}" /></td>
			<td><c:out value="${result.get(i).getCorp_cls()}" /></td>
			<td><c:out value="${result.get(i).getReport_nm()}" /></td>
			<td><c:out value="${result.get(i).getRcept_no()}" /></td>
			<td><c:out value="${result.get(i).getFlr_nm()}" /></td>
			<td><c:out value="${result.get(i).getRm()}" /></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>