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

<table id="dataSearchTable">
	<tr>
		<td align="center"><a class="fileSearchPage" style="color:#455A64; " href="file.search?sf_color=455A64">프로젝트</a></td>
		<td align="center"><a class="fileSearchPage" style="color:#4E342E; " href="file.search?sf_color=4E342E">프로그램</a></td>
		<td align="center"><a class="fileSearchPage" style="color:#263238; " href="file.search?sf_color=263238">아무거나</a></td>
	</tr>
</table>

<c:if test="${FilePage != 'FilePage' }">
<form action="file.reg" name="dataForm" onsubmit="return dataCheck();" method="post" enctype="multipart/form-data">
	<table id="dataFileTable">
		<tr>
			<td align="right">
				<input id="dataFileTitleInput" placeholder="파일 이름" name="sf_title" maxlength="20">
			</td>
			<td align="left" >
				<select name="sf_color" id="dataFileSelect">
					<option value="#455A64">프로젝트</option>
					<option value="#4E342E">프로그램</option>
					<option value="#263238">기타</option>
				</select>
			</td>
		</tr>	
		<tr>
			<td align="right">
				<input id="dataFileInput" type="file" name="sf_file">
			</td>
			<td align="left">
				<button id="dataFileButton">올리기</button>
			</td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${FilePage == 'FilePage' }">
<form action="file.update" name="dataUpdateForm" onsubmit="return updateCheck();" method="post" enctype="multipart/form-data">
	<input type="hidden" value="${param.sf_no }" name="sf_no">
	<table id="dataFileUpdateTable">
		<tr>
			<td align="right">
				<input id="dataFileUpdateInput" value="${updateFileTitle }" placeholder="파일 이름" name="sf_title" maxlength="20">
			</td>
			<td align="left" >
				<select name="sf_color" id="dataFileUpdateSelect">
					<option value="#455A64">프로젝트</option>
					<option value="#4E342E">프로그램</option>
					<option value="#263238">아무거나</option>
				</select>
			</td>
		</tr>	
		<tr>
			<td align="right">
				<input id="dataFileUInput" type="file" name="sf_file">
			</td>
			<td align="left">
				<button id="dataFileUpdateButton">수정</button>
			</td>
		</tr>
	</table>
</form>
</c:if>
	<table id="fileDownMainTable">
	<tr>
	<td>
	<c:forEach var="fds" items="${files }">
		<table class="fileDownTable" style="border: ${fds.sf_color} solid 7px;">
			<tr>
				<td class="fileDownIdTd">
					<c:choose>
						<c:when test="${ fds.sf_img == 'kakao.jpg' }">
							<a href="resources/baseImg/${fds.sf_img }" ><img class="fileIdImg" src="resources/baseImg/${fds.sf_img }"></a>
						</c:when>
						<c:otherwise>
							<a href="resources/memberImg/${fds.sf_img }" ><img class="fileIdImg" src="resources/memberImg/${fds.sf_img }"></a>
						</c:otherwise>
					</c:choose>
					${fds.sf_id }
				</td>
				<td align="right" class="fileDownIdTd">
				<c:if test="${sessionScope.loginMember.sm_id == fds.sf_id || sessionScope.loginMember.sm_id == 'koko2921'  }">
					<button class="fileDownButton" onclick="goFileDetail('${fds.sf_no}');">수정</button>
					<button class="fileDownButton" onclick="goFileDelete('${fds.sf_no}');">삭제</button>
				</c:if>
				</td>
			</tr>
			<tr class="fileDownTitleTd" align="center" style="background-color: ${fds.sf_color};">
				<td colspan="2">
					${fds.sf_title }
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="resources/file/${fds.sf_file }" ><img class="fileDownImg"  src="resources/img/down2.png"> </a>
				</td>
			</tr>
		</table>
	
	</c:forEach>
	</td>
	</tr>
	<tr>
	<td>
	<br>
	<br>
	<br>
	

	</td>
	</tr>
	</table>

</body>
</html>