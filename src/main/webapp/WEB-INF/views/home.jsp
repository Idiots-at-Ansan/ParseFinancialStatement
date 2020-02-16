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
			<select class="form-control form-control-sm" name="searchType" id="searchType">
				<option value="A001">사업보고서</option>
				<option value="A002">반기보고서</option>
				<option value="A003">분기보고서</option>
			</select>

				<div class="form-group">
					<label for="InputName">
						기업코드
					</label>
					<input type="text" class="form-control" id="code" name="code" value="test"/>
				</div>
				<div class="form-group">
					<label for="InputDate">
						조회날짜
					</label>
					<input type="date" class="form-control" id="startDate" name="startDate"/> ~ <input type="date" class="form-control" id="endDate" name="endDate" />
				</div>
				<div>
					<button class="btn btn-sm btn-primary" name="getList" id="getList">조회</button>
				</div>
			<form role="form">
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


