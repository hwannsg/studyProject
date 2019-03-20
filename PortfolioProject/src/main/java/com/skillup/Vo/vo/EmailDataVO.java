package com.skillup.Vo.vo;


import org.springframework.util.Assert;

public class EmailDataVO {

    private String eMailAdr;
    private String name;
    
    public EmailDataVO(String eMailAdr, String name){
        this.eMailAdr = eMailAdr;
        this.name = name; 
    }
    
    /**
     * @return the eMailAdr
     */
    public String geteMailAdr() {
        return eMailAdr;
    }
    /**
     * @param eMailAdr the eMailAdr to set
     */
    public void seteMailAdr(String eMailAdr) {
        this.eMailAdr = eMailAdr;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EmailDataVO [eMailAdr=" + eMailAdr + ", name=" + name + "]";
    } 
    
    public String generratorEmailAdr(){ 
        // Assert.notNull(eMailAdr, MessageUtils.getMessage("errors.required", new String[]{"eMailAdr"})); 
        return name + "<" + eMailAdr + ">"; 
    }
}
