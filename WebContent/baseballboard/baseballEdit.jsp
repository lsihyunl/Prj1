<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<link href="../css/skins/blue.css" rel="stylesheet">
<link href="../css/custom.css" rel="stylesheet">
<link rel="stylesheet" href="../css/basic/style.css">
<link rel="stylesheet" href="../css/nstyle.css" />
</head>
<body>
<h3>baseballEdit.jsp(신수정)</h3>
	<form action="baseballEditProc.do" method="post" ><!-- enctype="multipart/form-data" -->
		<table class="twidth">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<caption>글 수정 페이지</caption>
			<tbody>
				<tr>
					<th class="left">대회명
					<td colspan="3"><input type="text" class="inp" name="bbtitle"
						value="${b.bbtitle }" /></td>
				</tr>
				<tr>
					<th class="left">경기날자</th>
					<td colspan="3"><input type="text" class="inp" name="bbdate"
						value="${b.bbdate }" /></td>
				</tr>
				<tr>
					<th class="left">상세내용</th>
					<td colspan="3" id="content"><textarea name="bbcontent"
							class="txt">${b.bbcontent }</textarea></td>
				</tr>
				<tr>
					<th class="left">첨부</th>
					<td><input type="file" name="file" size="50" class="inp"
						value="${b.filesrc }" /></td>
				</tr>
			</tbody>
		</table>
		<div id="bo_v_bot">
			<ul class="bo_v_nb">
				<li>
				<input type="hidden" name="b" value="${b.bbno }"/>
				<input type="submit" value="저장" class="btn_b01" />
				</li>
			</ul>
			<ul class="bo_v_nb">
				<li><a href="baseballDetail.do?b=${b.bbno }"
					class="btn_b01">취소</a></li>
			</ul>
			<ul class="bo_v_com">
				<li><a href="baseballlist.do"
					class="btn_b01">목록</a></li>
			</ul>
		</div>
	</form>

</body>
</html>