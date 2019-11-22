<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<c:import url="./layout/bootstrap.jsp"></c:import>
</head>

<body>
<c:import url="./layout/nav.jsp"></c:import>
<c:import url="./layout/summernote.jsp"></c:import>
<h1>
	Hello world! ${dto}
</h1>

<P id="p">  The time on the server is ${serverTime}. </P>

<div id="editor"></div>

<script type="text/javascript">

	$("#editor").summernote();
	
	setInterval(function() {
		
		$.get("./time",function(data){
			$("p").html(data);
		});
	
	}, 1000);
	

</script>
</body>
</html>
