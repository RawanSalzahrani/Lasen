/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lasen;

import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.jboss.logging.Logger;

/**
 *
 * @author horre
 */
public class JavaMailUtil {
    
    public static int Authentication() {
        int max = 9999;
        int min = 1;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }
    
    static int random = 0;
    
    public static void sendMail(String recepient) throws MessagingException{
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myAccountEmail = "lasen.1444@gmail.com";
        String password = "masoqdsuukymovef";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
            
        });
        
        random = Authentication();
        Message message = prepareMessage(session, myAccountEmail, recepient, random);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient , int random) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("بريد إلكتروني للتحقق");
            message.setText("رمز التحقق هو : " + random);
            return message;
        } catch (Exception ex){
            java.util.logging.Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }   
    }
}
