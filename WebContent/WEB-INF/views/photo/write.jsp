<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common/header.jsp"></jsp:include>
</head>
<body>
<jsp:include page="common/head.jsp"></jsp:include>
<form method="POST" action="/photo/write" enctype="multipart/form-data">
	제목 : <input type="text" name="pbTitle"><br>
	내용 : <textarea name="pbContent"></textarea><br>
	사진 : <input type="file" name="pbfile"><br>
	<button class="btn btn-primary">작성하기</button>
	<button type="button" onclick="goList()" class="btn btn-primary">돌아가기</button>
</form>
<script>
function goList(){
	location.href = 'list';
}
</script>
</body>
</html>