function gojoin() {
	location.href = "member.join";
}
function goHome() {
	location.href = "home.go";
}
function goMembership() {
	location.href = "member.membership";
}
function goSNSPage(pageNo) {
	location.href = "sns.show.paging?pageNo="+pageNo;
}
function goSNSDetail(st_no,pageNo,st_txt) {
	location.href = "sns.detail?st_no="+st_no+"&pageNo="+pageNo+"&st_txt="+st_txt;
}
function goSNSDelete(st_no,pageNo) {
	if (confirm("진짜 삭제할꺼?")) {
		location.href = "sns.delete?st_no="+st_no;
		
	}
	
}
function goFileDelete(sf_no) {
	if (confirm("파일 삭제 할꺼?")) {
		location.href = "file.delete?sf_no="+sf_no;
		
	}
	
}
function goFileDetail(sf_no) {	
		location.href = "file.detail?sf_no="+sf_no;	
}


function goSNSCommentDelete(sc_no,pageNo) {
	if (confirm("댓글 삭제할꺼?")) {
		location.href = "sns.comment.delete?sc_no="+sc_no+"&pageNo="+pageNo;		
	}	
}
function goSNSCommentUpdate(sc_no,pageNo) {
	
	var sc_txt = prompt("바꿀 내용 쓰시오");
	
	if (sc_txt != null) {
		location.href = "sns.comment.update?sc_no="+sc_no+"&pageNo="+pageNo+"&sc_txt="+sc_txt;				
  }
}
function goMessageReg(sme_sm_id) {
	
	var sme_txt = prompt("내용을 입력하시오");
	
		location.href = "message.reg?sme_sm_id="+sme_sm_id+"&sme_txt="+sme_txt;				
}



function goLogout() {
	if (confirm("로그아웃 할꺼?")) {
		location.href = "member.logout";
		
	}
}
function goMemberDelete(sm_id) {
	if (confirm("진짜 삭제할꺼?")) {
		location.href = "member.membership.delete?sm_id="+sm_id;
		
	}
}

function goMyPage(sm_id) {
	location.href = "page.my.go?sm_id="+sm_id;
}
function goPage(sm_id) {
	location.href = "page.go?sm_id="+sm_id;
}