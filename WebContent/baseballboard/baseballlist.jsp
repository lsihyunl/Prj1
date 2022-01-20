<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<link href="../css/skins/blue.css" rel="stylesheet">
<link href="../css/custom.css" rel="stylesheet">
</head>
<h3>main page(신수정)</h3>
<script>
	function clearVal() {
		var inputVal = document.getElementById("stx");
		inputVal.value = '';
	}
</script>
<body>



	<div class="main col-md-9 col-md-offset-1"
		style="width: 80%; margin: auto;">
		<h1 class="page-title nsb">
			대회일정<span class="sound_only"> 목록</span>
		</h1>
		
		<c:if test="${empty sessionScope.uid }">
			<a href="../login/login.do">login</a> 
	 | 
</c:if>
		<c:if test="${not empty sessionScope.uid }">
	${uid }님 환영합니다.
	|
	<a href="../logout/logoutProc.do">logout</a>
		</c:if>
<hr>
		<%-- <div id="bo_list" style="width: 100%">
			<div class="bo_fx">
				<div id="bo_list_total">
					<span>Total ${bbno }건</span>
				</div>
			</div>  --%>

			<div class="tbl_head01 tbl_wrap">
				<table>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">대회명</th>
							<th scope="col">기간</th>
							<th scope="col">일수</th>
							<th scope="col">장소</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<c:forEach var="b" items="${list }">
						<tbody>
							<tr class="">
								<td class="td_num">${b.bbno }</td>
								<td class="td_subject"><a
									href="baseballDetail.do?b=${b.bbno }&h=${b.bbhit}">${b.bbtitle }</a></td>
								<td class="td_date">${b.bbdate }</td>
								<td class="td_date">${b.bbday }</td>
								<td class="td_num" style="width: 12%;">${b.bbplace }</td>
								<td class="td_date">${b.bbhit }</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
			<a href="baseballReg.do">새글쓰기</a>
			<form action="baseballlist.do" method="get">
			<select name="f">
				<option ${param.f=="bbtitle"?"selected":"" } value="bbtitle">제목</option>
				<option ${param.f=="bbcontent"?"selected":"" } value="bbcontent">내용</option>
			</select> <input type="text" name="q" value="${query }" /> <input
				type="submit" value="검색 " />
		</form>


		</div>
</body>
</html>