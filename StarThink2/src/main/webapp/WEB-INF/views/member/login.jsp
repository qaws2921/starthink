<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table id="loginTable">
  	<tr>
  		<td id="loginTd" align="right">
			<form action="member.login" name="loginForm" method="post" onsubmit="return loginCheck();">
	  			<input maxlength="10" class="loginIdPw" value="${cookie.joinId.value }" name="sm_id" placeholder="ID">
	  			<input maxlength="10" class="loginIdPw" name="sm_pw" placeholder="PW" type="password" >
	  			<input type="checkbox" name="sm_auto" >자동로그인
	  			<button class="loginButton">로그인</button>
			</form>
  		</td>
  		<td id="loginJBTd" align="left"> 		
	  		<button class="loginButton" onclick="gojoin();">회원가입</button>
  		</td>
  	</tr>
  </table>
</body>
</html>