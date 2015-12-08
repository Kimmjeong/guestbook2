<%@page import="com.hanains.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String no=request.getParameter("no");
	GuestBookDao dao=new GuestBookDao();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<script type="text/javascript">
	
	function deleteOk(){
		
		var password=document.frm.password.value;
		var ispassword=<%=dao.isPassword(Long.parseLong(no))%>;
		
		if(ispassword==password){
			alert("삭제되었습니다.");
		}
		else{
			alert("비밀번호가 일치하지 않습니다.");
			document.frm.password.focus();
			return false;
		}
			
		return true;
	}
	
</script>
</head>
<body>
	<form action="/guestbook2/gb" method="post" name="frm">
	<input type="hidden" name="a" value="delete">
	
	<input type='hidden' name="no" value="<%=no%>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="password"></td>
			<td><input type="submit" value="확인" onclick="return deleteOk()"></td>
			<td><a href="/guestbook2/gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>