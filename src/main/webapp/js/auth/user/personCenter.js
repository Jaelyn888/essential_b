var Person = {
		managerUserAddress : function (e){
			window.location.href="/king/address/addAddress?userId="+e;
		},
		
		showOrderDetail : function (e){
			window.location.href="/king/order/queryOrderDetail?orderId="+e;
		},
		showRoomOrderDetail : function(e){
			window.location.href="/king/order/queryRoomOrderDetail?roomOrderId="+e;
		},
		returnRoomOrder : function(e){
			 if(confirm("确定要申请取消订单吗？"))
			 {
		    	var url="/king/order/returnRoomOrder";
			    $.ajax({
		    		 url:url,
		    		 async:false,
		    		 type: "POST", 
		    		 data:{roomOrderId:e,
		    			 status:"5"},
		    		 success: function(msg){
		    			 var flag = msg.flag;
		    			 if(flag == "success"){
		    				 alert("申请成功");
		    				 window.location.href="/king/order/returnOrder"
		    			 }else{
		    				 alert("系统繁忙,请稍后再试");
		    			 }
		    		 }
		    	});
			 }
		},
		returnGoodsOrder : function(e){
			 if(confirm("确定要申请退货吗？"))
			 {
		    	var url="/king/order/returnGoodsOrder";
			    $.ajax({
		    		 url:url,
		    		 async:false,
		    		 type: "POST", 
		    		 data:{orderId:e,
		    			 status:"5"},
		    		 success: function(msg){
		    			 var flag = msg.flag;
		    			 if(flag == "success"){
		    				 alert("申请成功");
		    				 window.location.href="/king/order/returnOrder"
		    			 }else{
		    				 alert("系统繁忙,请稍后再试");
		    			 }
		    		 }
		    	});
			 }
		},
		returnGoodsOrderDetail : function(e,p){
			 if(confirm("确定要申请退货吗？"))
			 {
		    	var url="/king/order/returnGoodsOrderDetail";
			    $.ajax({
		    		 url:url,
		    		 async:false,
		    		 type: "POST", 
		    		 data:{goodsId:e,
		    			 	orderId:p,
		    			 status:"5"},
		    		 success: function(msg){
		    			 var flag = msg.flag;
		    			 if(flag == "success"){
		    				 alert("申请成功");
		    				 window.location.href="/king/order/returnOrder"
		    			 }else{
		    				 alert("系统繁忙,请稍后再试");
		    			 }
		    		 }
		    	});
			 }
		},
		selectCity : function () {
			if($("#ProvinceID").val()!=""){
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/address/queryCityByProvinceCode",
	                datatype: "json", //传参的数据类型
	                async : false,
	                data: {provinceCode:$("#ProvinceID").val()}, //传过去的参数，格式为 变量名：变量值  
	                success: function (responsedata) { //若ajax处理成功后返回的信息 
	                    var apList = responsedata["cityList"];
	                    var context = "<option  value='' selected='selected'>城市选择</option>";
	                    var contextArea = "<option  value='' selected='selected' >区域选择</option>";
	                    $("#AreaID").html(contextArea);
	                    if(apList != null){
	                        $.each(apList,function(idx,item){
	                            var html="<option value='"+item["code"]+"'>"+item["name"]+"</option>";
	                            context = context + html;
	                        })
	                    $("#CityID").html(context);
	                        $('select').selectmenu('refresh', true); 
	                    }
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
		    }else{
		        var context = "<option  value='' selected='selected'>城市选择</option>";
		        $("#CityID").html(context);
		        $('select').selectmenu('refresh', true); 
		    }
		},
		//联动的区域
		selectArea:function (){
		    if($("#CityID").val()!=""){
		          $.ajax({
		                type: "post", //传参方式，get 或post
		                url: "/king/address/queryAreaByCityCode",
		                datatype: "json", //传参的数据类型
		                async : false,
		                data: {CityCode:$("#CityID").val()}, //传过去的参数，格式为 变量名：变量值  
		                success: function (responsedata) { //若ajax处理成功后返回的信息 
		                    var apList = responsedata["areaList"];
		                    var context = "<option  value='' selected='selected' >区域选择</option>";
		                    if(apList != null){
		                        $.each(apList,function(idx,item){
		                            var html="<option value='"+item["code"]+"'>"+item["name"]+"</option>";
		                            context = context + html;
		                        })
		                    $("#AreaID").html(context);
		                    $('select').selectmenu('refresh', true); 
		                    }
		                },
		                error: function (msg) { //若ajax处理失败后返回的信息
		                    alert("发送远程数据请求失败！");
		                }
		            });
		    }else{
		        var context = "<option  value='' selected='selected' >区域选择</option>";
		        $("#AreaID").html(context);
		        $('select').selectmenu('refresh', true); 
		    }
		},
		queryUserRelationByName : function(){
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/User/queryUserRelationByName",
	                datatype: "json", //传参的数据类型
	                data: {userName:$("#userName").val()}, //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
//	                	var list = data.listId;
//	                	$.each(list,function(i,e){
//		                	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
//		                	var treeNode = treeObj.getNodeByParam("name", "管理员", null);
//		                	treeNode.open = true;
//		                	treeObj.updateNode(treeNode);
//	                	})
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
	    
		},
		applySubmit : function (){
			var cash = $("#cash").html();
			var numerical = $("#numerical");
			var bankName = $("#bankName");
			var bankAccount = $("#bankAccount");
			var userName = $("#userName");
			var bankAddress = $("#bankAddress");
			if(numerical.val()==""){
				alert("申请提现金额不能为空");
				return;
			}
			if (!(/(^[1-9]\d*$)/.test(numerical.val()))){
				alert("请输入正整数");
				numerical.val("");
				return;
			}
			if (numerical.val()<50){
				alert("提现金额不能小于50元");
				numerical.val("");
				return;
			}
			if(Number(numerical.val())>Number(cash)){
				alert("可提现金额不足");
				numerical.val("");
				return;
			}
			if(bankName.val()==""){
				alert("开户银行不能为空");
				return;
			}
			if(bankAccount.val()==""){
				alert("银行账号不能为空");
				return;
			}
			if(userName.val()==""){
				alert("银行开户名不能为空");
				return;
			}
			if(bankAddress.val()==""){
				alert("开户行所在地不能为空");
				return;
			}
			
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/currency/saveCashApply",
	                datatype: "json", //传参的数据类型
	                data: $("#applyCashForm").serialize(), //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
	                	if(data.length == 17){
	                		alert("申请成功");
	                		 $("#applyCashForm")[0].reset();
	                		window.location.href="/king/User/personCenter";
	                	}else{
	                		alert("系统繁忙，稍后再试");
	                		 $("#applyCashForm")[0].reset();
	                		window.location.href="/king/User/personCenter";
	                	}
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
		},
		showCashApplyDetail : function(e){
			window.location.href="/king/currency/showCashApplyDetail?cashApplyId="+e;
		},
		addAddress : function(){
			var provinceID = $("#ProvinceID");	
			var cityID = $("#CityID");
			var areaID = $("#AreaID");
			var street = $("#street");
			var userName = $("#userName");
			var phone = $("#phone");
			
			if(provinceID.val() == "0"||provinceID.val() == ""){
				alert("请选择省份");
				return;
			}
			if(cityID.val() == "0"||cityID.val() == ""){
				alert("请选择城市");
				return;		
			}
			if(areaID.val() == "0"||areaID.val() == ""){
				alert("请选择区域");
				return;
			}
			if(street.val()==""){
				alert("请填写详细地址");
				return;
			}
			if(userName.val()==""){
				alert("请填写收货人");
				return;
			}
			if(phone.val()==""){
				alert("请填写联系电话");
				return;
			}
			if(!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(phone.val()))){
				alert("手机号码有误，请重新填写");
				phone.val("");
				return;
			}
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/address/saveAddress",
	                async:false,
	                datatype: "json", //传参的数据类型
	                data: $("#addAddressForm").serialize(), //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
	                	if(data.length  == 17){
	                		alert("保存成功");
	                		$("#addAddressForm")[0].reset();
	                		window.location.href="/king/User/personCenter";
	                	}else{
	                		alert("系统繁忙，稍后再试");
	                		$("#addAddressForm")[0].reset();
	                		window.location.href="/king/User/personCenter";
	                	}
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
		},
		addAddressAndShopping : function(){
			var provinceID = $("#ProvinceID");	
			var cityID = $("#CityID");
			var areaID = $("#AreaID");
			var street = $("#street");
			var userName = $("#userName");
			var phone = $("#phone");
			var cartType = $("#cartType");
			
			if(provinceID.val() == "0"||provinceID.val() == ""){
				alert("请选择省份");
				return;
			}
			if(cityID.val() == "0"||cityID.val() == ""){
				alert("请选择城市");
				return;		
			}
			if(areaID.val() == "0"||areaID.val() == ""){
				alert("请选择区域");
				return;
			}
			if(street.val()==""){
				alert("请填写详细地址");
				return;
			}
			if(userName.val()==""){
				alert("请填写收货人");
				return;
			}
			if(phone.val()==""){
				alert("请填写联系电话");
				return;
			}
			if(!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(phone.val()))){
				alert("手机号码有误，请重新填写");
				phone.val("");
				return;
			}
			
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/address/saveAddress",
	                datatype: "json", //传参的数据类型
	                data: $("#addAddressForm").serialize(), //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
	                	if(data.length  == 17){
	                		alert("保存成功");
	                		$("#addAddressForm")[0].reset();
	                		window.location.href="/king/shoppingCart/addOtherShoppingCartInfo?addressId="+data+"&cartType="+cartType.val();
	                	}else{
	                		alert("系统繁忙，稍后再试");
	                		window.location.href="/king/User/personCenter";
	                	}
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
		},
		delAddress : function(addressId){
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/address/updateAddressStatus",
	                datatype: "json", //传参的数据类型
	                data: {addressId:addressId,status:"-1"}, //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
	                	if(data.length == 17){
	                		alert("删除成功");
	                		window.location.href="/king/address/addressManage";
	                	}else{
	                		alert("系统繁忙，稍后再试");
	                		window.location.href="/king/address/addressManage";
	                	}
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
		},
		setAddressDefault : function(addressId){
	          $.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/address/updateAddressStatus",
	                datatype: "json", //传参的数据类型
	                data: {addressId:addressId,status:"1"}, //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
	                	if(data.length == 17){
	                		alert("设置成功");
	                		window.location.href="/king/address/addressManage";
	                	}else{
	                		alert("系统繁忙，稍后再试");
	                		window.location.href="/king/address/addressManage";
	                	}
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
		},
		checkSamePerson : function(){
			if($("#employeeNo").val()!=""){
				$.ajax({
	                type: "post", //传参方式，get 或post
	                url: "/king/User/checkSamePerson",
	                datatype: "json", //传参的数据类型
	                data: {employeeNo:$("#employeeNo").val()}, //传过去的参数，格式为 变量名：变量值  
	                success: function (data) {
	                	var userList = data.userList;
	                	if(userList.length == 0){
	                		$("#userName").val("");
	                		alert("查无此人，请输入正确微信昵称");
	                	}else if(userList.length == 1){
	                		$("#toId").val(userList[0].userId);
	                	}else{
	                		alert("系统错误");
	                	}
	                },
	                error: function (msg) { //若ajax处理失败后返回的信息
	                    alert("发送远程数据请求失败！");
	                }
	            });
			}
		},
		transferAccountSubmit : function(){
			var integral =$("#integral").html();
			var numerical = $("#numerical");
			var userName = $("#userName");
			if(userName.val()==""){
				alert("受赠人不能为空");
				return;
			}
			if(numerical.val()==""){
				alert("转赠积分不能为空");
				return;
			}
			if (!(/(^[1-9]\d*$)/.test(numerical.val()))){
				alert("转赠积分应当为正整数");
				numerical.val("");
				return;
			}
			if(Number(integral)<Number(numerical.val())){
				alert("可用积分不足");
				numerical.val("");
				return;
			}
			if(Number(numerical.val())<50){
				alert("转赠积分不能小于50");
				numerical.val("");
				return;
			}
			
			$.ajax({
                type: "post", //传参方式，get 或post
                url: "/king/User/transferAccount",
                datatype: "json", //传参的数据类型
                data: {toId:$("#toId").val(),numerical:$("#numerical").val()}, //传过去的参数，格式为 变量名：变量值  
                success: function (data) {
                	if(data == "true"){
                		alert("赠送成功");
                		$("#transferAccountForm")[0].reset();
                		window.location.href="/king/currency/transferAccountsManage";
                	}else{
                		alert("系统繁忙,请稍后再试");
                		window.location.href="/king/currency/transferAccountsManage";
                	}
                },
                error: function (msg) { //若ajax处理失败后返回的信息
                    alert("发送远程数据请求失败！");
                }
            });
		
		},
		productionCode : function(){
			$.ajax({
                type: "post", //传参方式，get 或post
                url: "/king/User/productionCode",
                datatype: "json", //传参的数据类型
                data: {}, //传过去的参数，格式为 变量名：变量值  
                success: function (data) {
                	var code = data;
                	if(data!="false"){
                		window.location.href="/king/User/openShop?code="+code;
                	}
                },
                error: function (msg) { //若ajax处理失败后返回的信息
                    alert("发送远程数据请求失败！");
                }
            });
		}
}
