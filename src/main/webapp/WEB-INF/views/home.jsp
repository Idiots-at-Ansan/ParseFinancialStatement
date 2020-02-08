<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
	<title>Home</title>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form">
				<div class="form-group">
					<label for="InputName">
						기업명
					</label>
					<input type="text" class="form-control" id="InputName" />
				</div>
				<div class="form-group">
					<label for="InputDate">
						조회날짜
					</label>
					<input type="date" class="form-control" id="InputDate" /> ~ <input type="date" class="form-control" id="InputDate" />
				</div>
				<div class="form-group">
					 
					<label for="exampleInputFile">
						다운받은 파일 목록 (조회날짜 내 등록된 재무제표 등록)
					</label>
					<div>
						
					</div>
				</div>
				<button type="submit" class="btn btn-primary">
					선택조회
				</button>
			</form>
		</div>
	</div>
	<div class="col-md-12">
		결과부분
	</div>
</div>
</body>
</html>
