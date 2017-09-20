$(document).ready(function(){
	var pathName = window.location.pathname;
	var projectContextPath = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
//	var loadImgUrl = projectContextPath+"/spicyPhoto/showPhoto?businessType=IMAGE_100&typeId=RbacUserEO&currentTime="+(new Date()).getTime();
//	$('#target').attr("src",loadImgUrl);
//	$('#img_100').attr("src",loadImgUrl);
//	$('#img_80').attr("src",loadImgUrl);
//	$('#img_50').attr("src",loadImgUrl);
	var typeId = "RbacUserEO";
	var uploadURL = projectContextPath+"/spicyPhoto/uploadFile";
	var img_x=0,img_y=0,img_w=0,img_h=0;
	var initX1=0, initY1=0, initX2=250, initY2=250;
	
	/**
	 * 定义一个对象用于头像页面初始化
	 */
	function initializtion(x,y,w,h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	//容器对象
	var $pic100_box = $('.pic100_box');
	var $pic80_box = $('.pic80_box');
	var $pic50_box = $('.pic50_box');
	//图片对象
	var $img_100 = $('#img_100');
	var $img_80 = $('#img_80');
	var $img_50 = $('#img_50');
	//获取预览容器的长和宽
	var xsize_100 = $pic100_box.width(),ysize_100 = $pic100_box.height();
	var xsize_80 = $pic80_box.width(),ysize_80 = $pic80_box.height();
	var xsize_50 = $pic50_box.width(),ysize_50 = $pic50_box.height();
	var boundx = 0,boundy = 0;
	
	function select(c){
		img_x = c.x,img_y=c.y,img_w=c.w,img_h=c.h;
	}

	
});