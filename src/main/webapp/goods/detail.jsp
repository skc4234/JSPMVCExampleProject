<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 30px
}
.row {
	margin: 0px auto;
	width: 960px;
}
p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
<div class="container">
	<div class="row text-center">
		<table class="table">
			<tr>
				<td colspan="4"><img src="${vo.goods_poster }" style="height: 400px"></td>
			</tr>
			<tr>
				<th width="10%" class="info text-center">상품명</th>
				<td width="50%" class="text-center">${vo.goods_name }</td>
				<th width="10%" class="info text-center">조회수</th>
				<td width="30%" class="text-center">${vo.hit }</td>
			</tr>
			<tr>
				<th width="10%" class="info text-center">가격</th>
				<td width="50%">${vo.goods_price }</td>
				<th width="10%" class="info text-center">배송비</th>
				<td width="30%">${vo.goods_delivery }</td>
			</tr>
			<tr style="height: 100px">
				<td colspan="4" class="text-left">${vo.goods_sub }</td>
			</tr>
			<tr>
				<td colspan="4" class="text-right">
<%-- 					<a href="list.do?tno=${tno }&page=${page}" class="btn btn-sm btn-success">목록</a> --%>
					<a href="javascript:history.back()" class="btn btn-sm btn-success">목록</a>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>