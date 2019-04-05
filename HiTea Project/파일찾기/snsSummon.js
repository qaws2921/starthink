function snsWriteSummonEvent() {
	var summon = false;
	
	$("#snsWriteSummon").click(function() {
		if (!summon) {
			
			var a = $("<input>").attr("type","file");
				a = a.attr("id","snsfileInput").attr("onchange", "javascript:document.getElementById('yw_file_route').value=this.value");
				a = a.attr("multiple","multiple");
			
			var a2 = $("<span></span>").attr("class", "yw_file_wrap");
				a2 = a2.append(a);
				
			var a4 = $("<input></input>").attr("class", "yw_file_route").attr("id", "yw_file_route").attr("readonly", "readonly");

			var a3 = $("<div></div>").attr("class", "yw_wrap");
				a3 = a3.append(a4, a2);

				
			var aa = $("<td></td>");
				aa = aa.append(a3);
			var aaa = $("<tr></tr>");
				aaa = aaa.append(aa);
			var aaaa =$("<table></table>").attr("id", "snsfileInputTable");
				aaaa = aaaa.append(aaa);
			
			var td1 = $("<td></td>").attr("id", "snstabFileImage");
				td1 = td1.text("미리보기");
			var td2 = $("<td></td>").attr("id","snstabFileName")
				td2 = td2.attr("align","center")
				td2 = td2.text("파일명");
			var td3 = $("<td></td>").attr("id","snstabFileDel")
				td3 = td3.text("삭제");
			var tr = $("<tr></tr>").append(td1, td2, td3);
			
			var table = $("<table></table>").attr("id","snsfileTable");
				table = table.append(tr);
			
			var div = $("<div></div>").attr("class","snsdragDropDiv");
				div = div.append(aaaa, table);
			
			$(".snsdragdiv").append(div);
			$(".snsdragdiv").css("width", "500px");		
			
			$(".snsWriteTable").css("border-bottom", "none");
		} else {
			$(".snsdragdiv").empty();
			$(".snsdragdiv").css("width", "none");
			
			$(".snsWriteTable").css("border", "#E0E0E0 solid 1px");
		}
		summon = !summon;
	});
}


