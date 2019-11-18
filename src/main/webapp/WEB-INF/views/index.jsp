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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id="result">
	<input type="text" id="num">
	<button id="btn">click</button>
	
</div>

<script type="text/javascript">
	$("#btn").click(function() {
		var num = $("#num").val();
		//$.get("./getNum?num="+num, function(data) {
		//	$("#result").append(data);
		//});
		$.post("./getNum",{num:num} ,function(data) {
			
		})
	})

</script>
</body>
</html>
