package com.essential.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: SUConstants
 * @Description: 常量类
 * @author: wanglt
 * @date: 2015年2月28日 上午11:07:34
 * 
 */
public abstract class SUConstants {
	/** JavaBean的serialVersionUID */
	public final static long beanSerialVersionUID = 1L;

	/** 失效 */
	public static final String ENABLE_FLAG_INVALID = "0";

	/** 生效 */
	public static final String ENABLE_FLAG_EFFECT = "1";
	/**
	 * 性别男
	 */
	public static final String MALE = "1";
	/**
	 * 性别女
	 */
	public static final String FEMALE = "0";
	/**
	 * 返回正确
	 */
	public static final String RETURN_TRUE = "true";

	/**
	 * 返回值业务错误
	 */
	public static final String RETURN_FALSE = "false";

	/**
	 * 返回值数据重复
	 */
	public static final String RETURN_REPEAT = "repeat";

	/**
	 * 返回成功
	 */
	public static final String RETURN_SUCCESS = "success";

	/**
	 * 分页查询每一页的查询量
	 */
	public final static int queryCount = 10;
	/**
	 * 附件存储路径
	 */
	public final static String TEMP_IMG_PATH = "/usr/king/img/";
	/**
	 * 返回值系统错误
	 */
	public static final String RETURN_ERROR = "error";
	/**
	 * 发送邮箱host
	 */
	public static final String EMAIL_HOST = "";

	/**
	 * 发送方的邮箱地址
	 */
	public static final String EMAIL_FROM = "";

	/**
	 * 发送方的邮箱密码
	 */
	public static final String EMAIL_PS = "";

	/**
	 * 返回值成功状态
	 */
	public static final String CODE_SUCCESS_VALUE = "1";

	/**
	 * 返回值失败状态
	 */
	public static final String CODE_FAIL_VALUE = "0";

	/**
	 * 返回值成功信息
	 */
	public static final String MSG_SUCCESS_VALUE = "OK";

	/**
	 * 返回值状态键
	 */
	public static final String CODE_KEY = "code";

	/**
	 * 返回值信息键
	 */
	public static final String MSG_KEY = "msg";

	/**
	 * 服务器处理异常提示
	 */

	public static final String SERVER_ERROR = "服务器异常";
	public static final String PARAM_ERRROR="请求参数异常";
	/**
	 * 返回值对应的key
	 */
	public static final String INFO_KEY = "info";

	/**
	 * 删除标识
	 */
	public static final int IS_DELETE = 1;

	/**
	 * 未删除标识
	 */
	public static final int IS_NOT_DELETE = 0;

	/**
	 * 是否收藏
	 */
	public static final int IS_COLLECTED = 1;
	public static final int IS_NOT_COLLECTED = 0;
	public static final String KEY_IS_COLLECTED = "isCollected";
	/**
	 * 数据库通用字段
	 */
	/**
	 * 用户id
	 */
	public static final String KEY_USERID = "userId";
	/**
	 * 删除字段
	 */
	public static final String KEY_IS_DELETE = "isDelete";
	/**
	 * 创建人id
	 */
	public static final String KEY_CREATE_USERID = "createUserId";
	/**
	 * 创建人时间
	 */
	public static final String KEY_CREATE_TIME = "createTime";
	/**
	 * 修改人id
	 */
	public static final String KEY_MODIFY_USERID = "modifyUserId";
	/**
	 * 修改时间
	 */
	public static final String KEY_MODIFY_TIME = "modifyTime";

	/**
	 * 分页，每页页条数
	 */
	public static final int PAGE_COUNT = 10;

	/**
	 * 选中标识
	 */
	public static final int IS_SELECT = 1;

	/**
	 * 未选中标识
	 */
	public static final int IS_NOT_SELECT = 0;

	/**
	 * 二级规格
	 */
	public static final int SPECIFICATION_TWO = 2;

	/**
	 * 三级规格
	 */
	public static final int SPECIFICATION_THREE = 3;

	/**
	 * 店铺文件目录
	 */
	public static final String FILE_SHOP = "shop";

	/**
	 * 商品文件目录
	 */
	public static final String FILE_PRODUCT = "product";
	
	/**
	 * 推荐文件目录
	 */
	public static final String FILE_RECOMMEND = "recommend";

	/**
	 * 其他文件目录
	 */
	public static final String FILE_OTHER = "other";

	/**
	 * 文件（图片）上传的类型： 店铺类型
	 */
	public static final int FILE_SHOP_TYPE = 0;

	/**
	 * 文件（图片）上传的类型：商品类型
	 */
	public static final int FILE_PRODUCT_TYPE = 1;

	/**
	 * 文件（图片）上传的类型：其他类型
	 */
	public static final int FILE_OTHER_TYPE = 2;
	
	/**
	 * 文件（图片）上传的类型：推荐类型
	 */
	public static final int FILE_RECOMMEND_TYPE = 3;
	
	/**
	 * 文件（图片）上传的失败
	 */
	public static final String FILE_UPLOAD_FAIL = "0";
	//1	取消订单
	public static final int ORDER_STATUS_ZERO = 0;
	//1	等待买家付款 
	public static final int ORDER_STATUS_ONE = 1;
	//2	等待商家发货
	public static final int ORDER_STATUS_TWO = 2;
	//3	商家已发货
	public static final int ORDER_STATUS_THREE = 3;
	//4	订单完成
	public static final int ORDER_STATUS_FOUR = 4;
	//5	订单关闭	
	public static final int ORDER_STATUS_FIVE = 5;
	
	public static final Map<Integer, String> ORDER_STATUS_MAP = new HashMap<Integer, String>(){
		private static final long serialVersionUID = 1L;

		{
			put(ORDER_STATUS_ZERO,"已取消订单");
			put(ORDER_STATUS_ONE,"等待买家付款 ");
			put(ORDER_STATUS_TWO,"等待商家发货");
			put(ORDER_STATUS_THREE,"已发货");
			put(ORDER_STATUS_FOUR,"订单完成");
			put(ORDER_STATUS_FIVE,"订单关闭");
		}
	};
	
	//1	待商家审核
	public static final int RETURN_REFUND_ORDER_STATUS_ONE = 1;
	//2	商家驳回
	public static final int RETURN_REFUND_ORDER_STATUS_TWO = 2;
	//3	平台审核中
	public static final int RETURN_REFUND_ORDER_STATUS_THREE = 3;
	//4	平台处理中
	public static final int RETURN_REFUND_ORDER_STATUS_FOUR = 4;
	//5	平台驳回	
	public static final int RETURN_REFUND_ORDER_STATUS_FIVE = 5;
	//6	退款完成	
	public static final int RETURN_REFUND_ORDER_STATUS_SIX = 6;
	//7	待买家发货
	public static final int RETURN_REFUND_ORDER_STATUS_SERVEN = 7;
	//8	待商家收货
	public static final int RETURN_REFUND_ORDER_STATUS_EIGHT = 8;
	//9	货品驳回
	public static final int RETURN_REFUND_ORDER_STATUS_NINE = 9;
	
	//App用
	public static final Map<Integer, String> RETURN_REFUND_ORDER_STATUS_MAP = new HashMap<Integer, String>(){
		private static final long serialVersionUID = 1L;

		{
			put(RETURN_REFUND_ORDER_STATUS_ONE,"待商家审核");
			put(RETURN_REFUND_ORDER_STATUS_TWO,"商家驳回");
			put(RETURN_REFUND_ORDER_STATUS_THREE,"平台审核中");
			put(RETURN_REFUND_ORDER_STATUS_FOUR,"平台处理中");
			put(RETURN_REFUND_ORDER_STATUS_FIVE,"平台驳回");
			put(RETURN_REFUND_ORDER_STATUS_SIX,"退款完成	");
			put(RETURN_REFUND_ORDER_STATUS_SERVEN,"待买家发货");
			put(RETURN_REFUND_ORDER_STATUS_EIGHT,"待商家收货");
			put(RETURN_REFUND_ORDER_STATUS_NINE,"货品驳回");
		}
	};

	/**
	 * 限时促销活动未开始
	 */
	public static final int PROMOTION_NOT_START = 0;
	/**
	 * 限时促销活动进行中
	 */
	public static final int PROMOTION_START = 1;
	/**
	 * 限时促销活动已结束
	 */
	public static final int PROMOTION_END = 2;
	
	
	/**
	 * 活动类型 折扣
	 */

	public static final int PROMOTION_TYPE_NONE = 0;
	public static final int PROMOTION_TYPE_PROMOTION = 1;
	public static final int PROMOTION_TYPE_DISCOUNT = 0;
	
	/**
	 * 活动商品状态
	 */
	public static final String PROMOTION_PRODUCT_STATUS_JOIN_NAME = "已参加";
	public static final String PROMOTION_PRODUCT_STATUS_OTHER_NAME = "该商品已参加其他活动";
	
	/**
	 * 满减送
	 */
	public static final int PROMOTION_TYPE_SUB = 1;
	
	/**
	 * 短信验证码长度（位数）
	 */
	public static final int SEND_REGISTRATION_CODE = 6;
	
	
	/**
	 * app
	 */
	public static final long USERTYPE_APP=0L;
	/**
	 * 店铺
	 */
	public static final long USERTYPE_SHOP=1L;
	/**
	 * 平台
	 */
	public static final long USERTYPE_PATFORM=2L;
	
	/**
	 * 时间戳格式化
	 */
	public static final String TIMESTAMP_FOMART="yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * 用户注册类型
	 */
	public static final int PLATFORM_PHONE = 0;
	public static final int PLATFORM_QQ = 1;
	public static final int PLATFORM_WECHAT = 2;
	public static final int PLATFORM_WEIBO = 3;

	/**
	 * 用户状态 0：正常，1：禁用
	 */
	public static final long USERTYPE_STATUS_NORMAL = 0;
	public static final long USERTYPE_STATUS_FORBID = 1;
	
	// 是否已读
	public static final int ReadStatus_NOT_READ=0;
	public static final int ReadStatus_READ=1;

	/**
	 * 默认收货地址  1：默认，0：非默认
	 */
	public static final Integer Default_Address_Not = 0;
	public static final Integer Default_Address = 1;
	
	/**
	 * 推送类型
	 */
	public static final Integer PushStrategy_All = 0;
	public static final Integer PushStrategy_Personal = 1;
	public static final Integer PushStrategy_Common = 2;
	public static final Integer PushStrategy_Vip = 3;
}
