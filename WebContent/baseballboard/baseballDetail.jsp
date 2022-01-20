<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
	<h3>baseballDetail.jsp(신수정)</h3>
	<table class="twidth">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<caption>Detail</caption>
		<tbody>
			<tr>
				<th class="left">제목</th>
				<td class="left">${b.bbtitle }</td>
				<th class="left">경기날자</th>
				<td>${b.bbdate }</td>
			</tr>			
			<tr>
				<th class="left">상세내용</th>
				<td colspan="3" id="content">${b.bbcontent }</td>
			</tr>
			<tr>
				<th class="left">첨부</th>
				<td colspan="3" id="addfile">
				<a href="download.do?p=baseball/upload/&f=${b.filesrc }">${b.filesrc }</a>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="baseballEdit.do?b=${b.bbno }">수정</a>
	<a href="baseballDelProc.do?b=${b.bbno }">삭제</a>
	<a href="baseballlist.do">목록</a>

</body>
</html>