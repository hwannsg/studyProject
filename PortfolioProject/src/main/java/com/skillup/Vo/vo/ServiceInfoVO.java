package com.skillup.Vo.vo;

public class ServiceInfoVO {
	private Long apiSvcId;
    private Long svrId; //  
    private String dlrCd; //  
    private String svrNm; //  
    private String svrIpAdr; //  
    private String localSysCd; //  
    private String protlTypeCd; //  
    private String portNo; //  
    private String svrUrl; //  
    private String apiKeyVal; //  
    private String svcCd; //   
    private String svcUrl; //  
    private String mthdTypeCd;  
    private String apiActv;  
    
    /**
     * @return the dlrCd
     */
    public String getDlrCd() {
        return dlrCd;
    }
    /**
     * @param dlrCd the dlrCd to set
     */
    public void setDlrCd(String dlrCd) {
        this.dlrCd = dlrCd;
    }
    /**
     * @return the apiSvcId
     */
    public Long getApiSvcId() {
        return apiSvcId;
    }
    /**
     * @param apiSvcId the apiSvcId to set
     */
    public void setApiSvcId(Long apiSvcId) {
        this.apiSvcId = apiSvcId;
    }
    /**
     * @return the mthdTypeCd
     */
    public String getMthdTypeCd() {
        return mthdTypeCd;
    }
    /**
     * @param mthdTypeCd the mthdTypeCd to set
     */
    public void setMthdTypeCd(String mthdTypeCd) {
        this.mthdTypeCd = mthdTypeCd;
    }
    /**
     * @return the svrId
     */
    public Long getSvrId() {
        return svrId;
    }
    /**
     * @param svrId the svrId to set
     */
    public void setSvrId(Long svrId) {
        this.svrId = svrId;
    }
    /**
     * @return the svrNm
     */
    public String getSvrNm() {
        return svrNm;
    }
    /**
     * @param svrNm the svrNm to set
     */
    public void setSvrNm(String svrNm) {
        this.svrNm = svrNm;
    }
    /**
     * @return the svrIpAdr
     */
    public String getSvrIpAdr() {
        return svrIpAdr;
    }
    /**
     * @param svrIpAdr the svrIpAdr to set
     */
    public void setSvrIpAdr(String svrIpAdr) {
        this.svrIpAdr = svrIpAdr;
    }
    /**
     * @return the localSysCd
     */
    public String getLocalSysCd() {
        return localSysCd;
    }
    /**
     * @param localSysCd the localSysCd to set
     */
    public void setLocalSysCd(String localSysCd) {
        this.localSysCd = localSysCd;
    }
    /**
     * @return the protlTypeCd
     */
    public String getProtlTypeCd() {
        return protlTypeCd;
    }
    /**
     * @param protlTypeCd the protlTypeCd to set
     */
    public void setProtlTypeCd(String protlTypeCd) {
        this.protlTypeCd = protlTypeCd;
    }
    /**
     * @return the portNo
     */
    public String getPortNo() {
        return portNo;
    }
    /**
     * @param portNo the portNo to set
     */
    public void setPortNo(String portNo) {
        this.portNo = portNo;
    }
    /**
     * @return the svrUrl
     */
    public String getSvrUrl() {
        return svrUrl;
    }
    /**
     * @param svrUrl the svrUrl to set
     */
    public void setSvrUrl(String svrUrl) {
        this.svrUrl = svrUrl;
    }
    /**
     * @return the apiKeyVal
     */
    public String getApiKeyVal() {
        return apiKeyVal;
    }
    /**
     * @param apiKeyVal the apiKeyVal to set
     */
    public void setApiKeyVal(String apiKeyVal) {
        this.apiKeyVal = apiKeyVal;
    }
    /**
     * @return the svcCd
     */
    public String getSvcCd() {
        return svcCd;
    }
    /**
     * @param svcCd the svcCd to set
     */
    public void setSvcCd(String svcCd) {
        this.svcCd = svcCd;
    }
     
    /**
     * @return the svcUrl
     */
    public String getSvcUrl() {
        return svcUrl;
    }
    /**
     * @param svcUrl the svcUrl to set
     */
    public void setSvcUrl(String svcUrl) {
        this.svcUrl = svcUrl;
    }
    
    /**
     * @return the apiActv
     */
    public String getApiActv() {
        return apiActv;
    }
    
    /**
     * @param apiActv the apiActv to set
     */
    public void setApiActv(String apiActv) {
        this.apiActv = apiActv;
    }
    
    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ServiceInfoVO [apiSvcId=" + apiSvcId + ", svrId=" + svrId + ", dlrCd=" + dlrCd + ", svrNm=" + svrNm + ", svrIpAdr="
                + svrIpAdr + ", localSysCd=" + localSysCd + ", protlTypeCd=" + protlTypeCd + ", portNo=" + portNo
                + ", svrUrl=" + svrUrl + ", apiKeyVal=" + apiKeyVal + ", svcCd=" + svcCd + ", svcUrl=" + svcUrl
                + ", mthdTypeCd=" + mthdTypeCd + ", apiActv=" + apiActv + "]";
    }
}
