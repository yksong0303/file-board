<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="common/header.jsp"></jsp:include>
</head>
<body>
<h2>수정 페이지</h2>
<jsp:include page="common/head.jsp"></jsp:include>
<table class="table table-striped">

  <thead>
    <tr>
   
      <th><input type="checkbox" onchange="allCheck(this)" id="allChk"></th>
       <th data-col="pbNum">번호</th>
      <th data-col="pbTitle">제목</th>
      <th data-col="pbContent">내용</th>
      <th data-col="col">파일이름</th>
      <th data-col="imgName">이미지 이름</th>
      <th data-col="credat">작성시간</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="pb" items="${select}">
    <tr>
    	<td><input type="checkbox" id="pbNumCheck" value="${pb.pbNum}"></td>
      <td>${pb.pbNum}</td>
      <td><a href="photo/update">${pb.pbTitle}</a></td>
      <td>${pb.pbContent }</td>
      <td>${pb.pbPhotoName }</td>
      <td><img src="/resources/${pb.pbPhotoPath}" width="50px"></td>
      <td>${pb.credat}</td>
    </tr>
    </c:forEach> 
   
  </tbody>
  
</table>
<a href="/photo/list"><button type="button" class="btn btn-primary">돌아가기</button></a>
</body>
</html>