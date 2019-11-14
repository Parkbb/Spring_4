<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../layout/nav.jsp" />

<div class="container">
<h2>${board} Insert Page</h2>
<form  method="post" id="frm" action="${board}Write">
	
	
	<div class="form-group" >
     	 <label for="name">TITLE:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    
    <div class="form-group">
    	  <label for="kor">WRITER:</label>
      	<input type="text" class="form-control" id="writer"  name="writer" value="" placeholder="Enter Writer">
    </div>
    
    <div class="form-group">
    	  <label for="eng">CONTENTS:</label>
    	  <textarea rows="30" cols="50" class="form-control" placeholder="Enter Contents" name="contents"></textarea>
      	
    </div>
    
    
    <input type="button" class="btn btn-default" id="submit" value="submit">
    
</form>
</div>
    <script type="text/javascript">
    $("#submit").click(function() {
		if($("#title").val() ==""){
			alert('내용을 입력하세요');
		}else {
			$('#submit').attr("type", "submit");
		}

	});
    
    
    </script>
</body>
</html>