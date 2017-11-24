<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="${ctx}/assets/css/icons.css" rel="stylesheet" />
        <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${ctx}/assets/css/main.css" rel="stylesheet" />
    </head>
    <body class="login-page">
        <!-- Start #login -->
        <div id="login" class="animated bounceIn">
            <div class="login-wrapper">
                <ul id="myTab" class="nav nav-tabs nav-justified bn">
                    <li>
                        <a href="#log-in" data-toggle="tab">登录</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content bn">
                    <div class="tab-pane fade active in" id="log-in">
                        <form class="form-horizontal mt10" id="login-form">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" id="userName" class="form-control left-icon" placeholder="Your username ...">
                                    <i class="ec-user s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="password" id="password" class="form-control left-icon" placeholder="Your password">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <!-- col-lg-12 end here -->
                                <div class="col-lg-3 col-md-6 col-sm-6 col-xs-4">
                                    <!-- col-lg-12 start here -->
                                    <button class="btn btn-success pull-right" type="button" id="registerBtn">注册</button>
                                </div>
                                <div class="col-lg-8 col-md-6 col-sm-6 col-xs-4">
                                    <!-- col-lg-12 start here -->
                                    <button class="btn btn-success pull-right" type="button" id="loginBtn">登录</button>
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- End #.login-wrapper -->
        </div>
    </body>
    <script src="${ctx}/highcharts4/jquery-1.8.3.min.js" ></script>
    <script src="${ctx}/js/jquery.cookie.js" ></script>
    <script>
   		 $(document).ready(function(){
			$("#registerBtn").click(function(){
				window.location.href = "${ctx}/register";
			})
		})
    </script>
    <script>
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
						$.cookie("trueName",resp.result.trueName);
						window.location.href = "${ctx}/main";
					}
				})
			})
		})
    </script>
</html>