<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
 <table id="teabagDataroom">
 	<tr>
 		<td id="tb_photoPick" align="center">
 			사진
 		</td>
 		<td id="tb_filePick" align="center">
 			파일
 		</td>
 	</tr>
 	<tr>
 		<td colspan="2" align="center">
 			<form action="teabag.dr.write" method="post" name="tb_dataroom" enctype="multipart/form-data" onsubmit="return writeDataroomCheck();">
	 			<table id="tb_dr_inputTable">
	 				<tr>
	 					<td>
	 						<input placeholder="제목" name="hd_title" id="tb_dr_title" autocomplete="off" autofocus="autofocus">
	 						<input type="hidden" id="teabagJoin" value="${sessionScope.teabagJoin }">
	 						<input type="hidden" id="teabagMyId" value="${sessionScope.loginMember.hm_id }">
	 					</td>
	 					<td rowspan="2">
	 						<button id="tb_dr_inputButton">등록</button>
	 					</td>
	 				</tr>
	 				<tr>
	 					<td>
	 						<div class="yw_wrap">
		 						<input type="text"  id="yw_file_route" class="yw_file_route" readonly="readonly"/>
		 						<span class="yw_file_wrap">
		 							<input type="file" id="tb_dr_file_input" class="tb_dr_file_input" name="tb_photo"  onchange="javascript:document.getElementById('yw_file_route').value=this.value">
		 						</span>
	 						</div>
	 					</td>
	 				</tr>
	 			</table>
 			</form>
 		</td>
 	</tr>
	<tr>
		<td align="center" colspan="2" id="tb_filedPageTd">

		</td>
	</tr>
	<tr>
		<td colspan="2" id="tb_filesTd">
		</td>
	</tr>
 </table>
</body>
</html>