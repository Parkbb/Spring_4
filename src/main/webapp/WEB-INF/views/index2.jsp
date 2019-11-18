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

	<div id="noticeResult">
		
	</div>

<div>
	<select id="sel">
		<option value="Dog">Dog</option>
		<option value="Cat">Cat</option>
		<option value="Bird">Bird</option>
	</select>
	<div id="kind">
		
	</div>
	
</div>
<div>
	<input type="text" id="num">
	<button id="btn">button</button>
</div>

<div id="result"></div>
<script type="text/javascript">
	
	
	
	
		
	
	var xmlhttp;
	if (window.XMLHttpRequest) {
	   // code for modern browsers
	   xmlhttp = new XMLHttpRequest();
	 } else {
	   // code for old IE browsers
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//request 정보
	xmlhttp.open("GET","notice/noticeResult");
	//xmlhttp.open("POST", "./testAjax")
	
	//Get
	xmlhttp.send();
	
	//Post
	//xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	//xmlhttp.send("num="+$("#num").val());
	
	xmlhttp.onreadystatechange=function(){
		if(this.readyState == 4 && this.status == 200){
			
			//document.getElementById("result").innerHTML = this.responseText;
			
			$("#noticeResult").html(this.response)
		}
	};
	
	
	$("#sel").change(function() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
		   xmlhttp = new XMLHttpRequest();
		 } else {
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		 }
		
		//request 정보
		xmlhttp.open("GET","./selectAnimal?sel="+$("#sel").val());
		
		//Get
		xmlhttp.send();
		
		xmlhttp.onreadystatechange=function(){
			if(this.readyState == 4 && this.status == 200){			
			$("#kind").html(this.response)
		}
	}
	});
</script>
</body>
</html>
