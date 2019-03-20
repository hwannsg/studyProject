package com.skillup.Vo.vo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SendEMailRequestVO {
	 private static final long serialVersionUID = -5316119311755293983L;
	    public static  enum EMAIL_TYPE{HTML, TEXT};
	    private String  propHost;
	    private String  propPort;
	    private String  propAuth;
	    private String  propUserId;
	    private String  propPasswd;
	    
	    private EmailDataVO snderEmail;
	    private List<EmailDataVO> rcvEmailList;
	    private List<EmailDataVO> ccEmailList;
	    private List<EmailDataVO> bccEmailList;
	    
	    private String   mailSubject;
	    private EMAIL_TYPE emailType;
	    private String   contents;
	    private File attachFile; 
	    
	    /**
	     * @return the snderEmailAddr
	     */
	    public EmailDataVO getSnderEmail() {
	        return snderEmail;
	    }
	    /**
	     * @param snderEmailAddr the snderEmailAddr to set
	     */
	    public void setSnderEmail(EmailDataVO snderEmail) {
	        this.snderEmail = snderEmail;
	    }
	    /**
	     * @return the rcvEmailList
	     */
	    public List<EmailDataVO> getRcvEmailList() {
	        return rcvEmailList;
	    }
	    /**
	     * @param rcvEmailList the rcvEmailList to set
	     */
	    public void setRcvEmailList(List<EmailDataVO> rcvEmailList) {
	        this.rcvEmailList = rcvEmailList;
	    }
	    public void addRcvEmailList(EmailDataVO rcvEmail) {
	        if( this.rcvEmailList  == null)  this.rcvEmailList = new ArrayList<EmailDataVO>();
	        this.rcvEmailList.add(rcvEmail); 
	    }
	    /**
	     * @return the ccEmailList
	     */
	    public List<EmailDataVO> getCcEmailList() {
	        return ccEmailList;
	    }
	    /**
	     * @param ccEmailList the ccEmailList to set
	     */
	    public void setCcEmailList(List<EmailDataVO> ccEmailList) {
	        this.ccEmailList = ccEmailList;
	    }
	    public void addCcEmailList(EmailDataVO ccEmail) {
	        if( this.ccEmailList  == null)  this.ccEmailList = new ArrayList<EmailDataVO>();
	        this.ccEmailList.add(ccEmail); 
	    }
	    /**
	     * @return the bccEmailList
	     */
	    public List<EmailDataVO> getBccEmailList() {
	        return bccEmailList;
	    }
	    /**
	     * @param bccEmailList the bccEmailList to set
	     */
	    public void setBccEmailList(List<EmailDataVO> bccEmailList) {
	        this.bccEmailList = bccEmailList;
	    }
	    public void addBccEmailList(EmailDataVO bccEmail) {
	        if( this.bccEmailList  == null)  this.bccEmailList = new ArrayList<EmailDataVO>();
	        this.bccEmailList.add(bccEmail); 
	    }
	    /**
	     * @return the mailSubject
	     */
	    public String getMailSubject() {
	        return mailSubject;
	    }
	    /**
	     * @param mailSubject the mailSubject to set
	     */
	    public void setMailSubject(String mailSubject) {
	        this.mailSubject = mailSubject;
	    }
	    /**
	     * @return the emailType
	     */
	    public EMAIL_TYPE getEmailType() {
	        return emailType;
	    }
	    /**
	     * @param emailType the emailType to set
	     */
	    public void setEmailType(EMAIL_TYPE emailType) {
	        this.emailType = emailType;
	    }
	    /**
	     * @return the contents
	     */
	    public String getContents() {
	        return contents;
	    }
	    /**
	     * @param contents the contents to set
	     */
	    public void setContents(String contents) {
	        this.contents = contents;
	    }
	    /**
	     * @return the attachFile
	     */
	    public File getAttachFile() {
	        return attachFile;
	    }
	    /**
	     * @param attachFile the attachFile to set
	     */
	    public void setAttachFile(File attachFile) {
	        this.attachFile = attachFile;
	    }
	    /**
	     * @return the propHost
	     */
	    public String getPropHost() {
	        return propHost;
	    }
	    /**
	     * @param propHost the propHost to set
	     */
	    public void setPropHost(String propHost) {
	        this.propHost = propHost;
	    }
	    /**
	     * @return the propPort
	     */
	    public String getPropPort() {
	        return propPort;
	    }
	    /**
	     * @param propPort the propPort to set
	     */
	    public void setPropPort(String propPort) {
	        this.propPort = propPort;
	    }
	    /**
	     * @return the propAuth
	     */
	    public String getPropAuth() {
	        return propAuth;
	    }
	    /**
	     * @param propAuth the propAuth to set
	     */
	    public void setPropAuth(String propAuth) {
	        this.propAuth = propAuth;
	    }
	    /**
	     * @return the propUserId
	     */
	    public String getPropUserId() {
	        return propUserId;
	    }
	    /**
	     * @param propUserId the propUserId to set
	     */
	    public void setPropUserId(String propUserId) {
	        this.propUserId = propUserId;
	    }
	    /**
	     * @return the propPasswd
	     */
	    public String getPropPasswd() {
	        return propPasswd;
	    }
	    /**
	     * @param propPasswd the propPasswd to set
	     */
	    public void setPropPasswd(String propPasswd) {
	        this.propPasswd = propPasswd;
	    }
	    /*
	     * @see java.lang.Object#toString()
	     */
	    @Override
	    public String toString() {
	        return "SendEMailRequestVO [propHost=" + propHost + ", propPort=" + propPort + ", propAuth=" + propAuth
	                + ", propUserId=" + propUserId + ", propPasswd=" + propPasswd + "]";
	    }
}
