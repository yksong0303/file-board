<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="common/header.jsp"></jsp:include>
</head>
<body>
<h2>사진 게시판</h2>
<jsp:include page="common/head.jsp"></jsp:include>
<table class="table table-striped">

  <thead>
    <tr>
      <th data-col="pbNum">번호</th>
      <th data-col="pbTitle">제목</th>
      <th data-col="pbContent">내용</th>
      <th data-col="col">파일이름</th>
      <th data-col="credat">작성시간</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="pb" items="${pbList}">
    <tr>
      <td>${pb.pbNum}</td>
      <td>${pb.pbTitle}</td>
      <td>${pb.pbContent }</td>
      <td>${pb.pbPhotoName }</td>
      <td><img src="/resources/${pb.pbPhotoPath}" width="50px"></td>
      <td>${pb.credat}</td>
    </tr>
    </c:forEach> 
   
  </tbody>
  
</table>
<!-- ${page} -->
◀<c:forEach begin="${page.startBlock}" end="${page.endBlock}" var="idx">
<a href="/photo/list?page.pageNum=${idx }">[${idx}]</a>
</c:forEach>
<a href="/photo/list?page.pageNum=${page.pageNum+1}">▶</a><br>


<a href="/photo/write"><button type="button" class="btn btn-primary">글쓰기</button></a>
</body>
</html>