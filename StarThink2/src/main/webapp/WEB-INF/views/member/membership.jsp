<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="membershipTable">
<form action="member.membership.update" name="membershipForm" onsubmit="return membershipUpdateCheck();" method="post" enctype="multipart/form-data">
		<tr>
			<td align="center">
		<c:choose>
			<c:when test="${sessionScope.loginMember.sm_img == 'kakao.jpg' }">
				<a href="resources/baseImg/${sessionScope.loginMember.sm_img }" >
				<img id="membershipImg" src="resources/baseImg/${sessionScope.loginMember.sm_img }">
				</a>
			</c:when>
			<c:otherwise>
				<a href="resources/memberImg/${sessionScope.loginMember.sm_img }" >
				<img id="membershipImg" src="resources/memberImg/${sessionScope.loginMember.sm_img }">
				</a>
			</c:otherwise>
		</c:choose>
			
			</td>
		</tr>
		
		<tr>
			<td>
				<input class="membershipInput" value="${sessionScope.loginMember.sm_id }" readonly="readonly" name="sm_id" maxlength="10" placeholder="ID"><p>
				<input class="membershipInput" value="${sessionScope.loginMember.sm_pw }" name="sm_pw" maxlength="10" placeholder="PW/숫자 필수" type="password"><p>
				<input class="membershipInput" value="${sessionScope.loginMember.sm_pw }" name="sm_pwn" placeholder="PW 확인" type="password"><p>
				<input class="membershipInput" value="${sessionScope.loginMember.sm_name }" name="sm_name" maxlength="10" placeholder="이름"><p>
				<input class="membershipInput" value="${sm_addr1 }" name="sm_addr1" maxlength="10" placeholder="우편번호" style="width: 85%">&nbsp;<span id="joinAddrSeach">검색</span><p>
				<input class="membershipInput" value="${sm_addr2 }" name="sm_addr2" maxlength="20" placeholder="주소"><p>
				<input class="membershipInput" value="${sm_addr3 }" name="sm_addr3" maxlength="20" placeholder="상세주소"><p>
				<span id="membershipImgTitle">프로필 사진</span><p><input class="membershipInput" name="sm_img" type="file" placeholder="프로필사진">
			</td>
		</tr>
		<tr>
			<td align="center">
				<button id="membershipButton">수정</button>  
</form>				
				<button id="membershipButton" onclick="goMemberDelete('${sessionScope.loginMember.sm_id}');">탈퇴</button>
			</td>
		</tr>
	</table>
</body>
</html>