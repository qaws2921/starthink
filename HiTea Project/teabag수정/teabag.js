function teabag_previewProfile(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f) {
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$("#tb_profileDiv2").css("background-image", "url("+e.target.result +")");
		}
		reader.readAsDataURL(f);
	});
}
function teabag_previewBG(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f) {
		var reader = new FileReader();
		
		reader.onload = function(e) {
			$("#tb_bgPic").css("background-image", "url("+e.target.result +")");
		}
		reader.readAsDataURL(f);
	});
}
function teabagPreview() {
	$("#tb_profilePic").on("change", teabag_previewProfile);
	$("#tb_bgPic1").on("change", teabag_previewBG);
	$("#tb_bgPic").on("dblclick", function () {
		var url = "site.teabag.getBandByBNo?ht_no="+$("#tb_no1").val();
		$.getJSON(url, function (data) {
			$("#tb_bgPic").css("background-image", "url(resources/img/teabag/"+data.ht_bgpic +")");
			$("#tb_bgPic1").val("");
		});
	});
	$("#tb_profileDiv2").on("dblclick", function () {
		var url = "site.teabag.getBandByBNo?ht_no="+$("#tb_no1").val();
		$.getJSON(url, function (data) {
			$("#tb_profileDiv2").css("background-image", "url(resources/img/teabag/"+data.ht_profilepic +")");
			$("#tb_profilePic").val("");
		});
	});
}
function tb_bbs_goUpdate(hb_no) {
	$("#tb_bbs_button1").attr("id", "tb_bbs_button2").text("수정");
	var url = "teabag.bbs.goUpdate?hb_no=" + hb_no;
	$.getJSON(url, function (data) {
		$("#hb_content").val(data.hb_content);
		$("#hb_contentUpdate2").val(data.hb_no);
	});
}
function tb_bbs_write() {
	$(document).on("click","#tb_bbs_button1",function() {
		location.href="teabag.bbs.write?hb_content="+$("#hb_content").val();
	});
	
}
function tb_bbs_update() {
	$(document).on("click","#tb_bbs_button2",function() {
		location.href="teabag.bbs.update?hb_no="+$("#hb_contentUpdate2").val() + "&hb_content="+$("#hb_content").val();
	});
}
function getDataroomAll() {
	url = "teabag.dr.getPhoto";
	tb_dataroom_getPhoto();
}

function tb_dataroom_getPhoto() {
	$.getJSON(url, function(data) {
		$("#tb_filesTd").empty();
		$.each(data.dataroom, function(i, s) {
			if($("#teabagMyId").val() == s.hd_id || $("#teabagJoin").val() == 'L' ){
				var deleteImg = $("<img></img>").attr("src", "resources/img/teabag/delete.png").attr("class", "tb_filesDeletePic");
				var deleteATag =  $("<a></a>").attr("onclick", "goDeleteDR("+s.hd_no +")").append(deleteImg); 
			}
			var img = $("<img></img>").attr("src", "resources/img/teabag/"+s.hd_fname).attr("class", "tb_filesPic");
			var downloadATag = $("<a></a>").attr("href", "resources/img/teabag/"+s.hd_fname).append(img); 
			var td1 = $("<td></td>").append(deleteATag).attr("align", "right").attr("valign", "top").attr("class", "tb_filestd1");
			var tr1 = $("<tr></tr>").append(td1);
			var td2 = $("<td></td>").append(downloadATag).attr("align", "center");
			var tr2 = $("<tr></tr>").append(td2);
			var td3 = $("<td></td>").text(s.hd_date.year+"/"+s.hd_date.monthValue+"/"+s.hd_date.dayOfMonth).attr("align", "center").attr("class", "tb_filestd3");
			var tr3 = $("<tr></tr>").append(td3);
			var td4 = $("<td></td>").text(s.hd_title).attr("valign", "top").attr("align", "center").attr("class", "tb_filestd4");
			var tr4 = $("<tr></tr>").append(td4);
			var td5 = $("<td></td>").text(s.hm_nickname).attr("valign", "top").attr("align", "center").attr("class", "tb_filestd2");
			var tr5 = $("<tr></tr>").append(td5);
			var table = $("<table></table>").append(tr1, tr4, tr2, tr5, tr3).attr("class", "tb_filesDiv");
			
			$("#tb_filesTd").append(table);			
		});
	});

	$.getJSON("teabag.dr.pageCountPhoto", function (data) {
		$("#tb_filedPageTd").empty();
		for (var i = 1; i <=data ; i++) {
			var aTag = $("<a></a>").attr("class", "tb_filesATag");
			aTag.attr("onclick", "goPagePhoto("+i+")").text(i);
			$("#tb_filedPageTd").append(aTag);
		}
	});
}

function tb_dataroom_getFile() {
	$.getJSON(url, function(data) {
		$("#tb_filesTd").empty();
		$.each(data.dataroom, function(i, s) {
			if($("#teabagMyId").val() == s.hd_id || $("#teabagJoin").val() == 'L' ){
				var deleteImg = $("<img></img>").attr("src", "resources/img/teabag/delete.png").attr("class", "tb_filesDeletePic");
				var deleteATag =  $("<a></a>").attr("onclick", "goDeleteDR("+s.hd_no +")").append(deleteImg); 
			}
			var img = $("<img></img>").attr("src", "resources/img/teabag/files.png").attr("class", "tb_filesPic");
			var downloadATag = $("<a></a>").attr("href", "resources/img/teabag/"+s.hd_fname).append(img);
			var td1 = $("<td></td>").append(deleteATag).attr("align", "right").attr("valign", "top").attr("class", "tb_filestd1");
			var tr1 = $("<tr></tr>").append(td1);
			var td2 = $("<td></td>").append(downloadATag).attr("align", "center");
			var tr2 = $("<tr></tr>").append(td2);
			var td3 = $("<td></td>").text(s.hd_date.year+"/"+s.hd_date.monthValue+"/"+s.hd_date.dayOfMonth).attr("class", "tb_filesDate").attr("align", "center").attr("class", "tb_filestd3");
			var tr3 = $("<tr></tr>").append(td3);
			var td4 = $("<td></td>").text(s.hd_title).attr("valign", "top").attr("align", "center").attr("class", "tb_filestd4");
			var tr4 = $("<tr></tr>").append(td4);
			var td5 = $("<td></td>").text(s.hd_fname).attr("class", "tb_filesFname").attr("align", "center").attr("class", "tb_filestd2");
			var tr5 = $("<tr></tr>").append(td5);
			var td6 = $("<td></td>").text(s.hm_nickname).attr("valign", "top").attr("align", "center").attr("class", "tb_filestd5");
			var tr6 = $("<tr></tr>").append(td6);
			var table = $("<table></table>").append(tr1, tr4, tr2, tr5, tr6, tr3).attr("class", "tb_filesDiv2");
			$("#tb_filesTd").append(table);					
		});
	});
	
	$.getJSON("teabag.dr.pageCountFile", function (data) {
		$("#tb_filedPageTd").empty();
		for (var i = 1; i <=data ; i++) {
			var aTag = $("<a></a>").attr("class", "tb_filesATag");
			aTag.attr("onclick", "goPageFile("+i+")").text(i);
			$("#tb_filedPageTd").append(aTag);
		}
	});
}

function tb_dataroom_pick() {
	$("#tb_photoPick").click(function () {
		$("#tb_dr_file_input").attr("name", "tb_photo");
		$("#tb_dr_title2").attr("id", "tb_dr_title");
		$("#tb_dr_inputButton2").attr("id", "tb_dr_inputButton");
		url = "teabag.dr.getPhoto";
		tb_dataroom_getPhoto();
	});
	$("#tb_filePick").click(function () {
		$("#tb_dr_file_input").attr("name", "tb_file");
		$("#tb_dr_title").attr("id", "tb_dr_title2");
		$("#tb_dr_inputButton").attr("id", "tb_dr_inputButton2");
		url = "teabag.dr.getFile";
		tb_dataroom_getFile();
	});
}

function tb_member_getAllByTNo() {
	var url = "teabag.member.getAllMember";
	$.getJSON(url, function(data) {
		$("#tb_memberList_tbMember").empty();
		$.each(data.teabagMember, function(i, s) {
			if($("#teabagLeaderId").val() == s.htm_id) {
				var deleteATag = $("<img></img>").attr("src", "resources/img/teabag/leader.png").attr("class", "tb_filesDeletePic");
			} else{
				var deleteATag = $("<img></img>").attr("src", "resources/img/teabag/noleader.png").attr("class", "tb_filesDeletePic");
			}
			if($("#teabagJoin").val() == 'L' ){
				if($("#teabagLeaderId").val() != s.htm_id) { 
					var deleteImg = $("<img></img>").attr("src", "resources/img/teabag/delete.png").attr("class", "tb_filesDeletePic");
					deleteATag =  $("<a></a>").attr("onclick", "goForceDeleteMember('"+s.htm_id +"')").append(deleteImg); 
					var delegateDiv = $("<span></span>").text("위임").attr("class", "tb_delegateDiv");
					var delegateATag = $("<a></a>").attr("onclick", "goDelegateMember('"+s.htm_id +"')").append(delegateDiv);
				} else {
					deleteATag = $("<img></img>").attr("src", "resources/img/teabag/leader.png").attr("class", "tb_filesDeletePic");
				}
			}
			var img = $("<span></span>").css("background", "url(resources/img/member/"+s.hm_photo_front+") center center no-repeat").css("background-size", "auto 100%").attr("class", "tb_teabagProfileDiv");
			var td1 = $("<td></td>").append(delegateATag, deleteATag).attr("align", "right").attr("valign", "top").attr("class", "tb_filestd1");
			var tr1 = $("<tr></tr>").append(td1);
			var td2 = $("<td></td>").append(img).attr("align", "center");
			var tr2 = $("<tr></tr>").append(td2);
			var td3 = $("<td></td>").text(s.htm_date.year+"/"+s.htm_date.monthValue+"/"+s.htm_date.dayOfMonth).attr("class", "tb_filesDate").attr("align", "center").attr("class", "tb_filestd3");
			var tr3 = $("<tr></tr>").append(td3);
			var td5 = $("<td></td>").text(s.hm_nickname).attr("class", "tb_filesFname").attr("align", "center").attr("class", "tb_filestd3");
			var tr5 = $("<tr></tr>").append(td5);
			var table = $("<table></table>").append(tr1, tr2, td5, tr3).attr("class", "tb_filesDiv");
			$("#tb_memberList_tbMember").append(table);					
		});
	});
}

function tb_member_getJoinReq() {
	var url = "teabag.member.getJoinReq";
	$.getJSON(url, function(data) {
		$("#tb_memberList_tbMember").empty();
		$.each(data.joinreq, function(i, s) {
			var accept = $("<span></span>").text("수락").attr("class", "tb_joinDiv");
			var acceptATag = $("<a></a>").attr("href", "teabag.member.acceptJoinReq?hj_no="+s.hj_no).append(accept).attr("class", "tb_joinATag");
			var deny = $("<span></span>").text("거절").attr("class", "tb_joinDiv");
			var denyATag = $("<a></a>").attr("href", "teabag.member.denyJoinReq?hj_no="+s.hj_no).append(deny).attr("class", "tb_joinATag"); 
			var img = $("<span></span>").css("background", "url(resources/img/member/"+s.hm_photo_front+") center center no-repeat").css("background-size", "auto 100%").attr("class", "tb_teabagProfileDiv");
			var td1 = $("<td></td>").append(acceptATag,denyATag).attr("align", "right").attr("valign", "top").attr("class", "tb_filestd1");
			var tr1 = $("<tr></tr>").append(td1);
			var td2 = $("<td></td>").append(img).attr("align", "center");
			var tr2 = $("<tr></tr>").append(td2);
			var td3 = $("<td></td>").text(s.hj_date.year+"/"+s.hj_date.monthValue+"/"+s.hj_date.dayOfMonth).attr("class", "tb_filesDate").attr("align", "center").attr("class", "tb_filestd3");
			var tr3 = $("<tr></tr>").append(td3);
			var td5 = $("<td></td>").text(s.hm_nickname).attr("class", "tb_filesFname").attr("align", "center").attr("class", "tb_filestd3");
			var tr5 = $("<tr></tr>").append(td5);
			var table = $("<table></table>").append(tr1, tr2, td5, tr3).attr("class", "tb_filesDiv2");
			$("#tb_memberList_tbMember").append(table);					
		});
	});
}

function tb_member_pick() {
	$("#tb_memberList").on("click", function() {
		tb_member_getAllByTNo();
	});
}
function tb_joinReq_pick() {
	$("#tb_joinReqList").on("click", function() {
		tb_member_getJoinReq();
	});
}


function getTeabag(urlPlus, td) {
	var url = "site.teabag."+urlPlus;
	$.getJSON(url, function(data) {
		$.each(data.teabag, function(i, s) {
			var aTag = $("<a></a>").attr("href", "site.teabag.go?ht_no="+s.ht_no);
			var div1 = $("<span></span>").css("background", "url(resources/img/teabag/"+s.ht_profilepic+") center center no-repeat").css("background-size", "auto 100%").attr("class", "tb_profileDiv");
			var img = $("<img></img>").attr("src", "resources/img/teabag/"+s.ht_profilepic).attr("class", "tb_img1");
			var div = $("<div></div>").attr("class", "tb_div1").attr("align", "center");
			var span = $("<span></span>").html("<br>"+"<br>"+s.ht_name+"<br>"+s.ht_category);
			var span2 = $("<span></span>").html("<br>");
			
			div.append(span2, div1, span);
			
			aTag.append(div);
			$(td).append(aTag);				
		});

	});
}

function getLatestTeabag() {
	getTeabag("getAll", "#tb_latestTeaBags");
}

function getJoinTeabag() {
	getTeabag("getFourTeabagById", "#tb_JoinTeabag");
}

function getJoinTeabagMore() {
	var summon = false;
	$("#tb_moreTeabagImg").click(function() {
		if (!summon) {
		$("#tb_JoinTeabag").empty();
		getTeabag("getTeabagById", "#tb_JoinTeabag");
		$("#tb_moreTeabagImg").empty();
		$("#tb_moreTeabagImg").append($("<img></img>").attr("src", "resources/img/teabag/minus.png"));
		} else{
			$("#tb_JoinTeabag").empty();
			getTeabag("getFourTeabagById", "#tb_JoinTeabag");
			$("#tb_moreTeabagImg").empty();
			$("#tb_moreTeabagImg").append($("<img></img>").attr("src", "resources/img/teabag/plus.png"));
		}
		summon = !summon;
	});
}

function getTeabagsByPopularity() {
	getTeabag("getAllTeabag", "#tb_popularityTeabags");
}

function getTeabagsByCategory() {
	$(".tb_teabagCategory").click(function() {
		$("#tb_popularityTeabags").empty();
		var ht_category = $(this).attr("id");
		getTeabag("getTeabagByCategory?ht_category="+ht_category, "#tb_popularityTeabags");
	});
}

function getTeabagsByPopularityClick() {
	$(".tb_teabagCategory1").click(function() {
		$("#tb_popularityTeabags").empty();
		getTeabagsByPopularity();
	});
}

function getTeabagPageNotice() {
	var url="teabag.member.getPageNoticeById";
	$.getJSON(url, function(data) {
		if(data.pagenotice != ""){
			$("#tb_personalNotice").empty();
			$.each(data.pagenotice, function(i, s) {
				var div = $("<div></div>").text(s.hpn_content).attr("class", "tb_noticeDiv").attr("align", "center");
				var aTag = $("<a></a>").attr("onclick", "goTeabagPage("+s.hpn_tno+")").append(div);
				$("#tb_personalNotice").append(aTag);
			});
			
		}

	});
}

function teabagNameCheck() {
	$(".ht_nameInput").keyup(function() {
		var ht_name = $(".ht_nameInput").val();
		$.getJSON("site.teabag.getTeabagByName?ht_name="+ht_name, function(data) {
			if(data.teabag != ""){
				$("#tb_name_overlap_result").text("중복").css("color", "red");
			} else if(ht_name == ""){
				$("#tb_name_overlap_result").text("이름 필수").css("color", "red");
			} else{
				$("#tb_name_overlap_result").text("OK").css("color", "blue");
			} 
		});
	});
}
