function showContainer() {
	$("<div/>").addClass("modal-backdrop fade in myContaner").appendTo("body")
}
function hiddenContainer() {
	$(".myContaner").remove()
}
function subSameConext() {
	var mobile = $.trim($("#sameMobile").val());
	var uid = $("#sameUid").val();
	var reg = /^1[0-9]\d{9}$/;
	if (!reg.test(mobile)) {
		alert("手机号码格式不正确!");
		return
	}
	$("#sameSubbutton").attr("disabled", true);
	showContainer();
	$.ajax({
		type : "POST",
		dataType : "text",
		data : "module=newCustomer&subType=same&sameMobile=" + mobile
				+ "&topupID=" + uid,
		url : "/icsBizSupport/game/changeMobile.do",
		success : function(result) {
			hiddenContainer();
			var dataObj = eval("(" + result + ")");
			support_alert(dataObj.message);
			$("#sameSubbutton").attr("disabled", false);
			if (dataObj.result == "1") {
				alert("test close!!!!!!!!!!!!");
				window.location.href = window.location.href
			}
		}
	})
}
function showOperatPage(b) {
	var button = $(b);
	var detailId = button.data("detailid");
	var phone = button.data("phone");
	var activityId = button.data("activityid");
	var parVal = button.data("parval");
	var handleOrderId = button.data("handleorderid");
	var data = {
		detailId : detailId,
		phone : phone,
		activityId : activityId,
		handleOrderId : handleOrderId,
		parVal : parVal
	};
	var tmplate_html = template("content_handle_tab", data);
	$("#handleModal").find(".modal-body").html(tmplate_html);
	$("#handleModal").modal("show").css("width", "auto");
	$("#otherInfoTab a").click(function(e) {
		e.preventDefault();
		$(this).tab("show")
	});
	changeSMSType();
	changeQQType(activityId, parVal)
}
function retrieveData(sSource, aoData, fnCallback) {
	var detailId = $("#check_detailId").val();
	var handleOrderId = $("#check_handleOrderId").val();
	aoData.push({
		name : "detailId",
		value : detailId
	});
	aoData.push({
		name : "handleOrderId",
		value : handleOrderId
	});
	$.ajax({
		type : "get",
		contentType : "application/json",
		url : sSource,
		dataType : "json",
		data : {
			aoData : JSON.stringify(aoData)
		},
		success : function(resp) {
			fnCallback(resp)
		}
	})
}
var operate_record_table;
function operate_record_table_fill() {
	if (!$.fn.dataTable.isDataTable("#content_operate_record_table")) {
		operate_record_table = $("#content_operate_record_table").dataTable({
			bLengthChange : false,
			bFilter : false,
			bSort : false,
			iDisplayLength : 10,
			bProcessing : true,
			bServerSide : true,
			sAjaxSource : "/icsBizSupport/customerHandlerOrderHis.do",
			sServerMethod : "POST",
			fnServerData : retrieveData,
			aoColumns : [ {
				sName : "No"
			}, {
				sName : "operateTime"
			}, {
				sName : "operator"
			}, {
				sName : "operateRecord"
			}, {
				sName : "number"
			}, {
				sName : "supplier"
			} ],
			oLanguage : {
				sLengthMenu : "每页显示 _MENU_ 条记录",
				sZeroRecords : "抱歉， 没有找到",
				sInfo : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				sInfoEmpty : "没有数据",
				sInfoFiltered : "(从 _MAX_ 条数据中检索)",
				oPaginate : {
					sFirst : "首页",
					sPrevious : "前一页",
					sNext : "后一页",
					sLast : "尾页"
				},
				sZeroRecords : "没有检索到数据"
			}
		})
	} else {
		operate_record_table.fnClearTable(false);
		operate_record_table.api().ajax.reload()
	}
}
function sms_record_table_fill() {
	if (!$.fn.dataTable.isDataTable("#content_sms_record_table")) {
		operate_record_table = $("#content_sms_record_table").dataTable({
			bPaginate : false,
			bLengthChange : false,
			bFilter : false,
			bSort : false,
			bInfo : false,
			bJQueryUI : false,
			bProcessing : true,
			bServerSide : true,
			sAjaxSource : "/icsBizSupport/customerSmsHis.do",
			sServerMethod : "POST",
			fnServerData : retrieveData,
			aoColumns : [ {
				sName : "No"
			}, {
				sName : "operateTime"
			}, {
				sName : "operator"
			}, {
				sName : "centent"
			}, {
				sName : "mobile"
			} ],
			oLanguage : {
				sLengthMenu : "每页显示 _MENU_ 条记录",
				sZeroRecords : "抱歉， 没有找到",
				sInfo : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				sInfoEmpty : "没有数据",
				sInfoFiltered : "(从 _MAX_ 条数据中检索)",
				oPaginate : {
					sFirst : "首页",
					sPrevious : "前一页",
					sNext : "后一页",
					sLast : "尾页"
				},
				sZeroRecords : "没有检索到数据"
			}
		})
	}
}
function remark_record_table_fill() {
	if (!$.fn.dataTable.isDataTable("#content_remark_record_table")) {
		operate_record_table = $("#content_remark_record_table").dataTable({
			bPaginate : false,
			bLengthChange : false,
			bFilter : false,
			bSort : false,
			bInfo : false,
			bJQueryUI : false,
			bProcessing : true,
			bServerSide : true,
			sAjaxSource : "/icsBizSupport/customerRemarkHis.do",
			sServerMethod : "POST",
			fnServerData : retrieveData,
			aoColumns : [ {
				sName : "No"
			}, {
				sName : "operateTime"
			}, {
				sName : "operator"
			}, {
				sName : "remark"
			}, {
				sName : "otherRemark"
			} ],
			oLanguage : {
				sLengthMenu : "每页显示 _MENU_ 条记录",
				sZeroRecords : "抱歉， 没有找到",
				sInfo : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				sInfoEmpty : "没有数据",
				sInfoFiltered : "(从 _MAX_ 条数据中检索)",
				oPaginate : {
					sFirst : "首页",
					sPrevious : "前一页",
					sNext : "后一页",
					sLast : "尾页"
				},
				sZeroRecords : "没有检索到数据"
			}
		})
	}
}
function email_record_table_fill() {
	if (!$.fn.dataTable.isDataTable("#content_email_record_table")) {
		$("#content_email_record_table").dataTable({
			bPaginate : false,
			bLengthChange : false,
			bFilter : false,
			bSort : false,
			bInfo : false,
			bJQueryUI : false,
			bProcessing : true,
			bServerSide : true,
			sAjaxSource : "/icsBizSupport/customerEmailHis.do",
			sServerMethod : "POST",
			fnServerData : retrieveData,
			aoColumns : [ {
				sName : "No"
			}, {
				sName : "operateTime"
			}, {
				sName : "operator"
			}, {
				sName : "centent"
			} ],
			oLanguage : {
				sLengthMenu : "每页显示 _MENU_ 条记录",
				sZeroRecords : "抱歉， 没有找到",
				sInfo : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				sInfoEmpty : "没有数据",
				sInfoFiltered : "(从 _MAX_ 条数据中检索)",
				oPaginate : {
					sFirst : "首页",
					sPrevious : "前一页",
					sNext : "后一页",
					sLast : "尾页"
				},
				sZeroRecords : "没有检索到数据"
			}
		})
	}
}
function showCheckPage(b) {
	var button = $(b);
	var detailId = button.data("detailid");
	var handleOrderId = button.data("handleorderid");
	var data = {
		detailId : detailId,
		handleOrderId : handleOrderId
	};
	var tmplate_html = template("content_check_tab", data);
	$("#checkModal").find(".modal-body").html(tmplate_html);
	$("#checkModal").modal("show").css("width", "auto");
	operate_record_table_fill();
	var w = $("#checkModal").width();
	if (w != "undefined" && w > 0) {
		w = w / 2;
		$("#checkModal").css("margin-left", "-" + w + "px")
	}
	$("#check_info_tab a").click(function(e) {
		e.preventDefault();
		var a_id = $(e.target).attr("id");
		if (a_id == "operate_record_a") {
			operate_record_table_fill()
		} else {
			if (a_id == "remark_record_a") {
				remark_record_table_fill()
			} else {
				if (a_id == "sms_record_a") {
					sms_record_table_fill()
				} else {
					if (a_id == "email_record_a") {
						email_record_table_fill()
					}
				}
			}
		}
		$(this).tab("show");
		var w = $("#checkModal").width();
		if (w != "undefined" && w > 0) {
			w = w / 2;
			$("#checkModal").css("margin-left", "-" + w + "px")
		}
	})
}
$(function() {
	$("#unhandle_orderList").dataTable({
		bPaginate : false,
		bLengthChange : false,
		bFilter : false,
		bSort : true,
		bInfo : false,
		bJQueryUI : false,
		oLanguage : {
			sLengthMenu : "每页显示 _MENU_ 条记录",
			sZeroRecords : "抱歉， 没有找到",
			sInfo : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			sInfoEmpty : "没有数据",
			sInfoFiltered : "(从 _MAX_ 条数据中检索)",
			oPaginate : {
				sFirst : "首页",
				sPrevious : "前一页",
				sNext : "后一页",
				sLast : "尾页"
			},
			sZeroRecords : "没有检索到数据"
		}
	});
	$("#search").on(
			"click",
			function() {
				var importTime_from = $.trim($("#importTime_from").val());
				var importTime_to = $.trim($("#importTime_to").val());
				var importTime_from_date = new Date(importTime_from);
				var importTime_to_date = new Date(importTime_to);
				if (importTime_from_date > importTime_to_date) {
					support_alert("订单开始时间不能大于截止时间");
					return false
				}
				var createTime_from = $.trim($("#createTime_from").val());
				var createTime_to = $.trim($("#createTime_to").val());
				var createTime_from_date = new Date(createTime_from);
				var createTime_to_date = new Date(createTime_to);
				if (createTime_from_date > createTime_to_date) {
					support_alert("订单提交时间不能大于截止时间");
					return false
				}
				$("#customerUnhandleForm").attr("action",
						"/icsBizSupport/customerUnhandleOrderList.do");
				$("#customerUnhandleForm").submit();
				return true
			});
	$("#activityID").chosen().change(
			function(e) {
				$("#batchId").val("");
				var activityID = $(this).val();
				$.ajax({
					type : "post",
					dataType : "json",
					data : "activityID=" + activityID + "&type=batchNo",
					url : "/icsBizSupport/game/customService.do",
					success : function(result) {
						var batchArray = new Array();
						var Str = "<option value=''>所有批次</option>";
						batchArray.push(Str);
						$.each(result, function(index, batchObj) {
							var batchNo = batchObj.batchNo;
							var htmlStr = "<option value=" + batchNo + ">"
									+ batchNo + "</option>";
							batchArray.push(htmlStr)
						});
						$("#batchId").html(batchArray.join(""))
					}
				})
			});
	$("#handleModal").on("hidden", function() {
		var modal = $(this);
		modal.find(".modal-body").html("")
	});
	$("#checkModal").on("hidden", function() {
		var modal = $(this);
		modal.find(".modal-body").html("")
	})
});