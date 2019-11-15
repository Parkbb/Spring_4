<%@page import="javax.servlet.jsp.tagext.TagLibraryInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootstrap.jsp"></c:import>
</head>
<body>
	<div class="container">
		<h2>${result}</h2>
  		<form class="form-inline" action="memberIdCheck">
  		  <div class="form-group">
    		  <label for="email">ID:</label>
   		   <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" value="${param.id}">
   		 </div>
  	  <button type="submit" class="btn btn-default">Submit</button>
  	 <c:if test="${empty dto}">
  	  <input type="button" id = "useId" value="사용하기" class="btn btn-primary">
  	 </c:if>
 		
 		 </form>
</div>

<script type="text/javascript">

$("#useId").click(function() {
	
	window.opener.$("#id").val($("#id").val())
	//$("#id",opener.document).val($("#id").val())
	window.close();
	
});

</script>
</body>
</html>