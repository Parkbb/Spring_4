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
    <p>�ּҸ� ã�� �� �����ϴ�</p>
  </div>
  <p>5�� �� ������������ �̵��մϴ�</p>
  <p>���⸦ �����ø� �ٷ� �̵������մϴ�</p>
</div>

<script type="text/javascript">

setInterval(function() {
	
	location.href="/s4/";

}, 5000);
	
</script>
</body>
</html>