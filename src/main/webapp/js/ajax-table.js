$(document).ready(function () {
	
	var queryForm = $("#queryForm");  //查询表单
	var table = $("#ajaxTable");      //表格
	var ajaxUrl = "queryAjaxTable";   //列表查询的ajax地址
	var editForm = $("#userForm");    //新增或者修改的表单
	var editModal = $("#userModal");  //弹出框
	
	var grid = new Datatable();
	
	//设置表单的所有元素为查询条件
	grid.setFormParams(queryForm);

    grid.init({
        src: table,
        onSuccess: function (grid) {
            // execute some code after table records loaded
        },
        onError: function (grid) {
            // execute some code on network or other general error  
        },
        loadingMessage: '加载中...',
        dataTable: { // 这里定义datatables设置 

            "bStateSave": false, // 是否在cookie端存储datatable的状态(如页码, 排序等)

            "ajax": {
            	"url": ajaxUrl,
            },
            "columns": [
                { 
                	"data": "userName",
                	"title": "姓名",
                	"orderable": false
                },
                { 
                	"data": "userCode",
                	"title": "账号"
                },
                { 
                	"data": "sex",
                	"title": "性别"
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
                [1, "asc"]
            ] // 第一列设置为默认排序(升序)
        }
    });
    
    //点击编辑按钮
    table.on("click", ".btn-info", function (e) {
    	e.preventDefault();
    	var tr = $(this).parents("tr"); 
    	var row = grid.getDataTable().row(tr);  //表格行对象
    	var data = row.data();
    	
    	editForm.clearForm();  //清除表单元素
    	$('.help-block').remove();  //移除提示信息
    	$('.form-group').removeClass('has-success');
        $('.form-group').removeClass('has-error');
    	//表单赋值
    	$("#userName").val(data.userName);
    	$("#userCode").val(data.userCode);
    	$("#sex").val(data.sex);
    	editModal.modal("show");
    	
    });
    
    //点击查询按钮
    $("#queryBTN").on('click', function (e) {  
    	grid.submitFilter(queryForm);
    })
    
    //ajaxForm提交参数
    var ajaxFormOptions = { 
        //target:        '#userForm',   // 指明页面中由服务器响应进行更新的元素。元素的值可能被指定为一个jQuery选择器字符串，一个jQuery对象，或者一个DOM元素 
        beforeSubmit:  showRequest,   // 表单提交前被调用的回调函数 
        success:       showResponse   // 表单成功提交后调用的回调函数
 
        // other available options: 
        //url:       url         // Ajax请求将要提交到该url，默认是表单的action属性值 
        //type:      type        // 指定提交表单数据的方法：“GET”或“POST”。默认值：表单的method属性值（如果没有找到默认为“GET”）。
        //dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
        //clearForm: true        // 表示如果表单提交成功是否清除表单数据。默认值：null 
        //resetForm: true        // 表示如果表单提交成功是否进行重置。默认值: null 
 
        // $.ajax options 也可以使用，如下: 
        //timeout:   3000 
    }; 
    
    /*//点击保存按钮 
    $('#saveBTN').click(function() { 
   	    //editForm.submit();
   	    editForm.ajaxSubmit(options); 
        return false; 
    }); */
 
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
        			stringMaxLength: 5
        		},
        		userCode: {
        			required: true,
        			minlength: 6,
        			maxlength: 12
        		},
        		sex: {
        			required: true
        		}
        	},
        	
        	messages: {  // 自定义提示消息
        		userName: {
        			required: "请输入姓名"
        		},
        		userCode: {
        			required: "请输入账号"
        		},
        		sex: {
        			required: "请输入性别"
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
    	editModal.modal('hide');
        //通知栏
        noty({
        	text: "保存成功！",
        	layout: "top",
        	type: "information",
        	closeButton: "true"
        });
    };

});	