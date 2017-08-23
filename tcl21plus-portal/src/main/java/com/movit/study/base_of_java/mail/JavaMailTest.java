package com.movit.study.base_of_java.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/14.
 */
public class JavaMailTest {
    public static void main(String[] args) {

        Properties mailProps = new Properties();
        mailProps.put("mail.smtp.host", "smtp.163.com");
        mailProps.put("mail.smtp.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");
        String userName = "zhengrui_java@163.com";
        String passWord = "qaz901223";
        String content = "hello";

        Session mailSession = Session.getInstance(mailProps, new PopupAuthenticator(userName, passWord));

        try {
            InternetAddress fromAddress = new InternetAddress(userName);
            InternetAddress toAddress = new InternetAddress("Jerry.Zheng@movit-tech.com");
            MimeMessage message = new MimeMessage(mailSession);

            message.setFrom(fromAddress);
            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSentDate(Calendar.getInstance().getTime());
            message.setSubject("find your password");
            message.setContent(content, "text/html;charset=gb2312");

            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.163.com", "zhengrui_java", "qaz901223");
            transport.send(message, message.getRecipients(Message.RecipientType.TO));
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}

class PopupAuthenticator extends Authenticator {
    private String username;
    private String password;

    public PopupAuthenticator(String username, String pwd) {
        this.username = username;
        this.password = pwd;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }
}
