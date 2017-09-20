var System = {
		init : function (){
			var editForm = $("#queryForm");    //新增或者修改的表单
			
			var grid = new Datatable();
			//获取表单的所有查询条件

		    //ajaxForm提交参数
		    var ajaxFormOptions = { 
		        beforeSubmit:  showRequest,   // 表单提交前被调用的回调函数 
		        success:       showResponse   // 表单成功提交后调用的回调函数
		    }; 
		    
		    //绑定表单提交事件处理器 
		    editForm.submit(function() { 
		        $(this).ajaxSubmit(ajaxFormOptions); 
		        // 为了防止普通浏览器进行表单提交和产生页面导航（防止页面刷新）返回false 
		        return false; 
		    }); 
		    
		    //validate校验参数
		    var validateOptions = {
		    		errorElement: 'span',
		    		errorClass: 'help-block', //设置提示消息的class
		    		rules: {  // 自定义校验规则
		    			tax: {
		        			required: true,
		        			number:true,
		        		},
//		        		oneStage:{
//		        			required: true,
//		        			number:true,
//		        		},
//		        		twoStage:{
//		        			required: true,
//		        		},
		        		fourStage:{
		        			required: true,
		        		},
		        		roomRatio:{
		        			required: true,
		        		},
		        		employRatio:{
		        			required: true,
		        			number:true,
		        		},
		        	},
		        	
		        	messages: {  // 自定义提示消息
		        		tax: {
		        			required: "请输入比例",
		        			number:"请输入数字"
		        		},
//		        		oneStage: {
//		        			required: "请输入比例",
//		        			number:"请输入数字"
//		        		},
//		        		twoStage: {
//		        			required: "请输入比例",
//		        		},
		        		fourStage:{
		        			required: "请输入比例",
		        		},
		        		roomRatio:{
		        			required: "请输入比例",
		        		},
		        		employRatio:{
		        			required: "请输入比例",
		        			number:"请输入数字"
		        		},
		        	},
		        	
		        	invalidHandler: function (event, validator) { //表单提交错误时             
		                //success.hide();
		                //error.show();
		            },
		            
		        	highlight: function (element) { // 设置错误提示消息高亮
		                $(element).closest('.form-group').removeClass('has-success').addClass('has-error'); 
		            },

		            unhighlight: function (element) { 
		                $(element).closest('.form-group').removeClass('has-error'); 
		            },

		            success: function (label) {
		                label.closest('.form-group').removeClass('has-error').addClass('has-success'); 
		            }
		    };
		    
		    var validate = editForm.validate(validateOptions);
		    
		    //表单提交前 
		    function showRequest(formData, jqForm, options) { 
		    	//beforeSubmit回调函数带三个调用参数：数组形式的表单数据，jQuery表单对象，以及传入ajaxForm/ajaxSubmit中的Options对象。
		        var result = validate.form(); //表单校验是否通过，通过返回true，也可使用方法jqForm.valid()
		        return result;
		    };
		    //表单成功提交后 
		    function showResponse(responseText, statusText)  { 
		    		$(".form-group").removeClass('has-error').removeClass('has-success');
		    		if(responseText=="true"){
		    			$("#manageFlag").html("设置成功");
		    		}else{
		    			$("#manageFlag").html("设置失败,请稍后再试");
		    		}
		    		$("#managerModal").modal('show');
		    };
		     
		},
		receiverInit : function(){
			var url="/king/User/queryReceiverUser";
		    $.ajax({
	    		 url:url,
	    		 async:false,
	    		 type: "POST", 
	    		 data:$("#saveRoomForm").serialize(),
	    		 success: function(data){
	    			 var userList = data.userList;
	    			 if(typeof(userList) != "undefined"){
	    				 var htmlroom = "";
	    				 var htmlgoods = "";
	    				 var htmlfood = "";
	    				 var context ="";
	    				 $.each(userList,function(i,e){
	    					 if(e.receiverType=="1"){
	    						 	context = "<li style='text-align:center'><a>"+e.userName+"</a> </li>";
									htmlroom = htmlroom + context;
	    					 }else if(e.receiverType=="2"){
	    						 context = "<li style='text-align:center'><a>"+e.userName+"</a> </li>";
	    						 	htmlgoods = htmlgoods + context;
									
	    					 }else if(e.receiverType=="3"){
	    						 	context = "<li style='text-align:center'><a>"+e.userName+"</a> </li>";
	    						 	htmlfood = htmlfood + context;
	    					 }
	    				 });
	    				 $("#htmlroom").html(htmlroom);
	    				 $("#htmlgoods").html(htmlgoods);
	    				 $("#htmlfood").html(htmlfood);
	    			 }else{
	    				 alert("系统繁忙,请稍后再试");
	    			 }
	    		 }
	    	});
		},
		showRoomModal : function(e){
			$("#succe").addClass("display");
			$("#type").val(e);
			var url="/king/User/queryUserByIsSystem";
		    $.ajax({
	    		 url:url,
	    		 async:false,
	    		 type: "POST", 
	    		 data:{type:e},
	    		 success: function(data){
	    			 var userList = data.userList;
	    			 if(typeof(userList) != "undefined"){
	    				 var html = "";
	    				 var checkedList = data.checkedList;
	    				 $.each(userList,function(i,e){
	    					 var checked = ""
	    					 $.each(checkedList,function(s,p){
	    						 if(p.userId == e.userId){
	    							 checked = "checked"
	    						 }
		    				 });
	    					 var context = "<div class='col-md-3 col-sm-3'>"+
												"<span style='display:inline-block;width:100%'><input type='checkbox' id ='"+e.userId+"' "+checked+" value='"+e.userId+"' name='userId' /><span>"+e.userName+"</span></span>"+
											"</div>"
								html = html + context;
	    				 });
	    				 $("#roomUserList").html(html);
	    				 $('#addRoomModal').modal('show');
	    			 }else{
	    				 alert("系统繁忙,请稍后再试");
	    			 }
	    		 }
	    	});
		},
		saveSetting : function(){
			var url="/king/User/saveReceiverUser";
		    $.ajax({
	    		 url:url,
	    		 async:false,
	    		 type: "POST", 
	    		 data:$("#saveRoomForm").serialize(),
	    		 success: function(data){
	    			 var flag = data.flag;
	    			 if(flag == "true"){
	    					$("#succe").removeClass("display");
	    					setTimeout(function(){
								$('#addRoomModal').modal('hide');
								$("#succe").addClass("display");
							},2000);
	    					System.receiverInit();
	    			 }else{
	    				 alert("系统繁忙,请稍后再试");
	    			 }
	    		 }
	    	});
		
		}
}
