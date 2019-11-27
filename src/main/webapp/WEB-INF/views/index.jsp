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
	Hello world!!! ${dto}
</h1>

<P id="p">  The time on the server is ${serverTime}. </P>

<button id="btn">Get Json1</button>

<button id="btn2">Get Json2</button>

<button id="btn3">클릭</button>

<button id="btn4">Moives</button>
<script type="text/javascript">
	
	
	$("#btn4").click(function() {
		$.ajax({
			type:"GET",
			url: "https://yst.lt/api/v2/list_movies.json",
			/*headers:{
				'User-Agent':'Mozilla/5.0'
			},*/
			//crossOrigin:true,
			dataType:'jsonp',
			data:{
				limit:2
			},
			success:function(data){
				console.log(data.data.movies[0].title);
			}
		});
	})
	
	$("#btn").click(function() {
		$.get("./getJson3",function(dat){
			//dat = dat.trim();
			//dat=JSON.parse(dat);
			//alert(dat.name);
			/*
			for (var i = 0; i < data.length; i++) {
				console.log(data[i].num);
			}
			*/
			
			$.each(dat, function(i, vo) {
				console.log(i);
				console.log(vo.num)
			});
		});
	});
	
	$("#btn2").click(function() {
		$.get("./getJson2?",function(dat){
			alert(typeof dat);
		});
	});
	
	
	$("#btn3").click(function() {
		$.ajax({
			type:"GET",
			url:"https://api.manana.kr/exchange/price.json",
			data:{
				base:"USD",
				price:1,
				code:"KRW"
			},
			success:function(data){
				console.log(data.KRW);
			}
		});
		
		/*
		$.get("https://api.manana.kr/exchange/price/USD/1/KRW,USD,JPY.json", function(data) {
			console.log(data.KRW, data.JPY);
		})
		*/
	})
	
	
	setInterval(function() {
		
		$.get("./time",function(data){
			$("#p").html(data);
		});
	
	}, 1000);
	

</script>
</body>
</html>
