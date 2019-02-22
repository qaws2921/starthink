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
<table id="loginOKtable">
	<tr>
		<td id="loginOKreferenceRoomTd" align="left">
			<a id="loginOKreferenceRoom" href="file.go">자료실</a>
			<a id="loginOKreferenceRoom" href="commnunity.go">커뮤니티</a>
		</td >
		<td id="loginOKMemberTd" align="right">
		<c:choose>
			<c:when test="${sessionScope.loginMember.sm_img == 'kakao.jpg' }">
				<a href="resources/baseImg/${sessionScope.loginMember.sm_img }" ><img id="loginOKImg" src="resources/baseImg/${sessionScope.loginMember.sm_img }"></a>
			</c:when>
			<c:otherwise>
				<a href="resources/memberImg/${sessionScope.loginMember.sm_img }" ><img id="loginOKImg" src="resources/memberImg/${sessionScope.loginMember.sm_img }"></a>
			</c:otherwise>
		</c:choose>
			${sessionScope.loginMember.sm_id }(${sessionScope.loginMember.sm_name })
			<button class="loginOKButton" onclick="goLogout();">로그아웃</button>
			<button class="loginOKButton" onclick="goMembership();">회원 정보</button>
		</td>
	</tr>
</table>
</body>
</html>