package com.essential.common.enums;
/**
 * 
 * @ClassName: MsgTypeEnum
 * @Description: 消息类型枚举
 * @author: 李杨
 * @date: 2015年3月24日 下午5:23:00
 *
 */
public enum MsgTypeEnum {
	text("文字"), image("图片"),voice("语音"),video("视频"),file("文件"),news("图文"),mpnews("图文");
	
	 private final String msgType;

     //构造器默认也只能是private, 从而保证构造函数只能在内部使用
	 MsgTypeEnum(String msgType) {
         this.msgType = msgType;
     }
     
     public String getMsgType() {
         return msgType;
     }

}
