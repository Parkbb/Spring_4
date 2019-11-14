<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootstrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
<div class="container">
<h2>Point Update Page</h2>
<form action="noticeUpdate.notice" method="post">
	<div class="form-group" hidden="">
     	 <label for="name">num:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="num" value="${dto.num}">
    </div>
	
	<div class="form-group">
     	 <label for="name">TITLE:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value="${dto.title}">
    </div>
    
    <div class="form-group">
    	  <label for="kor">WRITER:</label>
      	<input type="text" class="form-control" id="writer" placeholder="Enter Your Name" name="writer" value="${dto.writer}" readonly="readonly">
    </div>
    
    <div class="form-group">
    	  <label for="eng">CONTENTS:</label>
    	  <textarea rows="30" cols="50" class="form-control" placeholder="Enter Contents" name="contents">${dto.contents}</textarea>
      	
    </div>
    
    
    <button type="submit" class="btn btn-primary" style="float: right;">Submit</button>
    <a href ="noticeSelect.notice?num=${dto.num}"><button type="button" class="btn btn-default" style="float: right;">Cancel</button></a>
</form>
</div>
</body>
</html>