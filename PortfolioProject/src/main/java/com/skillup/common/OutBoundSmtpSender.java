package com.skillup.common;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skillup.Vo.vo.EmailDataVO;
import com.skillup.Vo.vo.SendEMailRequestVO;
import com.skillup.Vo.vo.SendEMailRequestVO.EMAIL_TYPE;
import com.skillup.Vo.vo.ServiceInfoVO;

public class OutBoundSmtpSender {

    private static Logger logger = LoggerFactory.getLogger(OutBoundSmtpSender.class);
    
    /*
     * @see com.kia.kbms.global.api.common.sender.OutBoundSender#sendRequest(com.kia.kbms.global.api.common.vo.ServiceInfoVO, java.lang.Object, java.lang.Class)
     */
    public static <S, Q> S sendRequest(ServiceInfoVO serviceInfo, Q request, Class<S> response) { 
        SendEMailRequestVO requestVo = null; 
        if(request instanceof SendEMailRequestVO) { 
            requestVo = (SendEMailRequestVO)request;
        }else {
            // throw new KBMSApiException(MessageUtils.getMessage("errors.required", new String[]{"SendEMailRequestVO"}));
        }
        
        Properties properties = new Properties();  
        
//        final String userId = requestVo.getPropUserId();
//        final String password = requestVo.getPropPasswd();
        // final String userId = propertyService.getString("email.email_userid");
        // final String password = propertyService.getString("email.email_password");
        final String userId = "kjw4157@atsg.co.kr";
        final String password = "wlsdnjs77!";
        boolean auth = true; 
        
        requestVo.setPropAuth("TRUE");
        //requestVo.setPropHost(serviceInfo.getSvrUrl());
        requestVo.setPropHost("mail.atnsgroup.com");
        
        requestVo.setPropPort(serviceInfo.getPortNo());
        
        // Assert.notNull(requestVo.getPropHost(), MessageUtils.getMessage("errors.required", new String[]{"host"}));  
        // Assert.notNull(requestVo.getPropPort(), MessageUtils.getMessage("errors.required", new String[]{"port"}));  
        // Assert.notNull(requestVo.getPropAuth(), MessageUtils.getMessage("errors.required", new String[]{"auth"}));  
        
//        auth = "TRUE".equalsIgnoreCase(requestVo.getPropAuth());
        
//        logger.debug("########## USER_ID = " + userId);
//        logger.debug("########## PASSWD = " + password);
        logger.debug("########## SMTP HOST = " + requestVo.getPropHost());
        logger.debug("########## SMTP PORT = " + requestVo.getPropPort());
        
        if(auth) {
            // Assert.notNull(userId, MessageUtils.getMessage("errors.required", new String[]{"userId"}));  
            // Assert.notNull(password, MessageUtils.getMessage("errors.required", new String[]{"passwd"})); 
        }
         
        properties.setProperty("mail.smtp.host", requestVo.getPropHost());
        properties.setProperty("mail.smtp.port", requestVo.getPropPort());
        properties.setProperty("mail.smtp.auth", requestVo.getPropAuth());
    
        // SSL
        properties.setProperty("mail.smtp.socketFactory.port", requestVo.getPropPort());
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
        
        Session session = null;
        
        if(auth) {
            session = Session.getInstance(properties,  new javax.mail.Authenticator(){
                                                            protected PasswordAuthentication getPasswordAuthentication(){
                                                                return new PasswordAuthentication(userId ,password); 
                                                            }
                       });
        }else {  
            session = Session.getInstance(properties); 
        }
        
        try{
            Message message = new MimeMessage(session);
            InternetAddress[] rcvList = null;
            InternetAddress[] ccList = null;
            InternetAddress[] bccList = null; 
            int i = 0;
            if("".equals(CommonUtil.checkNull( requestVo.getSnderEmail().getName() ))) {
                message.setFrom(new InternetAddress(requestVo.getSnderEmail().geteMailAdr()));
            }else {
                message.setFrom(new InternetAddress( requestVo.getSnderEmail().geteMailAdr() , 
                                                       MimeUtility.encodeText(requestVo.getSnderEmail().getName(), "UTF-8" , "B")));
            }
            
            if(requestVo.getRcvEmailList() == null){
                // throw new KBMSApiException(ERRORCODE.ERR_MANDATORY_VALUE);
            }else {  
                if(rcvList == null) rcvList = new InternetAddress[ requestVo.getRcvEmailList().size() ];
                i = 0;
                
                for(EmailDataVO emailAdr : requestVo.getRcvEmailList()){ 
                    if("".equals(CommonUtil.checkNull( emailAdr.getName() ))) {
                        rcvList[i] = new InternetAddress(emailAdr.geteMailAdr());
                    }else {
                        rcvList[i] = new InternetAddress( emailAdr.geteMailAdr() , 
                                                               MimeUtility.encodeText(emailAdr.getName(), "UTF-8" , "B"));
                    }
                    i++;
                } 
            }
            
    
            if(requestVo.getCcEmailList() != null){   
                if(ccList == null) ccList = new InternetAddress[ requestVo.getCcEmailList().size() ];
                i = 0; 
                for(EmailDataVO emailAdr : requestVo.getCcEmailList()){ 
                    if("".equals(CommonUtil.checkNull( emailAdr.getName() ))) {
                        ccList[i] = new InternetAddress(emailAdr.geteMailAdr());
                    }else {
                        ccList[i] = new InternetAddress( emailAdr.geteMailAdr() , 
                                                               MimeUtility.encodeText(emailAdr.getName(), "UTF-8" , "B"));
                    }
                    i++;
                } 
            }
            
            if(requestVo.getBccEmailList() != null){
                if(bccList == null) bccList = new InternetAddress[ requestVo.getBccEmailList().size() ];
                i = 0; 
                for(EmailDataVO emailAdr : requestVo.getBccEmailList()){ 
                    if("".equals(CommonUtil.checkNull( emailAdr.getName() ))) {
                        bccList[i] = new InternetAddress(emailAdr.geteMailAdr());
                    }else {
                        bccList[i] = new InternetAddress( emailAdr.geteMailAdr() , 
                                                               MimeUtility.encodeText(emailAdr.getName(), "UTF-8" , "B"));
                    }
                    i++;
                }
            }
    
            message.setRecipients(RecipientType.TO, rcvList); 
            if(ccList != null) message.setRecipients(RecipientType.CC, ccList); 
            if(bccList != null) message.setRecipients(RecipientType.BCC, bccList); 
            
            message.setSubject(requestVo.getMailSubject());
            message.setSentDate(new Date());
            
            Multipart mp = new MimeMultipart(); 
            
            MimeBodyPart content = new MimeBodyPart();
            
            if(EMAIL_TYPE.HTML == requestVo.getEmailType()) {
                content.setContent(requestVo.getContents(), "text/html;charset=UTF-8");
            }else {
                content.setText(requestVo.getContents(), "UTF-8");
            }
            mp.addBodyPart(content);
            MimeBodyPart filePart = null;
            if(requestVo.getAttachFile() != null){ 
                if(filePart == null) filePart = new MimeBodyPart(); 
                FileDataSource fds = new FileDataSource(requestVo.getAttachFile());
                
                filePart.setDataHandler(new DataHandler(fds)); 
                filePart.setFileName(MimeUtility.encodeText(fds.getName())); 
            } 
            
            if(filePart != null) mp.addBodyPart(filePart); 
            message.setContent(mp); 

            Transport.send(message); 
            
            logger.debug("########## Email has been successfully sent. " );  
        }catch (UnsupportedEncodingException e){
            logger.error(e.getMessage());
        }catch (javax.mail.MessagingException m){
            logger.error(m.getMessage()); 
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }    
        
        return null;
    }
    
}
