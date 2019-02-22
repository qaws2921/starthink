<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/home.css" >
<link rel="stylesheet" href="resources/css/index.css" >
<link rel="stylesheet" href="resources/css/join.css" >
<link rel="stylesheet" href="resources/css/login.css" >
<link rel="stylesheet" href="resources/css/loginOK.css" >
<link rel="stylesheet" href="resources/css/membership.css" >
<link rel="stylesheet" href="resources/css/data.css" >
<link rel="stylesheet" href="resources/css/community.css" >
<script type="text/javascript" src="resources/js/air.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/summonInput.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(function() {
		
		connectSummonEvent();
		connectSummonAddrInputEvent();
		connectIdCheckEvent();
		
		
	
	});
</script>

</head>
<body>

	<c:if test="${sessionScope.loginMember != null}">
	<table id="myPage" onclick="goMyPage('${sessionScope.loginMember.sm_id}');">
		<tr>
			<td>
				내 페이지
			</td>
		</tr>
	</table>
	
	</c:if>	
	<table id="indexMainTable">
		<tr>
			<td colspan="2" id="idexMainLoginTd" align="right"><jsp:include
					page="${loginPage }"></jsp:include></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img onclick="goHome();"
				id="idexMainTitle" src="resources/img/star.png"></td>
		</tr>
		<tr>
			<td style="color: white; padding-left: 55px; font-weight: 900;">
				${w.description }: ${w.temp }ºC(${w.humidity }%)</td>

			<td align="right" style="padding-right: 10px;"><span
				id="city-aqi-container"></span> <script type="text/javascript"
					charset="utf-8">
					_aqiFeed({
						container : "city-aqi-container",
						display : "<span style='%style;font-size:10px;padding:5px 5px;font-weight:800;'>공기 : %aqi</span>",
						city : "seoul",
						lang : "kr"
					});
				</script></td>
		</tr>
		<tr>
			<td colspan="2" style="color: red; font-size: 8pt;" align="right">
				&nbsp;${r }</td>
		</tr>

	</table>
	<img src="https://openweathermap.org/img/w/${w.icon }.png"
		id="weatherImg">
	<table id="indexContentTable">
		<tr>
			<td align="center"><jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>

</body>
</html>