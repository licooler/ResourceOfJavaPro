function changeSMSType() {
	var selectType = document.getElementById("smsSelectType").value;
	var SMSActivityID = document.getElementById("SMSActivityID").value;
	var SMSParVal = document.getElementById("SMSParVal").value;
	if (!document.getElementById(SMSActivityID + "_" + selectType)) {
		document.getElementById("isSendSMSDiv").style.display = "none";
		document.getElementById("isSendSMS").checked = false;
		document.getElementById("sendSMSContentDiv").style.display = "none";
		document.getElementById("sendSMSContent").innerHTML = ""
	} else {
		document.getElementById("isSendSMSDiv").style.display = "block";
		document.getElementById("isSendSMS").checked = false;
		document.getElementById("sendSMSContentDiv").style.display = "block";
		var sms = document.getElementById(SMSActivityID + "_" + selectType).value;
		document.getElementById("sendSMSContent").innerHTML = sms.format(
				SMSParVal, SMSParVal)
	}
}
function changeQQType(activityId, parVal) {
	if (!document.getElementById(activityID + "_����Q��")) {
		document.getElementById("isQQSendSMSDiv").style.display = "none";
		document.getElementById("isSendQQSMS").checked = false;
		document.getElementById("sendQQSMSContentDiv").style.display = "none";
		document.getElementById("sendQQSMSContent").innerHTML = ""
	} else {
		document.getElementById("isQQSendSMSDiv").style.display = "block";
		document.getElementById("isSendQQSMS").checked = false;
		document.getElementById("sendQQSMSContentDiv").style.display = "block";
		var sms = document.getElementById(activityID + "_����Q��").value;
		document.getElementById("sendQQSMSContent").innerHTML = sms.format(
				parVal, parVal)
	}
}
function queryBatchNo(activityID) {
	$("#batchId").val("");
	$.ajax({
		type : "post",
		dataType : "json",
		data : "activityID=" + activityID + "&type=batchNo",
		url : "/icsBizSupport/game/customService.do",
		success : function(result) {
			var batchArray = new Array();
			var Str = "<option value=''>��������</option>";
			batchArray.push(Str);
			$.each(result, function(index, batchObj) {
				var batchNo = batchObj.batchNo;
				var batchId = batchObj.batchId;
				var htmlStr = "<option value=" + batchId + ">" + batchNo
						+ "</option>";
				batchArray.push(htmlStr)
			});
			$("#batchId").html(batchArray.join(""))
		}
	})
}
function subSMSConext() {
	var smsSelectTypeValue = $("#smsSelectType").val();
	var desc = $("#smsSelectType").find("option[selected='selected']").html();
	var desc = document.getElementById("smsSelectType").value;
	var paymentAccount = $.trim($("#paymentAccount").val());
	if (desc == "����֧����") {
		if (paymentAccount == "") {
			support_alert("������֧�����˺ţ�");
			return
		}
		desc = desc + " , ֧�����˺�:" + paymentAccount
	} else {
		desc = desc + " , ����:" + paymentAccount
	}
	var tip = "ȷ�Ͻ������ύ���Ѵ������";
	if (smsSelectTypeValue == "1") {
		tip = "ȷ�Ͻ������ύ��δ�������"
	}
	if (confirm(tip)) {
		var splitId = document.getElementById("SMSSplitDetailId").value;
		var phone = document.getElementById("SMSPhone").value;
		var needNotify = document.getElementById("isSendSMS").checked;
		var template = document.getElementById("sendSMSContent").innerHTML;
		var selectType = $("#smsSelectType")
				.find("option[selected='selected']").html();
		$("#subSMSButton").attr("disabled", true);
		showContainer();
		$.ajax({
			type : "POST",
			dataType : "text",
			data : "module=newCustomer&splitId=" + splitId + "&phone=" + phone
					+ "&needNotify=" + needNotify + "&template=" + template
					+ "&desc=" + desc + "&fail=" + selectType
					+ "&smsSelectTypeValue=" + smsSelectTypeValue,
			url : "/icsBizSupport/game/insideUse.do",
			success : function(result) {
				hiddenContainer();
				$("#subSMSButton").attr("disabled", false);
				var dataObj = eval("(" + result + ")");
				support_alert(dataObj.message);
				if (dataObj.code == "ok") {
					window.location.href = window.location.href
				}
			}
		})
	}
}
function subQQConext() {
	var changeQQId = $.trim($("#changeQQId").val());
	var patrn = /^[1-9][0-9]{4,11}$/;
	if (!patrn.exec(changeQQId)) {
		support_alert("QQ��������5-12λ���֣����ҵ�һλ���ֲ���Ϊ 0 ��");
		return
	}
	var QQSplitDetailId = document.getElementById("QQSplitDetailId").value;
	var oldmobile = $.trim($("#QQOldPhone").html());
	var needNotify = document.getElementById("isSendQQSMS").checked;
	var template = document.getElementById("sendQQSMSContent").innerHTML;
	$("#subQQButton").attr("disabled", true);
	showContainer();
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "module=newCustomer&subType=QQ&oldeMobile=" + oldmobile
				+ "&newQQ=" + changeQQId + "&topupID=" + QQSplitDetailId
				+ "&needNotify=" + needNotify + "&template=" + template,
		url : "/icsBizSupport/game/changeMobile.do",
		success : function(result) {
			hiddenContainer();
			$("#subQQButton").attr("disabled", false);
			var dataObj = eval("(" + result + ")");
			support_alert(dataObj.message);
			if (dataObj.code == "ok") {
				window.location.href = window.location.href
			}
		}
	})
}
function queryTopupList() {
	var mobile = document.getElementById("mobile").value;
	var activityID = document.getElementById("activityID").value;
	var batchId = document.getElementById("batchId").value;
	var pageNo = document.getElementById("pageNo").value;
	var reason = document.getElementById("reasonId").value;
	reason = encodeURI(reason);
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "mobile=" + mobile + "&pageNo=" + pageNo + "&activityID="
				+ activityID + "&reason=" + reason + "&batchId=" + batchId,
		url : "/icsBizSupport/game/customService.do",
		success : function(result) {
			document.getElementById("topup_content").innerHTML = result
		}
	})
}
function queryTopupListPage(obj) {
	var mobile = document.getElementById("mobile").value;
	var activityID = document.getElementById("activityID").value;
	var batchId = document.getElementById("batchId").value;
	var pageNo = document.getElementById("pageNo").value;
	var reason = document.getElementById("reasonId").value;
	reason = encodeURI(reason);
	var page = "";
	if (obj == null || obj == "" || obj == "undefined") {
		page = document.getElementById("pageNoId").value
	} else {
		page = obj
	}
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "mobile=" + mobile + "&pageNo=" + page + "&activityID="
				+ activityID + "&reason=" + reason + "&batchId=" + batchId,
		url : "/icsBizSupport/game/customService.do",
		success : function(result) {
			document.getElementById("topup_content").innerHTML = result
		}
	})
}
function ExportSearch() {
	var activityID = document.getElementById("activityID").value;
	var batchId = document.getElementById("batchId").value;
	var mobile = document.getElementById("mobile").value;
	var reason = document.getElementById("reasonId").value;
	reason = encodeURI(reason);
	window.location.href = "/icsBizSupport/game/exportopupfile.do?activityID="
			+ activityID + "&reason=" + reason + "&mobile=" + mobile
			+ "&batchId=" + batchId
}
function showRepMobile() {
	var repMobil = $.trim($("#changeMobileId").val());
	if (repMobil == null || repMobil == "") {
		support_alert("�ֻ��Ų���Ϊ��");
		return
	} else {
		var reg = /^1[0-9]\d{9}$/;
		if (repMobil != null && repMobil != "") {
			if (!reg.test(repMobil)) {
				support_alert("�ֻ������ʽ����ȷ!");
				return
			}
		}
	}
	$("#hideChangeMobileId").val(repMobil);
	$("#changeMobileId").val("");
	$("#changeMobileId").val("");
	var rep = document.getElementById("changeMobileTxt").value;
	document.getElementById("changeMobileTxt").innerHTML = "ȷ�ϸ�������";
	$("#subbutton").css("display", "block");
	$("#subRepMobile").hide()
}
function validateMobile() {
	var newMobile = $.trim(document.getElementById("hideChangeMobileId").value);
	var repMobile = $.trim(document.getElementById("changeMobileId").value);
	if (repMobile == null || repMobile == "") {
		support_alert("�ظ�������ֻ��Ų���Ϊ��");
		return false
	}
	if (repMobile != newMobile) {
		support_alert("��������ĺ��벻һ�£�����������");
		return false
	}
	return true
}
function subConext() {
	var uid = document.getElementById("uid").value;
	var newMobile = $.trim(document.getElementById("hideChangeMobileId").value);
	var repMobile = $.trim(document.getElementById("changeMobileId").value);
	var oldmobile = document.getElementById("oldmobile").value;
	if (repMobile == null || repMobile == "") {
		support_alert("�ظ�������ֻ��Ų���Ϊ��");
		return false
	}
	if (repMobile != newMobile) {
		support_alert("��������ĺ��벻һ�£�����������");
		return false
	}
	$("#subbutton_submit").attr("disabled", true);
	showContainer();
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "module=newCustomer&subType=mobile&oldeMobile=" + oldmobile
				+ "&newMobile=" + newMobile + "&topupID=" + uid,
		url : "/icsBizSupport/game/changeMobile.do",
		success : function(result) {
			hiddenContainer();
			var dataObj = eval("(" + result + ")");
			support_alert(dataObj.message);
			$("#subbutton_submit").attr("disabled", false);
			if (dataObj.code == "ok") {
				window.location.href = window.location.href
			}
		}
	})
}
function subCumstomerRemark() {
	var handleOrderId = $("#handleOrderId").val();
	var remarkType = $("#remarkSelect").val();
	var remarkText = $("#remarkSelect").find("option[selected='selected']")
			.html();
	var otherRemark = $("#otherRemark").val();
	if (handleOrderId == "") {
		support_alert("����ȱʧ");
		return
	} else {
		if (remarkType == "") {
			support_alert("��ѡ��ע��");
			return
		}
	}
	$("#subRemarkButton").attr("disabled", true);
	showContainer();
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "handleOrderId=" + handleOrderId + "&remarkType=" + remarkType
				+ "&remarkText=" + remarkText + "&otherRemark=" + otherRemark,
		url : "/icsBizSupport/customerRemarkAdd.do",
		success : function(result) {
			hiddenContainer();
			var dataObj = eval("(" + result + ")");
			support_alert(dataObj.message);
			$("#subRemarkButton").attr("disabled", false);
			if (dataObj.result == "1") {
				window.location.href = window.location.href
			}
		}
	})
}
function subCumstomerSms() {
	var handleOrderId = $("#handleOrderId").val();
	var sms_phone = $("#sms_phone").val();
	var sms_centent = $("#sms_centent").val();
	var reg = /^1[0-9]\d{9}$/;
	if (handleOrderId == "") {
		support_alert("����ȱʧ");
		return
	} else {
		if (sms_phone == "") {
			support_alert("����д�ֻ���");
			return
		} else {
			if (!reg.test(repMobil)) {
				support_alert("�ֻ��Ÿ�ʽ����ȷ");
				return
			} else {
				if (sms_centent == "") {
					support_alert("�������ݲ��ܿ�");
					return
				}
			}
		}
	}
	$("#subSmsCententButton").attr("disabled", true);
	showContainer();
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "handleOrderId=" + handleOrderId + "&sms_phone=" + sms_phone
				+ "&sms_centent=" + sms_centent,
		url : "/icsBizSupport/customerSendSms.do",
		success : function(result) {
			hiddenContainer();
			support_alert(result.message);
			$("#subSmsCententButton").attr("disabled", false);
			if (dataObj.result == "1") {
				window.location.href = window.location.href
			}
		}
	})
}
function queryCommentList(refSourceId) {
	window
			.open(
					"/icsBizSupport/game/topUpDetailComment.do?refSourceId="
							+ refSourceId + "&operate=queryComments",
					"newwindow",
					"top=0",
					"left=0",
					"height=300, width=720, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=n o, status=no")
}
String.prototype.format = function() {
	if (arguments.length == 0) {
		return this
	}
	var s = this;
	for (var i = 0; i < arguments.length; i++) {
		s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i])
	}
	return s
};