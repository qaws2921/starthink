function joinCheck() {
	var idBox = document.joinForm.sm_id;
	var pwBox = document.joinForm.sm_pw;
	var pwnBox = document.joinForm.sm_pwn;
	var nameBox = document.joinForm.sm_name;
	var imgBox = document.joinForm.sm_img;
	var addr1Box = document.joinForm.sm_addr1;
	var addr2Box = document.joinForm.sm_addr2;
	var addr3Box = document.joinForm.sm_addr3;
	if (isEmpty(idBox) || lessThan(idBox, 2) || containsHS(idBox) || $("#joinLoginOK").css("color") == "rgb(255, 0, 0)") {
		alert("ID 확인");		
		idBox.value = "";
		idBox.focus();
		$("#joinLoginOK").css("color","#263238").text("ID입력");
		return false;
	} else if (isEmpty(pwBox) || lessThan(pwBox, 2) || containsHS(pwBox)
			|| notContains(pwBox, "1234567890")) {
		alert("pw 확인");
		pwBox.value = "";
		pwBox.focus();
		return false;
	} else if (isEmpty(pwnBox) || notEquals(pwBox, pwnBox)) {
		alert("pw확인 확인");
		pwnBox.value = "";
		pwnBox.focus();
		return false;
	} else if (isEmpty(nameBox)) {
		alert("이름 확인");
		nameBox.value = "";
		nameBox.focus();
		return false;
	} else if (isEmpty(addr1Box) || isNotNumber(addr1Box)) {
		alert("우편번호 확인");
		addr1Box.value = "";
		addr1Box.focus();
		return false;
	} else if (isEmpty(addr2Box)) {
		alert("주소 확인");
		addr2Box.value = "";
		addr2Box.focus();
		return false;
	} else if (isEmpty(addr3Box)) {
		alert("상제주소 확인");
		addr3Box.value = "";
		addr3Box.focus();
		return false;
	} else if (isEmpty(imgBox)) {

		if (confirm("사진 없이 등록할꺼?")) {
			return true;
		}

		return false;
	} else if ((isNotType(imgBox, "png") && isNotType(imgBox, "gif")
			&& isNotType(imgBox, "bmp") && isNotType(imgBox, "jpg") && isNotType(
			imgBox, "jpeg"))) {
		alert("사진 확인");
		imgBox.value = "";
		imgBox.focus();
		return false;
	}
	return true;
}
function membershipUpdateCheck() {
	var idBox = document.membershipForm.sm_id;
	var pwBox = document.membershipForm.sm_pw;
	var pwnBox = document.membershipForm.sm_pwn;
	var nameBox = document.membershipForm.sm_name;
	var imgBox = document.membershipForm.sm_img;
	var addr1Box = document.membershipForm.sm_addr1;
	var addr2Box = document.membershipForm.sm_addr2;
	var addr3Box = document.membershipForm.sm_addr3;
	if (isEmpty(idBox) || lessThan(idBox, 2) || containsHS(idBox)) {
		alert("ID 확인");
		idBox.value = "";
		idBox.focus();
		return false;
	} else if (isEmpty(pwBox) || lessThan(pwBox, 2) || containsHS(pwBox)
			|| notContains(pwBox, "1234567890")) {
		alert("pw 확인");
		pwBox.value = "";
		pwBox.focus();
		return false;
	} else if (isEmpty(pwnBox) || notEquals(pwBox, pwnBox)) {
		alert("pw확인 확인");
		pwnBox.value = "";
		pwnBox.focus();
		return false;
	} else if (isEmpty(nameBox)) {
		alert("이름 확인");
		nameBox.value = "";
		nameBox.focus();
		return false;
	} else if (isEmpty(addr1Box) || isNotNumber(addr1Box)) {
		alert("우편번호 확인");
		addr1Box.value = "";
		addr1Box.focus();
		return false;
	} else if (isEmpty(addr2Box)) {
		alert("주소 확인");
		addr2Box.value = "";
		addr2Box.focus();
		return false;
	} else if (isEmpty(addr3Box)) {
		alert("상제주소 확인");
		addr3Box.value = "";
		addr3Box.focus();
		return false;
	} else if (isEmpty(imgBox)) {

		if (confirm("사진 없이 등록할꺼?")) {
			return true;
		}

		return false;
	} else if ((isNotType(imgBox, "png") && isNotType(imgBox, "gif")
			&& isNotType(imgBox, "bmp") && isNotType(imgBox, "jpg") && isNotType(
			imgBox, "jpeg"))) {
		alert("사진 확인");
		imgBox.value = "";
		imgBox.focus();
		return false;
	}
	return true;
}

function loginCheck() {
	var idBox = document.loginForm.sm_id;
	var pwBox = document.loginForm.sm_pw;

	if (isEmpty(idBox) || containsHS(idBox)) {
		alert("ID Ȯ��");
		idBox.value = "";
		idBox.focus();
		return false;
	} else if (isEmpty(pwBox) || containsHS(pwBox)) {
		alert("pw Ȯ��");
		pwBox.value = "";
		pwBox.focus();
		return false;
	}

	return true;
}
function txtCheck() {
	var txtBox = document.txtForm.st_txt;
	var pBox = document.txtForm.st_photo;

	if (isEmpty(txtBox)) {
		alert("내용을 쓰시오");
		txtBox.value = "";
		txtBox.focus();
		return false;
	} else if (isEmpty(pBox)) {

		return true;

	} else if ((isNotType(pBox, "png") && isNotType(pBox, "gif")
			&& isNotType(pBox, "bmp") && isNotType(pBox, "jpg") && isNotType(
			pBox, "jpeg"))) {
		alert("사진 확인");
		pBox.value = "";
		pBox.focus();
		return false;
	}

	return true;
}
function searchCheck() {
	var cBox = document.searchForm.st_content;

	if (isEmpty(cBox)) {
		alert("내용을 쓰시오");
		cBox.value = "";
		cBox.focus();
		return false;
	}

	return true;
}
function dataCheck() {
	var titleBox = document.dataForm.sf_title;
	var fileBox = document.dataForm.sf_file;

	if (isEmpty(titleBox)) {
		alert("제목 확인");
		titleBox.value = "";
		titleBox.focus();
		return false;
	} else if (isEmpty(fileBox)) {
		alert("파일 확인");
		fileBox.value = "";
		fileBox.focus();
		return false;
	}

	return true;
}
function updateCheck() {
	var titleBox = document.dataUpdateForm.sf_title;
	var fileBox = document.dataUpdateForm.sf_file;

	if (isEmpty(titleBox)) {
		alert("제목 확인");
		titleBox.value = "";
		titleBox.focus();
		return false;
	}

	return true;
}

function commentCheck(sss) {
	var tBox = sss.sc_txt;

	if (isEmpty(tBox)) {
		alert("������ ������");
		tBox.value = "";
		tBox.focus();
		return false;
	}

	return true;
}

function connectIdCheckEvent() {
	$("#sm_id").keyup(function() {
		var id = $(this).val();
		$.ajax({
			url : "member.id.check" ,
			data : {sm_id:id}, // {파라메터명:값, 파라메터명:값, ....}
			success: function(data) {
				if (id.length == 0) {
					$("#joinLoginOK").css("color","#263238").text("ID입력");
					
				}else if (id.length == 1 ) {
					$("#joinLoginOK").css("color","red").text("1개이상 입력");
					
				}else if ($(data).find("member").length == 1) {
					$("#joinLoginOK").css("color","red").text("중복");
					
				}else {
					$("#joinLoginOK").css("color","#263238").text("OK");
				}
			}
		});
	});
}
function followingCheck() {
	
		
		var f_sm_id = $("#f_sm_id").val();
		$.ajax({
			url : "page.follow",
			data : {jsf_followingid : f_sm_id},
			success: function(data) {
		
				
				if ($(data).find("follow").length != 0) {
					$("#following").empty();
					var followingCount = $(data).find("follow").length;
					
					$("#following").text("Following("+followingCount+")");				
				} else {
					$("#following").empty();
					$("#following").text("Following(0)");
				}
				
			}
			
		});
	
}
function follower() {
	
		var f_sm_id = $("#f_sm_id").val();
		$.ajax({
			url : "page.follower",
			data : {jsf_followerid : f_sm_id},
			success: function(data) {
			
				
					$("#follower").empty();
					
					var followerCount = $(data).find("follow").length;
					
					$("#follower").text("Follower("+followerCount+")");				
				
				
			}
			
		});
	
}

function followerCheck() {
	
	var sm_id = $(".sm_id").val();
	var f_sm_id = $(".f_sm_id").val();
	$.ajax({
		url : "page.follower.check",
		data : {jsf_followingid : sm_id,jsf_followerid : f_sm_id},
		success: function(data) {
			
			if ($(data).find("follow").length == 1) {
				
				$(".followerTd").css("border","red solid 2px");
				checkForHash();
				
				
			}else {
				
				$(".followerTd").css("border","black solid 2px");
				checkForHash();
			}
			
		}
		
	});
	
}

function followClick() {
		
		 var currentPage = "";
		$(".followerTd").click(function() {
			if ($(".followerTd").css("border") == "2px solid rgb(255, 0, 0)") {
				
			var sm_id = $(".sm_id").val();
			var f_sm_id = $(".f_sm_id").val();
			$.ajax({
				url : "page.follower.delete",
				data : {jsf_followingid : sm_id,jsf_followerid : f_sm_id},
				success: function(data) {
					
					follower();
				}
				
			});
			$(".followerTd").css("border","black solid 2px");
			currentPage = "black solid 2px";
	        document.location.hash = "#" + currentPage;
	        
			
			}else {
				
				var sm_id = $(".sm_id").val();
				var f_sm_id = $(".f_sm_id").val();
				$.ajax({
					url : "page.follower.reg",
					data : {jsf_followingid : sm_id,jsf_followerid : f_sm_id},				
					success: function(data) {
						follower();
					}
					
				});
				
				$(".followerTd").css("border","red solid 2px");
				currentPage = "red solid 2px";
				
				document.location.hash = "#" + currentPage;
			}
			
		})
}

function checkForHash() {
    if(document.location.hash){
        var HashLocationName = document.location.hash;
        HashLocationName = HashLocationName.replace("#","").replace("%20"," ").replace("%202"," 2");
       
        $(".followerTd").css("border", HashLocationName);
        
    } 
}

function snsAllShow(pNo) {
	
	$.getJSON("sns.page.ajax?page="+pNo,function(data){
		var login_sm_id = $("#login_sm_id").val();
		var no = 0;
		var sun = true;
		$.each(data.sns,function(i,s){
			no = i;
			
			

				
			
			$.getJSON("hart.check?st_no="+s.st_no,function(data2){
				$.getJSON("hart.check.img?st_no="+s.st_no+"&st_id="+s.st_id,function(data3){
					
			if (s.st_img == 'kakao.jpg') {
				var homeSNSImg = $("<img></img>").attr("class","homeSNSImg").attr("src","resources/baseImg/"+s.st_img);
				var aHomeSNSImg = $("<a></a>").attr("href","resources/baseImg/"+s.st_img).append(homeSNSImg);
			}else {
				var homeSNSImg = $("<img></img>").attr("class","homeSNSImg").attr("src","resources/memberImg/"+s.st_img);
				var aHomeSNSImg = $("<a></a>").attr("href","resources/memberImg/"+s.st_img).append(homeSNSImg);
			}
			if (login_sm_id == s.st_id) {
				var st_id = $("<a></a>").attr("class","st_id").attr("style","cursor: pointer;").attr("onclick","goMyPage('"+login_sm_id+"');").text(s.st_id+"("+s.sm_name+")");
			}else {
				var st_id = $("<a></a>").attr("class","st_id2").attr("style","cursor: pointer;").attr("onclick","goPage('"+s.st_id+"');").text(s.st_id+"("+s.sm_name+")");	
			}
			var homeSNSIdTd = $("<td></td>").attr("align","left").attr("class","homeSNSIdTd").append(aHomeSNSImg,st_id);
			
			if (login_sm_id == s.st_id || login_sm_id == "koko2921") {
				var homeSNSButtonU = $("<button></button>").attr("class","homeSNSButton").attr("onclick","goSNSDetail('"+s.st_no+"',1,'"+s.st_txt+"')").text("수정");
				var homeSNSButtonD = $("<button></button>").attr("class","homeSNSButton").attr("onclick","goSNSDelete('"+s.st_no+"')").text("삭제");
			}else {
				var homeSNSButtonU=$("<a></a>");
				var homeSNSButtonD=$("<a></a>");
			}
			var homeSNSUDButtonTd = $("<td></td>").attr("align","right").append(homeSNSButtonU,homeSNSButtonD);			
			var homeSNSTr = $("<tr></tr>").append(homeSNSIdTd,homeSNSUDButtonTd);
			
			/////////////////////////////////////////////////////
			
			var homeSNSHostTd = $("<td></td>").attr("align","left").attr("class","homeSNSHostTd").text(s.st_host);
			var homeSNSDate = $("<fmt:formatDate/>").attr("value",s.st_date).attr("pattern","yyyy/MM/dd (E) a hh:mm");
			var homeSNSDateTd = $("<td></td>").attr("align","right").attr("class","homeSNSDateTd").html(s.st_date.year+"년"+s.st_date.monthValue+"월"+s.st_date.dayOfMonth+"일 "+s.st_date.hour+"시"+s.st_date.minute+"분");
			var homeSNSHDTr = $("<tr></tr>").append(homeSNSHostTd,homeSNSDateTd);
			var homeSNSHDTable=  $("<table></table>").attr("style","border-spacing: 0px; width: 100%;").append(homeSNSHDTr);
			var UHomeSNSHDTd = $("<td></td>").attr("colspan","2").append(homeSNSHDTable);
			var UHomeSNSHDTr =$("<tr></tr>").append(UHomeSNSHDTd);
			
			//////////////////////////////////////////////////////
			
			if (s.st_photo !='photo' ) {
				var photo = $("<img></img>").attr("class","homeSNSPhoto").attr("src","resources/photo/"+s.st_photo);
				var aPhoto = $("<a></a>").attr("href","resources/photo/"+s.st_photo).append(photo);
			}else {
				var aPhoto = $("<a></a>");
			}
			var photoTd = $("<td></td>").attr("colspan","2").attr("align","center").append(aPhoto);
			var photoTr = $("<tr></tr>").append(photoTd);
			//////////////////////////////////////////////////
			
			var homeSNSTxtTd = $("<td></td>").attr("colspan","2").attr("align","left").attr("class","homeSNSTxtTd").text(s.st_txt);
			var homeSNSTxtTr = $("<tr></tr>").append(homeSNSTxtTd);
			
			/////////////////////////////////////////////////
			
					var hartImg =  data3.hart.length;
					var hartCheck = "hart.png";
					if (hartImg == 1) {
						hartCheck = "hartok.png";
					}
			
					var hartImg =$("<img></img>").attr("class","hartImg").attr("src","resources/img/"+hartCheck);
					
					var hartCount =  data2.hart.length;
						
					
					var hartNumber = $("<span></span>").text("("+hartCount+")");
					
					
					var hartTd = $("<td></td>").attr("colspan","2").attr("align","left").append(hartImg,hartNumber);
					var hartTr = $("<tr></tr>").append(hartTd);
					
					/////////////////////////////////////////////////////////////////////
					
					if (login_sm_id != null) {
					
						var pageNo = $("<input></input>").attr("type","hidden").attr("value","1").attr("name","pageNo");
						var sc_st_no = $("<input></input>").attr("type","hidden").attr("value",s.st_no).attr("name","sc_st_no");
						var snsCommentId = $("<span></span>").text(login_sm_id);
						var sc_txt = $("<input></input>").attr("id","homeCommentInput").attr("maxlength","100").attr("name","sc_txt");
						var homeCommentButton = $("<button></button>").attr("id","homeCommentButton").text("쓰기");
						var commentForm = $("<form></form>").attr("action","sns.comment.reg").attr("onsubmit","return commentCheck(this)").append(pageNo,sc_st_no,snsCommentId,sc_txt,homeCommentButton);
					}else {
						var commentForm = $("<a></a>");
					}
					var homeCommentTd = $("<td></td>").attr("colspan","2").attr("id","homeCommentTd").append(commentForm);
					var homeCommentTr = $("<tr></tr>").append(homeCommentTd);
					
					///////////////////////////////////////////////////////
					
					
					var homeSNSTable = $("<table></table>").attr("class","homeSNSTable").append(homeSNSTr,UHomeSNSHDTr,photoTr,homeSNSTxtTr,hartTr,homeCommentTr);
					
					if (s.snscs != null) {
						
						for (var i = 0; i < s.snscs.length; i++) {
							var commentTd = $("<td></td>").attr("class","allCommentTd").attr("style","border-bottom:#263238 dotted 1px;").attr("colspan","2");
							
							if (s.st_img == 'kakao.jpg') {
								var homeSNSCommentImg = $("<img></img>").attr("class","homeSNSCommentImg").attr("src","resources/baseImg/"+s.snscs[i].sc_img);
								var aHomeSNSCommentImg = $("<a></a>").attr("href","resources/baseImg/"+s.snscs[i].sc_img).append(homeSNSCommentImg);
							}else {
								var homeSNSCommentImg = $("<img></img>").attr("class","homeSNSCommentImg").attr("src","resources/memberImg/"+s.snscs[i].sc_img);
								var aHomeSNSCommentImg = $("<a></a>").attr("href","resources/memberImg/"+s.snscs[i].sc_img).append(homeSNSCommentImg);
							
							}										
							
							var homeSNSCommentImgTd = $("<td></td>").append(aHomeSNSCommentImg);
							//////////////////////////////////////////////////////
							
							if (login_sm_id == s.snscs[i].sc_id) {
								var aHomeSNSCommentId = $("<a></a>").attr("style","cursor: pointer;").attr("onclick","goMyPage('"+login_sm_id+"');").text(s.snscs[i].sc_id);	
							}else {
								var aHomeSNSCommentId = $("<a></a>").attr("style","cursor: pointer;").attr("onclick","goPage('"+s.snscs[i].sc_id+"');").text(s.snscs[i].sc_id);	
								
							}
							var homeSNSCommentIdTd = $("<td></td>").attr("id","homeSNSCommentIdTd").append(aHomeSNSCommentId);
							
							///////////////////////////////////////////////////////
							
							var homeSNSCommentTxtSpan = $("<span></span>").text(s.snscs[i].sc_txt);
							var homeSNSCommentTxtTd = $("<td></td>").attr("id","homeSNSCommentTxtTd").append(homeSNSCommentTxtSpan);
							
							/////////////////////////////////////////////////////////////
							
							var homeSNSCommentDateTd = $("<td></td>").attr("id","homeSNSCommentDateTd").text(s.snscs[i].sc_date.year+"년"+s.snscs[i].sc_date.monthValue+"월"+s.snscs[i].sc_date.dayOfMonth+"일 "+s.snscs[i].sc_date.hour+"시"+s.snscs[i].sc_date.minute+"분");
							//////////////////////////////////////////////////
							
							
							if (login_sm_id == s.snscs[i].sc_id || login_sm_id == "koko2921") {
								var homeSNSCommentButtonU = $("<button></button>").attr("class","homeSNSCommentButton").attr("onclick","goSNSCommentUpdate('"+s.snscs[i].sc_no+"',1,)").text("수정");
								var homeSNSCommentButtonD = $("<button></button>").attr("class","homeSNSCommentButton").attr("onclick","goSNSCommentDelete('"+s.snscs[i].sc_no+"',1,)").text("삭제");
							}else {
								var homeSNSCommentButtonU=$("<a></a>");
								var homeSNSCommentButtonD=$("<a></a>");
							}
							var homeSNSCommentButtonTd = $("<td></td>").attr("id","homeSNSCommentButtonTd").append(homeSNSCommentButtonU,homeSNSCommentButtonD);			
							
							
							
							
							var homeSNSCommentTr = $("<tr></tr>").append(homeSNSCommentImgTd,homeSNSCommentIdTd,homeSNSCommentTxtTd,homeSNSCommentDateTd,homeSNSCommentButtonTd);
							var homeSNSCommentTable = $("<table></table>").attr("id","homeSNSCommentTable").append(homeSNSCommentTr);
							commentTd.append(homeSNSCommentTable);
							var commentTr = $("<tr></tr>").append(commentTd);
							homeSNSTable.append(commentTr);
						}
					}else {
						
					}
					
					
						
						$("#homeSNSAllTd").append(homeSNSTable);
					
						
		});
		});
			
	});
	});
}

function scrollShow() {
	var pNo = 1;
	snsAllShow(pNo);
	
	

	
	$(window).scroll(function() {
		var htmlHeight = $(document).height();
		var scrollBottom =$(window).scrollTop() + $(window).height();
		
		if (scrollBottom >= htmlHeight) {
			pNo++;
			snsAllShow(pNo);
			
		}
	});
}


function hartCount(st_no) {
	
	if (st_no != 0) {
		$.getJSON("hart.check?st_no="+st_no,function(data){
			var hartCount = data.hart.length;
			alert(hartCount);
			return hartCount;
			
			
		});
		
	}
	re
	
	
}






	