<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="member.join.reg" name="joinForm" onsubmit="return joinCheck();" method="post" enctype="multipart/form-data">
	<table id="joinTable">
		<tr>
			<td>
				<input id="sm_id" class="joinInput" name="sm_id" maxlength="10" placeholder="ID" style="width: 85%">&nbsp;<span id="joinLoginOK">ID입력</span> <p>
				<input class="joinInput" name="sm_pw" maxlength="10" placeholder="PW/숫자 필수" type="password"><p>
				<input class="joinInput" name="sm_pwn" placeholder="PW 확인" type="password"><p>
				<input class="joinInput" name="sm_name" maxlength="10" placeholder="이름"><p>
				<input id="sm_addr1" readonly="readonly" class="joinInput" name="sm_addr1" maxlength="10" placeholder="우편번호" style="width: 85%">&nbsp;<span id="joinAddrSeach">검색</span><p>
				<input id="sm_addr2" readonly="readonly" class="joinInput" name="sm_addr2" maxlength="20" placeholder="주소"><p>
				<input class="joinInput" name="sm_addr3" maxlength="20" placeholder="상세주소"><p>
				<span id="joinImg">프로필 사진</span><p><input class="joinInput" name="sm_img" type="file" placeholder="프로필사진">
			</td>
		</tr>
		<tr>
			<td align="center">
				<button id="joinButton">가입</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>