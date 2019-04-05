<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/teabag/teabag.js"></script>
<script type="text/javascript" src="resources/js/teabag/teabagCalendar.js"></script>
<link rel="stylesheet" href="resources/css/teabag/teabagBBS.css">
<link rel="stylesheet" href="resources/css/teabag/teabagNotice.css">
<link rel="stylesheet" href="resources/css/teabag/teabagDataroom.css">
<link rel="stylesheet" href="resources/css/teabag/teabagCalendar.css">
<link rel="stylesheet" href="resources/css/teabag/teabagMember.css">
<link rel='stylesheet' href='resources/css/teabag/fullcalendar.css' />
<script src='resources/js/teabag/moment.min.js'></script>
<script src='resources/js/teabag/fullcalendar.js'></script>
<script type='text/javascript' src='resources/js/teabag/gcal.js'></script>
<style type="text/css">
	#tb_profileDiv2{
		background-image: url("resources/img/teabag/${sessionScope.teabag.ht_profilepic }");
		background-position: center center;
		background-repeat: no-repeat;
		background-size: auto 100%;
	}
	#tb_bgPic{
		background-image: url("resources/img/teabag/${sessionScope.teabag.ht_bgpic }");
		background-position: center center;
		background-repeat: no-repeat;
		background-size: 100%;
	}
</style>
</head>
<body>

<input type="hidden" id="tb_no1" value="${sessionScope.teabag.ht_no}">
<input type="hidden" id="ht_name" value="${sessionScope.teabag.ht_name }">
<input type="hidden" id="login_sm_id" value="${sessionScope.loginMember.hm_id }">
	<table id="tb_teabagTable">
		<tr id="tb_bgPic">
			<td colspan="3">
			</td>
		</tr>
		<tr class="tb_teabagETC" >
			<td rowspan="2">
			<div id="tb_profileDiv2" class="tb_profileDiv"></div>
			</td>
			<td id="tb_teabagName" class="tb_basicSetting">
				${sessionScope.teabag.ht_name }
				<c:if test="${sessionScope.teabagJoin == 'L' }">
					&nbsp;<a href="site.teabag.set?ht_no=${sessionScope.teabag.ht_no }"><img src="resources/img/teabag/setting.png" style="width: 20px;"></a>
				</c:if> 
			</td>
			<td rowspan="2" valign="middle">
				<c:choose>
					<c:when test="${sessionScope.teabagJoin == 'O' }">
				 		<span class="tb_join_span" onclick="goLeaveTeabag(${sessionScope.teabag.ht_no})">탈퇴하기</span>
					</c:when>
					<c:when test="${sessionScope.teabagJoin == 'R' }">
				 		<span class="tb_join_span">가입대기</span>
					</c:when>
					<c:when test="${sessionScope.teabagJoin == null }">
				 		<a href="site.member.sendjoinReq"><span class="tb_join_span">가입하기</span></a>
					</c:when>
				</c:choose>
				<img id="tb_report_img" src="resources/img/teabag/report.png" onclick="reportClick('${sessionScope.teabag.ht_no}','${sessionScope.loginMember.hm_id }','모임');">
			</td>
		</tr>
		<tr class="tb_teabagETC">
			<td class="tb_basicSetting">
				${sessionScope.teabag.ht_introduce }
			</td>
		</tr>
		<tr>
			<td id="tb_teabagMenu">
				<div id="tb_teabagMenu1" style="margin-left: -10px; padding-top: 80px;">
				<table>
					<tr>
						<td>
							<a href="teabag.sns.go" style="text-decoration: none; font-size: 15px;">
								<img src="resources/img/teabag/sns.png" style="width:55px; border-radius: 10%;">&nbsp;게시글
							</a>
						</td>
					</tr>
					<c:if test="${sessionScope.teabagJoin == 'L' || sessionScope.teabagJoin == 'O'  }">
					<tr>
						<td>
							<a href="teabag.bbs.go" style="text-decoration: none; font-size: 15px;">
								<img src="resources/img/teabag/bbs.png" style="width:55px; padding-top: 20px;">&nbsp;방명록
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="teabag.dr.go" style="text-decoration: none; font-size: 15px;">
								<img src="resources/img/teabag/dataroom.png" style="width:43px; padding-top: 20px;">&nbsp;&nbsp;자료실
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="teabag.member.go" style="text-decoration: none; font-size: 15px;">
								<img src="resources/img/teabag/teabagMember.png" style="width:43px; padding-top: 20px;">&nbsp;&nbsp;회원목록
							</a>
						</td>
					</tr>
					</c:if>
				</table>
				</div>
			</td>
			<td align="center" valign="top">
					<jsp:include page="${teabagContentPage }"></jsp:include>
			</td>
			<td class="calendarMiniTd">
				<div id="noticeSpace">
					<c:if test="${sessionScope.teabagJoin == 'L' }">
						<div onclick="goUpdateNotice()">수정</div>
					</c:if>
					<div id="teabagNotice">&nbsp; ${sessionScope.teabag.ht_notice}</div>
				</div>
				<c:if test="${sessionScope.teabagJoin == 'L' || sessionScope.teabagJoin == 'O'  }">
				<div id="calendarSpace">
				</div>
				<div id="calendarMini">
				</div>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>
