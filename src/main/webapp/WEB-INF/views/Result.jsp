<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<h2>${board}</h2>
		
		<table class="table">
			<thead>
				<tr>
					<th class="col-lg-1" style="text-align: center;">NUM</th>
					<th class="col-lg-4" style="text-align: center;">TITLE</th>
					<th class="col-lg-1" style="text-align: center;">WRITER</th>
					<th class="col-lg-1" style="text-align: center;">DATE</th>
					<th class="col-lg-1" style="text-align: center;">HIT</th>
				</tr>

			</thead>
			<tbody>

				<c:forEach items="${list}" var="dto" begin="1" end="5">
					<tr>
						<td style="text-align: center;">${dto.num}</td>
						<td style="text-align: left;">
						<c:catch>
							<c:forEach begin="1" end="${dto.depth}">&nbsp;&nbsp;ㄴ</c:forEach>
						</c:catch>
						<a href="${board}/${board}Select?num=${dto.num}">${dto.title}</a></td>
						<td style="text-align: center;">${dto.writer}</td>
						<td style="text-align: center;">${dto.reg_date}</td>
						<td style="text-align: center;">${dto.hit}</td>
					</tr>
				</c:forEach>



			</tbody>
</table>
</div>