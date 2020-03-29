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

<c:forEach var="i" begin="0" end="${result.size()-1 }">
	<c:out value="${result.get(i).getSj_nm() }"/>
	<c:out value="${result.get(i).getThstrm_nm()}"/>
	<c:out value="${result.get(i).getAccount_nm()}"/>
	<c:out value="${result.get(i).getThstrm_amount() }"/>
	<br>
</c:forEach>>
</body>
</html>