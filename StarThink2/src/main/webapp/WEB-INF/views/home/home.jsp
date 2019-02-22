<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	scrollShow();
</script>
</head>
<body>
<table id="homePagetable">
	<tr>
	<td align="right" class="homePageLRTd">
		<c:if test="${curPage != 1 && curPage != null  }">
		<span class="homePageLR" onclick="goSNSPage('${curPage-1}')">◀</span>	
		</c:if>
	</td>
	<td align="center" id="homeSearchTd">
		<form action="sns.show.search" name="searchForm" onsubmit="return searchCheck();">
			<select name="what" id="homeSearchSelect">
				<option value="st_id">ID</option>
				<option value="st_txt" >내용</option>
			</select>
			<input id="homeSearchInput" name="st_content">
			<button id="homeSearchButton">검색</button>
		</form>
	
	</td>
	<td align="left" class="homePageLRTd">
		<c:if test="${curPage != pageCount && pageCount != 0 }">
		<span class="homePageLR" onclick="goSNSPage('${curPage+1}')">▶</span>	
		</c:if>	
	</td>
	</tr>
		<tr>
		<td align="center" colspan="3">
		 	<c:forEach var="i" begin="1" end="${pageCount }">
		 		<a href="sns.show.paging?pageNo=${i }" class="homePageNo"  >
		 		 <c:choose>
		 		 	<c:when test="${curPage == i }" ><span style="color: red;">${i }</span> </c:when>
		 		 	<c:otherwise>${i }</c:otherwise>
		 		 </c:choose>
		 		</a>
		 	</c:forEach>
		</td>
	</tr>
	</table>
	<c:if test="${sessionScope.loginMember != null && snsUpdate == null}">
	
		<form action="sns.reg" name="txtForm"
			onsubmit="return txtCheck();" method="post" enctype="multipart/form-data">
			<input type="hidden" value="${sessionScope.loginMember.sm_id }" name="st_id">
			<input type="hidden" value="${sessionScope.loginMember.sm_img }" name="st_img">
			<table id="homeTxtTable">
				<tr>
					<td align="center" colspan="2">
						<img id="snsRegSummonImg" src="resources/img/A.png" style="cursor: pointer;">
					</td>
				</tr>
				<tr>
					<td id="homeTxtTd" align="center"><textarea maxlength="300"
							name="st_txt" id="homeTxtarea"></textarea></td>
					<td id="homeTxtButtonTd" align="center" rowspan="2">
						<button id="homeTxtButton">쓰기</button>
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" id="homeFile"  name="st_photo">
					</td>
				</tr>
				
			</table>
		</form>
	</c:if>
	<c:if test="${snsUpdate == 'snsUpdate'}">
		<form action="sns.update"  name="txtForm" onsubmit="return txtCheck();" method="post" enctype="multipart/form-data">
		<input type="hidden" name="st_no" value="${param.st_no }">
		<input type="hidden" name="pageNo" value="${param.pageNo }">
			<table id="homeUpdateTable">
				<tr>
					<td id="homeUpdateTd" align="center">
						<textarea maxlength="300" name="st_txt" id="homeUpdateTxtarea" >${st_txt }</textarea>
					</td>
					<td id="homeTxtButtonTd" align="center" rowspan="2">
						<button id="homeUpdateButton">수정</button>
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" id="homeUpdateFile"  name="st_photo">
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	<input type="hidden" id="login_sm_id" value="${sessionScope.loginMember.sm_id }">
	<input type="hidden" id="login_sm_img" value="${sessionScope.loginMember.sm_img }">
	<table style="width: 100%;">
		<tr>
			<td id="homeSNSAllTd" align="center">
				
			</td>
		</tr>
	</table>

<br>
<br>
<br>
<br>
<br>
<br>

</body>
</html>