<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/nstyle.css" />
<link href="../css/style.css" rel="stylesheet">
<link href="../css/skins/blue.css" rel="stylesheet">
<link href="../css/custom.css" rel="stylesheet">
<link rel="stylesheet" href="../css/basic/style.css">
</head>
<body>
<h3>baseballReg.jsp(신수정)</h3>
<form action="baseballRegProc.do" method="post" enctype="multipart/form-data"> 
		<table class="twidth">
   <colgroup>
      <col width="15%" />
      <col width="35%" />
      <col width="15%" />
      <col width="35%" />   
   </colgroup>
   <caption>Write</caption>
   <tbody>      
      <tr>
         <th class="left">대회명</th>
         <td colspan="3">
         <input class="inp" name="bbtitle" />
         </td>
      </tr>
      <tr>
       <th class="left">경기기간</th>
         <td colspan="3">
         <input class="inp" name="bbdate" />
         </td>
      </tr>
      <tr>
       <th class="left">경기일수</th>
         <td colspan="3">
         <input class="inp" name="bbday" />
         </td>
      </tr>
      <tr>
       <th class="left">장소</th>
         <td colspan="3">
         <input class="inp" name="bbplace" />
         </td>
      </tr>
      <tr>
       <th class="left">경기상세내용</th>
         <td colspan="3" id="content">
         <textarea class="txt" name="bbcontent" /></textarea>
         </td>
      </tr>
      <tr>
         <th class="left">첨부</th>
         <td colspan="3" id="addfile">
            <input type="file" name="file" size="50" class="inp" />
         </td>
      </tr>
</tbody>
</table>
	<input type="hidden" value="save"/>
		<input type="submit" value="저장" class="btn btn-primary btn-sm" style="margin: auto;"/>
	<input type="button" value="취소" class="btn btn-primary btn-sm" style="margin: auto;" 
	onclick="location.href='baseballlist.do'"/>
</form>
</body>
</html>