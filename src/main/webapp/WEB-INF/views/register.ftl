<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="${ctx}/assets/css/icons.css" rel="stylesheet" />
        <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${ctx}/assets/css/main.css" rel="stylesheet" />
    </head>
    <body class="register-page">
        <!-- Start #register -->
        <div id="register" class="animated bounceIn">
            <div class="register-wrapper">
                <ul id="myTab" class="nav nav-tabs nav-justified bn">
                    <li>
                        <a href="#register" data-toggle="tab">注册</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content bn">
                    <div class="tab-pane fade active in" id="log-in">
                        <form class="form-horizontal mt10" id="register-form">
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="text" id="userName" class="form-control left-icon" placeholder="Your username ...">
                                    <i class="ec-user s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="password" id="password" class="form-control left-icon" placeholder="Your password ...">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="trueName" id="trueName" class="form-control left-icon" placeholder="Your trueName ...">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="email" id="email" class="form-control left-icon" placeholder="Your email ...">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-12">
                                    <input type="phone" id="phone" class="form-control left-icon" placeholder="Your phone ...">
                                    <i class="ec-locked s16 left-input-icon"></i>
                                </div>
                            </div>
                            <div class="form-group">
                                <!-- col-lg-12 end here -->
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-4">
                                    <!-- col-lg-12 start here -->
                                    <button class="btn btn-success pull-right" type="button" id="registerBtn">注册</button>
                                </div>
                                <!-- col-lg-12 end here -->
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- End #.register-wrapper -->
        </div>
    </body>
    <script src="${ctx}/highcharts4/jquery-1.8.3.min.js" ></script>
    <script src="${ctx}/js/jquery.cookie.js" ></script>
    <script>
    	$(document).ready(function(){
    		$("#registerBtn").click(function() {
    			var userName = $("#userName").val();
    			if (userName == null || userName.trim().length == 0) {
    				alert("请输入用户名");
    				return;
    			}
    			var password = $("#password").val();
    			if (password == null || password.trim().length == 0) {
    				alert("请输入密码");
    				return;
    			}
    			var trueName = $("#trueName").val();
    			if (trueName == null || trueName.trim().length == 0) {
    				alert("请输入姓名");
    				return;
    			}
    			var email = $("#email").val();
    			if (email == null || email.trim().length == 0) {
    				alert("请输入邮箱");
    				return;
    			}
    			var phone = $("#phone").val();
    			if (phone == null || phone.trim().length == 0) {
    				alert("请输入手机号");
    				return;
    			}
    			$.post("${ctx}/user/register", {userName:userName, password:password,trueName:trueName,email:email,phone:phone}, function(resp) {
    				if (resp.resultCode == 200) {
    					alert(resp.resultMsg);
    				} else {
    					alert(resp.resultMsg);
    					window.location.href = "${ctx}/index"
    				}
    			});
    		});
    	})
    
    </script>
    
    
</html>