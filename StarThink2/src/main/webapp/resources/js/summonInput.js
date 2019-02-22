//		css로 안보이게(
//			좌표조절, 
//			투명도(opacity를 0으로),
//			visibility속성을 hidden으로 : 애니메이션,
function connectSummonEvent() {
	
	var summon = false;
	$("#snsRegSummonImg").mouseenter(function() {
		if (!summon) {
			$("#homeTxtTable").css("bottom","0px");	
		} else {
			$("#homeTxtTable").css("bottom","-124px");
			
		}
		summon = !summon;
	
	});
	
	
}

// 결제?
// 휴대폰 인증?

function connectSummonAddrInputEvent() {
	$("#joinAddrSeach").click(function() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	           $("#sm_addr1").val(data.zonecode);
	           $("#sm_addr2").val(data.address);
	        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	        }
	    }).open();
	});
}