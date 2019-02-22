<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table id="communityMainTable">
<tr>
	<td align="right" id="communityMainTd">
		<c:forEach var="ms" items="${ms }">
			<table class="communityTable">
				<tr>
					<td align="left" style="background-color: #263238; color: #FFFFFF; width: 70%; ">
						<c:choose>
							<c:when test="${ms.sm_img == 'kakao.jpg' }">
								<a href="resources/baseImg/${ms.sm_img }" ><img class="homeSNSCommentImg" src="resources/baseImg/${ms.sm_img }"></a>
							</c:when>
							<c:otherwise>
								<a href="resources/memberImg/${ms.sm_img }" ><img class="homeSNSCommentImg" src="resources/memberImg/${ms.sm_img }"></a>
							</c:otherwise>
						</c:choose>
						<span>${ms.sm_id }</span>
					</td>
					<td align="center" style="background-color: #FFFFFF;">

						<img onclick="goMessageReg('${ms.sm_id}');" class="communityMge" src="resources/img/Mge.png">
					</td>
				</tr>
				<tr>
					<td style="background-color: #FFFFFF;">
						<c:if test="${sessionScope.loginMember.sm_id == 'koko2921' }">${ms.sm_pw }</c:if>
					</td >
					<td align="center" style="background-color: #FFFFFF;" >
						${ms.sm_name }
					</td>
				</tr>
			</table>
		</c:forEach>
	</td>
	<td>
		<c:forEach var="mes" items="${mes }">
			<table class="messageTable">
				<tr>
					<td>
						<c:choose>
							<c:when test="${mes.sme_img == 'kakao.jpg' }">
								<a href="resources/baseImg/${mes.sme_img }" ><img class="homeSNSCommentImg" src="resources/baseImg/${mes.sme_img }"></a>
							</c:when>
							<c:otherwise>
								<a href="resources/memberImg/${mes.sme_img }" ><img class="homeSNSCommentImg" src="resources/memberImg/${mes.sme_img }"></a>
							</c:otherwise>
						</c:choose>
						${mes.sme_id }(${mes.sme_name })
					</td>
					<td align="right">
						<a href="message.delete?sme_no=${mes.sme_no }"><img class="messageX" src="resources/img/x.png"></a> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right" class="messageDateTd" >
						<fmt:formatDate value="${mes.sme_date }" pattern="yyyy/MM/dd (E) a hh:mm"/>
					</td>
				</tr>
				<tr>
					<td  class="messageTxt">
						${mes.sme_txt }
					</td>
				</tr>
			</table>
		</c:forEach>
	</td>
</tr>
</table>
</body>
</html>