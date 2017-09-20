$(document).ready(function(){
	$("#loginBtn").click(function(){
		
		var $userCode = $("#userCode").val();
		var $password = $("#password").val();
		if($userCode == "" && $password == ""){
			var msgHtml = "<font >用户名和密码不可为空！</font>"
			$("#errorPrompt").show();
			$("#errorPrompt").text("");
			$("#errorPrompt").append(msgHtml);
		}else if($userCode ==""){
			
			var msgHtml2 = "<font >用户名不可为空！</font>"
			$("#errorPrompt").show();
			$("#errorPrompt").text("");
			$("#errorPrompt").append(msgHtml2);
		}else if($password == ""){
			var msgHtml3 = "<font >密码不可为空！</font>"
			$("#errorPrompt").show();
			$("#errorPrompt").text("");
			$("#errorPrompt").append(msgHtml3);
		}else{
			$.ajax({
				dataType : 'json',
				type : 'POST',
				url : "User/findLoginUser",
				data : $("#loginForm").serialize(),
				cache : false,// 防止缓存
				async : false,
				success : function(json) {
					if(json.length == 1){
						$("#loginForm").submit();
					}else{
						var msgHtml = "<font >用户名或密码不正确！</font>"
						$("#errorPrompt").show();
						$("#errorPrompt").text("");
						$("#errorPrompt").append(msgHtml);
					}
				}
			});
		}
		
	});
	
	$("#userCode").blur(function(){
		var $userCode = $("#userCode").val();
		if($userCode != ""){
			$("#errorPrompt").hide();
		}
	});

	$("#password").blur(function(){
		var $password = $("#password").val();
		if($password != ""){
			$("#errorPrompt").hide();
		}
	});
});
