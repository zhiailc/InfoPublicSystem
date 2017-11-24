$(document).ready(function(){
	$("#registerBtn").click(function(){
		window.location.href = "${ctx}/register";
	})
})

$(document).ready(function(){
	$("#loginBtn").click(function(){
		var userName = $("#userName").val();
		var password = $("#password").val();
		if(userName == null || userName.trim().length == 0){
			alert("用户名不能为空");
			return;
		}
		if(password == null || password.trim().length == 0){
			alert("密码不能为空");
			return;
		}
		$.post(
			"${ctx}/user/login",
			{userName:userName,password:password},
			function(resp){
				if(resp.resultCode == 200){
					alert(resp.resultMsg);
				} else {
					$.cookie("userId",resp.result.userIdStr);
					$.cookie("userName",resp.result.userName);
					$.cookie("trueName",resp.result,truename);
					window.location.href = "${ctx}/main";
				}
			}
		)
	})
})