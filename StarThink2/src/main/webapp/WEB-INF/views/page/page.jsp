<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		followingCheck();
		follower();
		followerCheck();
		followClick();
	});
</script>
</head>
<body>
		<table>
		<tr>
			<td colspan="2" align="center">
				<c:choose>
					<c:when test="${m.sm_img == kakao.jpg}">
						<img style="max-width: 200px; max-height: 200px;" src="resources/baseImg/${m.sm_img }"><br> ${m.sm_id }
					</c:when>
					<c:otherwise>
						<img style="max-width: 200px; max-height: 200px;" src="resources/memberImg/${m.sm_img }"><br> ${m.sm_id }					
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td style="border: black solid 2px;">
				<input type="hidden" id="sm_id" class="sm_id" value="${sessionScope.loginMember.sm_id }">
				<input type="hidden" id="f_sm_id" class="f_sm_id" value="${m.sm_id }">
				<span id="following"></span>
			</td>
			
			<td style="border: black solid 2px; cursor: pointer;"class="followerTd" >
				<span id="follower" ></span>
			</td>
		</tr>
	</table>
	<hr>
</body>
</html>