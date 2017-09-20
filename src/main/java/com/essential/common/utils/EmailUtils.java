package com.essential.common.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

import com.essential.common.constants.SUConstants;


/**
 * 发送邮箱
 * EmailUtils <BR>
 * TODO <BR>
 * 创建人:liyang <BR>
 * 时间:2015年3月6日 上午9:57:42 <BR>
 * @version 1.0.0
 */
public class EmailUtils {
	/**
	 * 发送邮件
	 * <BR>
	 * 方法名：sendEmail<BR>
	 * 创建人:liyang <BR>
     * 时间:2015年3月6日 上午9:57:42 <BR>
	 * @param toAddress 收件人邮箱
	 * @param ccAddress 抄送人邮箱
	 * @param theme 邮件主题
	 * @param content 邮件内容
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static boolean sendEmail(String toAddress,String ccAddress,String theme,String content) throws Exception {
		// 防止邮件内容为空报错
		if (content == null) {
			content = "";
		}
		Properties props = new Properties();
		// 设置发送邮件的邮件服务器的属性
		props.put("mail.smtp.host", SUConstants.EMAIL_HOST);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		props.put("mail.smtp.auth", "true");
		try{
			// 用刚刚设置好的props对象构建一个session
			Session session = Session.getDefaultInstance(props);
	
			// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
			// 用（有的时候网络连通性不够好，发送邮件可能会有延迟，在这里面会有所提示，所以最好是加上这句，避免盲目的等待）
			session.setDebug(true);
			// 定义消息对象
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SUConstants.EMAIL_FROM, SUConstants.EMAIL_FROM));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toAddress));
			if (ccAddress != null && !"".equals(ccAddress)) {
				message.setRecipients(RecipientType.CC, InternetAddress.parse(ccAddress));
			}
			message.setSubject(theme);
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();
		    // 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(content, "text/html;charset=utf-8");
			contentPart.setHeader("Content-Type", "text/plain; charset=\"UTF-8\"");
			multipart.addBodyPart(contentPart);
			// 添加附件
			// 注意：下面定义的enc对象用来处理中文附件名，否则名称是中文的附件在邮箱里面显示的会是乱码，
			@SuppressWarnings("unused")
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			// 将multipart对象放到message中
			message.setContent(multipart);
			// 发送邮件
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(SUConstants.EMAIL_HOST, SUConstants.EMAIL_FROM, SUConstants.EMAIL_PS);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * 发送邮件（收件人和转发人可配置多个邮箱）
	 * <BR>
	 * 方法名：sendEmailToAll<BR>
	 * 创建人:liyang <BR>
     * 时间:2015年3月6日 上午9:57:42 <BR>
	 * @param toAddress 收件人邮箱(多个邮箱)
	 * @param ccAddress 抄送人邮箱（多个邮箱）
	 * @param theme 邮件主题
	 * @param content 邮件内容
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static boolean sendEmailToAll(String[] toAddress,String[] ccAddress,String theme,String content) throws Exception {
		// 防止邮件内容为空报错
		if (content == null) {
			content = "";
		}
		Properties props = new Properties();
		// 设置发送邮件的邮件服务器的属性
		props.put("mail.smtp.host", SUConstants.EMAIL_HOST);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有//这一条）
		props.put("mail.smtp.auth", "true");
		try{
			// 用刚刚设置好的props对象构建一个session
			Session session = Session.getDefaultInstance(props);
			// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
			// 用（有的时候网络连通性不够好，发送邮件可能会有延迟，在这里面会有所提示，所以最好是加上这句，避免盲目的等待）
			session.setDebug(true);
			// 定义消息对象
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(SUConstants.EMAIL_FROM, SUConstants.EMAIL_FROM));
			InternetAddress[] toAddresss=new InternetAddress[toAddress.length];
			for(int i=0;i<toAddress.length;i++){
				toAddresss[i]=new InternetAddress(toAddress[i]);
			}
			message.setRecipients(RecipientType.TO, toAddresss);
			if (ccAddress != null) {
				InternetAddress[] ccAddresss=new InternetAddress[ccAddress.length];
				for(int i=0;i<ccAddress.length;i++){
					ccAddresss[i]=new InternetAddress(ccAddress[i]);
				}
				message.setRecipients(RecipientType.CC, ccAddresss);
			}
			message.setSubject(theme);
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();
			// 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(content, "text/html;charset=utf-8");
			contentPart.setHeader("Content-Type", "text/plain; charset=\"UTF-8\"");
			multipart.addBodyPart(contentPart);
			// 添加附件
			// 注意：下面定义的enc对象用来处理中文附件名，否则名称是中文的附件在邮箱里面显示的会是乱码，
			@SuppressWarnings("unused")
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			// 将multipart对象放到message中
			message.setContent(multipart);
			// 发送邮件
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(SUConstants.EMAIL_HOST, SUConstants.EMAIL_FROM, SUConstants.EMAIL_PS);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
