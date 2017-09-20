package com.essential.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.essential.common.utils.StringCommonUtils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.report.ReceivedsResult;

public class JPushUtils {

	private static final String appKey = "f755f66e9dbec9ba6f03799d";
	private static final String masterSecret = "476cf8f9c2b799649209cd1a";
	private JPushClient jpushClient;
	private String content;
	private String title;
	/**
	 * 平台类型
	 * 
	 * @author Jaelyn
	 *
	 */
	public enum PlatformType {
		ALL, ANDROID, IOS
	}

	/**
	 * 退送类型
	 * 
	 * @author Jaelyn
	 *
	 */
	public enum AudienceType {
		ALL, REGISTRATIONIDS, ALIAS, TAGS
	}

	public JPushUtils(String content) {
		jpushClient = new JPushClient(masterSecret, appKey, 3);
		this.content = content;	
	}

	public JPushUtils(String title,String content) {
		jpushClient = new JPushClient(masterSecret, appKey, 3);
		this.content = content;	
		this.title=title;
	}

	/**
	 * 向所有人发送消息
	 * 
	 * @return 消息id
	 */
	public void sendPushAll(Map<String, String> extrasMap) {
		sendPush(PlatformType.ALL, AudienceType.ALL, null, extrasMap);
		//ReceivedsResult result = jpushClient.getReportReceiveds("1942377665");
	}

	/**
	 * 向指定别名的客户端发送消息
	 * 
	 * @param alias
	 *            所有别名信息集合，这里表示发送所有学生编号
	 * @return 消息id
	 */
	public void sendPushRegistrationId(String registrationId,Map<String, String> extrasMap) {
		List<String> audiences=new ArrayList<String>();
		audiences.add(registrationId);
		sendPush(PlatformType.ALL, AudienceType.REGISTRATIONIDS, audiences, extrasMap);
	}
	public void sendPushRegistrationId(List<String> registrationIds, Map<String, String> extrasMap) {
		sendPush(PlatformType.ALL, AudienceType.REGISTRATIONIDS, registrationIds, extrasMap);
	}

	/**
	 * 向指定别名的客户端发送消息
	 * 
	 * @param alias
	 *            所有别名信息集合，这里表示发送所有学生编号
	 * @return 消息id
	 */
	public void sendPushAlias(String alias, Map<String, String> extrasMap) {
		List<String> audiences=new ArrayList<String>();
		audiences.add(alias);
		sendPush(PlatformType.ALL, AudienceType.ALIAS, audiences, extrasMap);
	}
	public void sendPushAlias(List<String> alias, Map<String, String> extrasMap) {
		sendPush( PlatformType.ALL, AudienceType.ALIAS, alias, extrasMap);
	}

	/**
	 * 向指定组发送消息
	 * 
	 * @param tag
	 *            组名称
	 * @return 消息id
	 */
	public void sendPushTag(String tags, Map<String, String> extrasMap) {
		List<String> audiences=new ArrayList<String>();
		audiences.add(tags);
		sendPush(PlatformType.ALL, AudienceType.TAGS, audiences, extrasMap);
	}
	public void sendPushTag(List<String> tags, Map<String, String> extrasMap) {
		sendPush(PlatformType.ALL, AudienceType.TAGS, tags, extrasMap);
	}

	/**
	 * 根据平台退送
	 * @param platformType
	 * @param extrasMap
	 */
	public void sendPlatform(PlatformType platformType, Map<String, String> extrasMap) {
		sendPush(platformType, AudienceType.ALL, null, extrasMap);
	}

	/**
	 * 根据参数 退送
	 * @param content
	 * @param platformType
	 * @param audienceType
	 * @param audiences
	 * @param extrasMap
	 */
	public void sendPush(PlatformType platformType, AudienceType audienceType, List<String> audiences, Map<String, String> extrasMap) {
		//不关心退送结果，线程运行部阻塞返回
		if(StringCommonUtils.isEmail(title)){
			title="奕赏";
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// For push, all you need do is to build PushPayload object.
					PushPayload.Builder pushPayloadBuilder = PushPayload.newBuilder();
					
					switch (platformType) {
					case ALL:
						pushPayloadBuilder.setPlatform(Platform.android_ios());
						Notification.Builder  notificationBuilder=Notification.newBuilder();
						IosNotification iosNotification=IosNotification.newBuilder()
		                .setAlert(content).addExtras(extrasMap).build();
						
						AndroidNotification androidNotification=AndroidNotification.newBuilder()
								.setAlert(content).addExtras(extrasMap).build();
						
						notificationBuilder.addPlatformNotification(iosNotification);
						notificationBuilder.addPlatformNotification(androidNotification);
						
						Notification notification=notificationBuilder.build();
						pushPayloadBuilder.setNotification(notification);
						break;
					case ANDROID:
						pushPayloadBuilder.setPlatform(Platform.android());
						pushPayloadBuilder.setNotification(Notification.android(content, null, extrasMap));
						break;
					case IOS:
						pushPayloadBuilder.setPlatform(Platform.ios());
						pushPayloadBuilder.setNotification(Notification.ios(content, extrasMap));
						break;
					default:
						pushPayloadBuilder.setPlatform(Platform.android_ios());
						pushPayloadBuilder.setNotification(Notification.alert(content));
						break;
					}
					Audience audience = null;
					switch (audienceType) {
					case ALL:
						audience=Audience.all();
						break;
					case REGISTRATIONIDS:
						audience = Audience.registrationId(audiences);
						break;
					case ALIAS:
						audience = Audience.alias(audiences);
						break;
					case TAGS:
						audience = Audience.tag(audiences);
						break;
					default:
						audience=Audience.all();
						break;
					}
					
					if (audience != null) {
						pushPayloadBuilder.setAudience(audience);
					}		
					
					
					PushPayload payload = pushPayloadBuilder.build();
					PushResult result = jpushClient.sendPush(payload);
					System.out.println(result.toString());
				} catch (Exception e) {
					e.printStackTrace();
					LogUtils.debug("send Push error:"+e.toString());
				}
			}
		}).start();
		
	}
	
	public static void main(String[] args) {
		String content="ios终于收到了，泪奔不";
		PlatformType platformType=PlatformType.ALL;
		AudienceType audienceType=AudienceType.ALL;
		ArrayList<String> audiences=new ArrayList<String>();
		audiences.add("190e35f7e04548c3abb");
		Map<String,String> extrasMap=new HashMap<String,String>();
		extrasMap.put("from", "value");
		JPushUtils jPushUtils=new JPushUtils(content);
		//jPushUtils.sendPushRegistrationId(audiences, extrasMap);
		
		//jPushUtils.sendPlatform(platformType, extrasMap);
		
		audiences=new ArrayList<String>();
		audiences.add("alias1");
		//jPushUtils.sendPushAlias(audiences, extrasMap);
		
		audiences=new ArrayList<String>();
		audiences.add("tag");
		//jPushUtils.sendPushTag(audiences, extrasMap);
		
		jPushUtils.sendPushAll(extrasMap);
	}
}
