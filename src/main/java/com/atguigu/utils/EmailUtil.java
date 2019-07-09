package com.atguigu.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	
	/**
     * @Method: readyEmail----Fictitious
     * @Description: 准备发邮件的服务器等相关身份资料
     * @Anthor:zsh
     * @param session
     * @return
     * @throws Exception
     */ 
	public static void readyEmailFictitious(String getToEmail )  throws Exception{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.163.com", "mingyueqingl@163.com", "abcd1234");
        //4、创建邮件
        //String toEmail="1020064691@qq.com";
        String toEmail=getToEmail;
        Message message = createSimpleMailFictitious(session,toEmail);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
	}
	
	/**
     * @Method: createSimpleMail----Fictitious
     * @Description: 创建一封只包含文本的邮件
     * @Anthor:zsh 
     * @param session
     * @return
     * @throws Exception
     */ 
     public static MimeMessage createSimpleMailFictitious(Session session,String toEmail)
             throws Exception {
         //创建邮件对象
         MimeMessage message = new MimeMessage(session);
         //指明邮件的发件人
         message.setFrom(new InternetAddress("mingyueqingl@163.com"));
         //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
         message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
         //邮件的标题
         message.setSubject("邮件标题");
         
         StringBuffer sb = new StringBuffer();
         
         sb.append("Hi,");
         sb.append(toEmail);
         sb.append(",Hello Welcome to MegaLook!");
         //邮件的文本内容
         message.setContent(sb, "text/html;charset=UTF-8");
         //返回创建好的邮件对象
         return message;
     }
	
	
	
	public static void readyEmailReal(String getToEmail )  throws Exception{
		// TODO Auto-generated method stub
		Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.163.com", "mingyueqingl@163.com", "abcd1234");
        //4、创建邮件
        //String toEmail="1020064691@qq.com";
        String toEmail=getToEmail;
        Message message = createSimpleMailReal(session,toEmail);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();

	}
	
	
	
     
     /**
      * @Method: createSimpleMailReal
      * @Description: 创建一封只包含文本的邮件
      * @Anthor:zsh
      * @param session
      * @return
      * @throws Exception
      */ 
      public static MimeMessage createSimpleMailReal(Session session,String toEmail)
              throws Exception {
          //创建邮件对象
          MimeMessage message = new MimeMessage(session);
          //指明邮件的发件人
          message.setFrom(new InternetAddress("mingyueqingl@163.com"));
          //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
          message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
          //邮件的标题
          message.setSubject("邮件标题");
          
          StringBuffer sb = new StringBuffer();
          
          sb.append("Hi,");
          sb.append(toEmail);
          sb.append(",Hello Welcome to MegaLook!");
          //邮件的文本内容
          message.setContent(sb, "text/html;charset=UTF-8");
          //返回创建好的邮件对象
          return message;
      }


}
