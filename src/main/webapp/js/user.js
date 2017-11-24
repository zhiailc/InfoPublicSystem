function deleteUser(){
	var list = $("#dg").datagrid('getSelections');
	if(list.length == 0){
		$.messager.alert("系统提示","请选择所要删除的记录");
	}
	var idStr = [];
	for(var i = 0;i < list.length;i++){
		idStr.push(list[i].id);
	}
	var ids = idStr.join(",");
	$.messager.confirm("系统提示","<font color=red>你确定要删除" + list.length + "条数据吗？</font>",function(r){
		if(r){
			$.post("delete",{ids:ids},function(resp){
				if(resp.resultCode == 300){
					alert(resp.resultMsg);
					$("#dg").datagrid("reload");
				} else {
					alert(resp.resultMsg);
				}
			})
		}
	})
}
function openModifyDialog(){
	var list = $("#dg").datagrid('getSelections');
	if(list.length != 1){
		$.messager.alert("系统提示","请选择一条数据进行修改");
		return;
	}
	$("#dlg").dialog('open').dialog('setTitle',"修改用户");
	var user = list[0];
	$("#fm").form('load',user);
	$("#id").val(user.id);
}

function saveUser(){
	var id = $("#id").val();
	var url = "update";
	if(id == null || id.trim().length == 0){
		url = "add";
	}
	$("#fm").form("submit",{
		url:url,
		success:function(result){
			var result = JSON.parse(result);
			if(result.resultCode == 300){
				alert(result.resultMsg);
				resetValue();
				closeDialog();
				$("#dg").datagrid('reload');
			} else {
				alert(result.resultMsg);
			}
		}
	})
}

function resetValue(){
	$("#userName").val('');
	$("#password").val('');
	$("#phone").val('');
	$("#trueName").val('');
	$("#email").val('');
}

function closeDialog(){
	resetValue();
	$("#dlg").dialog('close');
}

function openAddDialog(){
	$("#dlg").dialog('open').dialog('setTitle',"创建新用户")
}

function searchUser() {
    $("#dg").datagrid('load', {
        "userName":$("#s_userName").val()
    });
}