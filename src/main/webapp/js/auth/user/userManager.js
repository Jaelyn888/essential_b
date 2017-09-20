var User = {
		showModal : function () {
 			$("#warning").addClass("display");
 			$("#succe").addClass("display");
			$("#saveUserForm")[0].reset();  //清除表单元素
			$('.help-block').remove();  //移除提示信息
			$("#title").html("新增");
			$(".form-group").removeClass('has-error').removeClass('has-success');
			$("#saveUserForm .form-control").removeAttr("disabled","disabled");
			$("#saveBTN").removeClass("display");
			$('#userAddModal').modal('show');
			$("#userId").val("");
			$("#temp").val("");
			$("#employeeNo").val(null);
		},
		initSaveForm : function () {
			$("#saveUserForm")[0].reset();
			$('#userAddModal').modal('hide');
		},
		init : function(){

			var queryForm = $("#queryForm");
			var table = $("#data_table");
			var editForm = $("#saveUserForm");    //新增或者修改的表单
			var ajaxUrl = "user/findAllUser";
			
			var grid = new Datatable();
			//获取表单的所有查询条件
			grid.setFormParams(queryForm);


		    grid.init({
		        src: table,
		        onSuccess: function (grid) {
		            // execute some code after table records loaded
		        },
		        onError: function (grid) {
		            // execute some code on network or other general error  
		        },
		        loadingMessage: 'Loading...',
		        dataTable: {
		        	
		            "bStateSave": false, // save datatable state(pagination, sort, etc) in cookie.

		            "ajax": {
		            	"url": ajaxUrl,
		            },
		            "columns": [
								{ 
									"data": "userId",
									"title": "id",
									"visible": false
								},
		                        { 
		                        	"data": "userName",
		                        	"title": "姓名",
		                        	"orderable": false
		                        },
		                        { 
		                        	"data": "attr1",
		                        	"title": "积分",
		                        },
		                        { 
		                        	"data": "telephone",
		                        	"title": "手机号",
		                        },
		                        { 
		                        	"data": "sex",
		                        	"title": "性别",
		                        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
		                                if ( sData == "1" ) {
		                                    $(nTd).html("男");
		                                 }else if ( sData == "0" ) {
		                                      $(nTd).html("女");
		                                 }else{
		                                	 $(nTd).html("未知");
		                                 }
		                                }
		                        },
		                        { 
		                        	"data": "email",
		                        	"title": "邮箱",
		                        },
		                        { 
		                        	"data": "isSysAdm",
		                        	"title": "是否店员",
		                        	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
		                                if ( sData == "0" ) {
		                                    $(nTd).html("否");
		                                 }else if ( sData == "1" ) {
		                                      $(nTd).html("是");
		                                 }else{
		                                	 $(nTd).html("未知");
		                                 }
		                                }
		                        },
		                        { 
		                        	"data": "createDate",
		                        	"title": "创建日期",
		                            "mRender":function(data, type, full){
		                                	return data.substring(0,19);
		                                }	
		                        },
		                        {
		                        	"data": null,
		                        	"defaultContent": "<a class=\"btn btn-success mid-btn\" href=\"#\"><i class=\"glyphicon glyphicon-zoom-in icon-white\"></i> 详细</a> "
		                        		 			+ "<a class=\"btn btn-info mid-btn\" href=\"#\"><i class=\"glyphicon glyphicon-edit icon-white\"></i> 编辑</a> "
		                        		 			+ "<a class=\"btn btn-danger mid-btn\" href=\"#\"><i class=\"glyphicon glyphicon-trash icon-white\"></i> 删除</a> ",
		                        	"title": "操作"
		                        }
		                    ],
		            "order": [
		                [1, "desc"]
		            ] 
		        }
		    });
		    
		    //点击查询按钮
		    $("#queryBtn").click(function(){ 
		    	grid.submitFilter(queryForm);
		    });
		    
		    //详细 修改 给模态框赋值
		    function  assignment (e,element){
		    	e.preventDefault();
				$("#warning").addClass("display");
				$("#succe").addClass("display");
		    	$('.help-block').remove();  //移除提示信息
		    	$(".form-group").removeClass('has-error').removeClass('has-success');
		    	var tr = element.parents("tr"); 
		    	var row = grid.getDataTable().row(tr);  //表格行对象
		    	var data = row.data();
				var url="user/showUserDetail";
			    $.ajax({
		    		 url:url,
		    		 async:false,
		    		 type: "POST", 
		    		 dataType:"json",
		    		 data:{id:data.userId},
		    		 success: function(data){
		    			 var user = data.user;
		    			 if(typeof(user) != "undefined"){
		    				 $('#userAddModal').modal('show');
		    				 $("#userName").val(user.userName);
							 $("#userCode").val(user.userCode);
							 $("#email").val(user.email);
							 $("#telephone").val(user.telephone);
							 $("#isSysAdm").val(user.isSysAdm);
							 $("#headImage").val(user.headImage);
					    	 $("#sex").val(user.sex);
					    	 $("#temp").val(user.temp);
					    	 $("#userId").val(user.userId);
					    	 $("#attr1").val(user.attr1);
					    	 $("#attr2").val(user.attr2);
					    	 $("#attr3").val(user.attr3);
					    	 $("#attr4").val(user.attr4);
					    	 $("#employeeNo").val(user.employeeNo);
					    	 $("#createDate").val(user.createDate);
					    	 $("#updateDate").val(user.updateDate);
					    	 $("#createUser").val(user.createUser);
					    	 $("#password").val(user.password);
					    	 $("#userCode").attr("readonly","readonly");
		    			 }else{
		    				 alert("系统繁忙,请稍后再试");
		    			 }
		    		 }
		    	});
		    }
		    
		    //点击详细按钮
		    table.on("click",".btn-success",function(e){
		    	var element = $(this);
		    	assignment(e,element);
		    	$("#title").html("详细");
			   	$("#saveUserForm .form-control").attr("disabled","disabled");
			   	$("#saveBTN").addClass("display");
		    });
		    
		    //点击编辑按钮
		    table.on("click",".btn-info",function(e){
		    	var element = $(this);
		    	$("#saveBTN").removeClass("display");
		    	$("#title").html("编辑");
		    	$("#saveUserForm .form-control").removeAttr("disabled","disabled");
		    	assignment(e,element);
		    });
		    
		    //点击删除按钮
		    table.on("click",".btn-danger",function(e){
		    	var tr = $(this).parents("tr"); 
		    	var row = grid.getDataTable().row(tr);  //表格行对象
		    	var data = row.data();
		    	$('#delModal').modal('show');
		    	$("#delId").val(data.userId);
		    	$("#delBtn").click(function(){
		    		var url="user/deleteUser";
		    	    $.ajax({
		        		 url:url,
		        		 async:false,
		        		 type: "POST", 
		        		 dataType:"json",
		        		 data:{userId:data.userId},
		        		 success: function(data){
		        			 $("#queryBtn").click();
		        			 $("#delAlreadyModal").modal("show");
		        			 $("#delTietle").val("删除成功！");
		        		 },
		        		 error: function(data){
		        			 $("#queryBtn").click();
		        			 $("#delAlreadyModal").modal("show");
		        			 $("#delTietle").val("系统繁忙，请稍后再试！");
		        		 }
		        	});
		    	});

		    });
		    
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
		        		userName: {
		        			required: true,
		        			minlength: 2,
		        			stringMaxLength: 15
		        		},
		        		userCode: {
		        			required: true,
		                    remote:{   
		                        url:"user/validateUser",   
		                        type:"post",   
		                        cache:false,
		                        dateType:"json",   
		                        data:{ 
		                        	userId:function(){  
		                          		return $("#userId").val();
		  	                        },
		                        	key:"userCode",
		                			value:function(){  
		                        		return $("#userCode").val();
			                        }
		                        } 
		                    }
		        		},
		        		email:{
		        			email: true
		        		},
		        		telephone:{
		        			number:true,
		        			minlength: 11,
		        			maxlength: 11,
		        		},
		        	},
		        	
		        	messages: {  // 自定义提示消息
		        		userName: {
		        			required: "请输入姓名"
		        		},
		        		userCode: {
		        			required: "请输入账号",
		        			remote:"账号已存在,请更换账号。"
		        		},
		        		email:{
		        			required: "请输出入邮箱",
		        			email:"清输入正确邮箱格式"
		        		},
		        		telephone:{
		        			required: "请输入手机号",
		        		}
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
					var info = $("#warning");
					var succe = $("#succe");
					if(responseText.flag=="userCodeRepeat"){
						$("#warningInfo").text("账号已存在,请更换账号名!");
						info.removeClass("display");
					}else if(responseText.flag=="userCodeRepeat-employeeNoRepeat"||responseText.flag=="employeeNoRepeat"){
						$("#warningInfo").text("用户已存在,请确认信息后再填写!");
						info.removeClass("display");
					}else if(responseText.flag=="userNull"){
						$("#warningInfo").text("用户信息填写不完整,请填写完整后再保存!");
						info.removeClass("display");
					}else if(responseText.flag=="true"){
						info.addClass("display");
						succe.removeClass("display");
						setTimeout(function(){
							$('#userAddModal').modal('hide');
							$("#saveUserForm")[0].reset();
							$("#queryForm")[0].reset();
							$("#queryBtn").click();
						},2000);
					}else if(responseText.flag=="repeat"){
						$("#warningInfo").text("该用户被已经被他人修改,请点击查询后再进行操作!");
						info.removeClass("display");
					}else{
						$("#warningInfo").text("系统暂时繁忙，请稍后再试!");
						info.removeClass("display");
					}
		    };
		}
}

