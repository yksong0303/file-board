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
<div class="search">
	<form action="/photo/list">
	제목 : <input type="text" name="pbTitle" value="${param.pbTitle }"><br>
	내용 : <input type="text" name="pbContent" value="${param.pbContent }"><br>
	일자 : <input type="date" name="Credat1" value="${param.pbCredat1 }">-<input type="date" name="Credat2" value="${param.pbCredat2 }"><br><!-- 범위 -->
	<input type="hidden" name="page.pageNum" value="1">
	<button>검색</button>
	</form>
</div>


<form method="post" action="/photo/delete">
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
      <th data-col="view">조회수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="pb" items="${pbList}">
    <tr>
    	<td><input type="checkbox" id="pbNumCheck" value="${pb.pbNum}"></td>
      <td>${pb.pbNum}</td>
      <td><a href="update">${pb.pbTitle}</a></td>
      <td>${pb.pbContent }</td>
      <td>${pb.pbPhotoName }</td>
      <td><img src="/resources/${pb.pbPhotoPath}" width="50px"></td>
      <td>${pb.credat}</td>
      <td>${pb.viewCnt}</td>
    </tr>
    </c:forEach> 
   
  </tbody>
  
</table>
<!-- ${page} -->
<button>삭제</button><br>
</form>
<nav aria-label="Page navigation example">
  <ul class="pagination">

 <li class="page-item"><a class="page-link"  href="/photo/list?page.pageNum=${page.pageNum-1}&pbTitle=${param.pbTitle}&pbContent=${param.pbContent}&credat1=${param.credat1}&credat2=${param.credat2}">◀</a></li>
<c:forEach begin="${page.startBlock}" end="${page.endBlock+1}" var="idx">
 <li class="page-item active" aria-current="page"><a class="page-link" href="/photo/list?page.pageNum=${idx }&pbTitle=${param.pbTitle}&pbContent=${param.pbContent}&credat1=${param.credat1}&credat2=${param.credat2}">[${idx}]<span class="sr-only">${page.pageNum}</span></a></li>
</c:forEach>
 <li class="page-item"><a class="page-link" href="/photo/list?page.pageNum=${page.pageNum+1}&pbTitle=${param.pbTitle}&pbContent=${param.pbContent}&credat1=${param.credat1}&credat2=${param.credat2}">▶</a></li>
  </ul>
</nav>
<br>
<a href="/photo/write"><button type="button" class="btn btn-primary">글쓰기</button></a>
<button type="button" onclick="doUpdate()" class="btn btn-primary">수정하기</button>
</body>
<script>

function allCheck(obj){
	var chkObjs = document.querySelectorAll('input[name=pbNums]')
	for(var i=0;i<chkObjs.length;i++){
		chkObjs[i].checked = obj.checked;	
	}
}
function doUpdate(){
	alert($('#pbNumCheck').val());
	
}
</script>
</html>