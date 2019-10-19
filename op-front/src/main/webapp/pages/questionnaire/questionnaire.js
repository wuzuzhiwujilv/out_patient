var datagrid;
  $(function() {
	datagrid = $("#list").datagrid({
		url : getRootPath() + '/questionnaire/getQuestionnaireRecord',
		width : "100%",
		height : "450px",
		border : false,
		fit : true,
		rownumbers : true,
		singleSelect : true,
		pageSize : 20,
		pageList : [ 20, 30, 50 ],
		pagination : true,
		nowrap : true,
		striped : true,
		resizeHandle : 'right',
		frozenColumns : [ [ {
			field : 'name',
			title : '姓名',
			width : "10%"
		}, {
			field : 'idCard',
			title : '身份证号',
			width : '10%'
		} ] ],
		columns : [ [ {
			field : 'height',
			title : '身高',
			width : "10%"
		}, {
			field : 'weight',
			title : '体重',
			width : '10%'
		},{
			hidden : true,
			field : 'id'
		}, {
			field : 'levelOfFather',
			title : '父亲教育水平',
			width : '10%'
		},{
			field : 'levleOfMother',
			title : '母亲教育水平',
			width : '10%'
		}, {
			field : 'incomeLevel',
			title : '收入',
			width : '10%'
		}, {
			field : 'deliveryMod',
			title : '分娩方式',
			width : '10%'
		}, {
			field : 'dateOfPregnancy',
			title : '生育年龄',
			width : '10%'
		},{
			field : 'milkTime',
			title : '母乳时间',
			width : '10%'
		},{
			field : 'medicalHistory',
			title : '孕期病史',
			width : '10%'
		},{
			field : 'dateOfOutsite',
			title : '户外时间',
			width : '10%'
		},{
			field : 'dateOfReader',
			title : '读书时间',
			width : '10%'
		},{
			field : 'dateOfHomework',
			title : '作业时间',
			width : '10%'
		},{
			field : 'illumination',
			title : '照明情况',
			width : '10%'
		},{
			field : 'drinkMilK',
			title : '孩子喝牛奶情况',
			width : '10%'
		},{
			field : 'sleepTime',
			title : '睡眠时间',
			width : '10%'
		},{
			field : 'ifFatherMyopia',
			title : '父亲是否近视',
			width : '10%'
		},{
			field : 'ifFatherHighMyopia',
			title : '父亲是否高度近视',
			width : '10%'
		},{
			field : 'ifMotherMyopia',
			title : '母亲是否近视',
			width : '10%'
		},{
			field : 'ifMotherHighMyopia',
			title : '母亲是否高度近视',
			width : '10%'
		},{
			field : 'ifmoke',
			title : '孕期是否吸烟',
			width : '10%'
		},{
			field : 'ifecondSomke',
			title : '孕期是否吸二手烟',
			width : '10%'
		},{
			field : 'getUpTime',
			title : '起床时间',
			width : '10%'
		},{
			field : 'durationOfNap',
			title : '午休时长',
			width : '10%'
		},{
			field : 'durationSleep',
			title : '一天睡眠时长',
			width : '10%'
		},{
			field : 'pcTime',
			title : '玩电脑时间',
			width : '10%'
		},{
			field : 'mobileTime',
			title : '玩手机时间',
			width : '10%'
		},{
			field : 'ifSport',
			title : '是否运动',
			width : '10%'
		},{
			field : 'typeOfSport',
			title : '运动类型',
			width : '10%'
		},{
			field : 'timeOfSprot',
			title : '运动时间',
			width : '10%'
		},{
			field : 'childbearingAge',
			title : '生育年龄',
			width : '10%'
		},{
			field : 'tvdistance',
			title : '电视距离',
			width : '10%'
		}] ],
		onRowContextMenu : function(e, rowIndex, rowData) { // 右键时触发事件
			// 三个参数：e里面的内容很多，真心不明白，rowIndex就是当前点击时所在行的索引，rowData当前行的数据
			e.preventDefault(); // 阻止浏览器捕获右键事件
			$(this).datagrid("clearSelections"); // 取消所有选中项
			$(this).datagrid("selectRow", rowIndex); // 根据索引选中该行
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY
			});
			e.preventDefault();
		},
		toolbar : "#toolbar"
	});
	// $('#examDateString').datebox('setValue', getCurentDateStr());
	$('#examDateString').datebox('calendar').calendar(
			{
				validator : function(date) {
					var now = new Date();
					var d1 = new Date(now.getFullYear(), now.getMonth(), now
							.getDate());
					return date > d1;
				}
			});
});
function openAddDlg() {
	initAddFm();
	$("#add_dlg").dialog({
		title : "病史确认",
		buttons : [ {
			text : '保存',
			iconCls : 'icon-ok',
			handler : function() {
				submitAdd();
			}
		} ]
	}).dialog('open');
}
function initAddFm() {
	$('#add_fm').form('clear');
	$("#status_select").combobox('select', '10');
}
function submitAdd() {
	$('#add_fm').form('submit', {
		url : getRootPath() + "/questionnaire/addForm",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var data = eval('(' + data + ')');
			if (data.success) {
				$('#add_dlg').dialog('close');
				$('#add_fm').form('clear');
				$('#classDg').datagrid('reload');
				message('添加成功');
				$('#list').datagrid('reload');
			} else {
				warn(data.msg);
			}
		}
	});

}

function doSearch() {
	var name = $("#project_name").textbox('getValue');
	var school_id = $("#school_id").combobox('getValue');
	var status = $("#status").textbox('getValue');
	var area_id = $("#area_id").combobox('getValue');
	$('#list').datagrid('load', {
		"name" : name,
		"school_id" : school_id,
		"status" : status,
		"area_id" : area_id
	});
}

// 编辑基础运价
function edit() {
	initAddFm();
	$("#statusDiv").show();
	var row = $('#list').datagrid('getSelected');
	if (row) {
		$("#add_fm").form("load",  getRootPath() + "/questionnaire/updateQuestionnaire?id=" + row.id);
		$('#add_dlg').dialog({
			title : "编辑区域信息",
			buttons : [ {
				text : '更新',
				iconCls : 'icon-ok',
				handler : function() {
					update();
				}
			} ]
		}).dialog('open');
	} else {
		msgShow("系统消息", "请单击选择一行后操作！", "error");
	}
}

function update() {
	$('#add_fm').form('submit', {
		url : getRootPath() + "/questionnaire/updateQuestionnaire",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var data = eval('(' + data + ')');
			if (data.success) {
				$('#add_dlg').dialog('close');
				$('#list').datagrid('reload');
				$('#add_fm').form('clear');
				message('更新成功');
			} else {
				warn(data.msg);
			}
		}
	});
}
// 删除
function del() {
	var row = $('#list').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除吗?', function(r) {
			if (r) {
				$.post(getRootPath() + "/questionnaire/deleteQuestionnaire", {
					id : row.id
				}, function(data) {
					if (data.success) {
						$('#list').datagrid('reload');
						message('删除成功');
					} else {
						warn(data.msg);
					}
				}, 'json');
			}
		});
	} else {
		msgShow("系统消息", "请单击选择一行后操作！", "error");
	}
}

function exportSpot() {
	var row = $("#list").datagrid("getSelected");
	if (row == null) {
		warn("请选择一条记录");
		return;
	}
	load("导出spot文件。。。");
	$('#exportSpot').form('submit', {
		url : getRootPath() + '/project/exportSpot?project_id=' + row.id,
		success: function(data){
			var data = eval('(' + data + ')');
			if (!data.success) {
				warn(data.msg);
			}
		}
	});
	disLoad();
}

function exportProject() {
	var row = $("#list").datagrid("getSelected");
	if (row == null) {
		warn("请选择一条记录");
		return;
	}
	load("导出筛查列表。。。");
	$('#exportProject').form('submit', {
		url : getRootPath() + '/project/exportProject?project_id=' + row.id,
		success: function(data){
			var data = eval('(' + data + ')');
			if (!data.success) {
				warn(data.msg);
			}
		}
	});
	disLoad();
}