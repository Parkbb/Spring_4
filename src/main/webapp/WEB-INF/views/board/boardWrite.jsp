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
<h2>${board} Insert Page111</h2>
<form class="form-horizontal" action="${board}Write" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">TITLE</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">WRITER</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" name="writer" value="">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">CONTENTS</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="contents" name="contents"></textarea>
				</div>
			</div>
		<div id = "files">
			<div class="form-group" >
				<label class="control-label col-sm-2" for="title">FILES</label>
				<div class="col-sm-9">
				<input type="file" class="form-control" id="file" name="file">
				</div>
				<div class="col-sm-1">
				<input type="button" class="form-control btn btn-danger del_file" value="DEL">
				</div>
			</div>
		</div>
		
			<input type="button" class="btn btn-primary" value="ADD FILE" id="add_file">
		<!--**********************버튼그룹 -->
		<button type="submit" class="btn btn-info" id="btn_right">작성</button>
		</form>

	
	</div>
<script type="text/javascript">
	var files = $("#files").html();
	var number = 0;
	
	$("#files").empty()
	
	$("#add_file").click(function() {
			if (number < 5) {
			$("#files").append(files);
				number++;
			}else{
				alert("파일은 최대 5개까지 첨부가능합니다");
			}
		
	});
	
	$("#files").on('click' ,".del_file" ,function() {
			//$(this).parents(".form-group").remove();
			$(this).closest(".form-group").remove();
			number--;
	});
	
	</script>
</body>
</html>