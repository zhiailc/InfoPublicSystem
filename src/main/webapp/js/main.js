function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)) { // 如果有
        $("#tabs").tabs("select", text); // 选中页签
    }else{
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            content:content
        });
    }
}

// 退出系统
function logout() {
    $.messager.confirm("系统提示","您确定要退出系统吗？",function(r) {
        if (r) {
            $.removeCookie("userIdString");
            $.removeCookie("userName");
            $.removeCookie("trueName");
            window.location.href = "index";
        }
    });
}