<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<c:import url="../layout/bootstrap.jsp" />
<body>
<c:import url="../layout/nav.jsp" />


<div class="container">
  <div class="jumbotron">
    <h1>400 Error Page</h1>
    <p>주소를 찾을 수 없습니다</p>
  </div>
  <p>5초 후 메인페이지로 이동합니다</p>
  <p>여기를 누르시면 바로 이동가능합니다</p>
</div>

<script type="text/javascript">

setInterval(function() {
	
	location.href="/s4/";

}, 5000);
	
</script>
</body>
</html>