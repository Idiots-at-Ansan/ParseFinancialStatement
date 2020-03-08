<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<html>
<head>
	<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script>

	$(document).on('click','#getList',function(e){
		e.preventDefault();
		var t = document.getElementById("code");
		console.log(t);
		var test = document.getElementById("searchType");
		var url ="${pageContext.request.contextPath}/";
		url = url + "?corp_code=" + $('#code').val();
		url = url + "?bgn_de=" + $('#startDate').val();
		url = url + "?end_de=" + $('#endDate').val();
		url = url + "?pblntf_ty=A?pblntf_detail_ty=" + test.options[document.getElementById("searchType").selectedIndex].value;
		location.href = url;
		console.log(url);
	});
		
	
</script>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form:form commandName="searchDTO" action="getList">
				<div class="form-group">
					<form:select path="pblntf_detail_ty" id="searchType" class="form-control form-control-sm">
						<option value="A">전체</option>
						<option value="A001">사업보고서</option>
						<option value="A002">반기보고서</option>
						<option value="A003">분기보고서</option>
					</form:select>
				</div>
				<div class="form-group">
					<label for="InputName">
						기업코드
					</label>
					<form:input path="corp_code" id="corp_code" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="InputDate">
						조회날짜
					</label>
					
					<input type="date" class="form-control" id="dgn_de" name="dgn_de"/> ~ <input type="date" class="form-control" id="end_de" name="end_de" />
				</div>
				<div>
					<input class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit" value="Sign in"> 
				</div>
			</form:form>
		</div>
	</div>
</div>


</body>
</html>


