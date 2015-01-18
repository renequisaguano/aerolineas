package controllers;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

import java.util.*;

public class Email {    
    String d_email = "clubsistemasutc@gmail.com",
            d_password = "septimosistemas", //your email password
            d_host = "smtp.gmail.com",
            d_port = "465",
            m_to = "renequisaguano@gmail.com", // Target email address
            m_subject = "Testing",
            m_text = "Probando html. <h1><a href='localhost:9000'> ABRA EL SIGUIENTE LINK </a></h1>";
    	
    
    public Email() {
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);     
            MimeMessage msg = new MimeMessage(session);
            msg.setContent(m_text, "text/html; charset=utf-8");

            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null,mex);
        }
    }
   
 
  
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}