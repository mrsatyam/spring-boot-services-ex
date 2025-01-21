package com.axisbank.limit.dto.comm.response;
public class ResponseBody {
    private String status;
    private String responceCode;
    private String mobileNumber;
    private String emailId;
    private String secureFlag;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponceCode() {
        return responceCode;
    }

    public void setResponceCode(String responceCode) {
        this.responceCode = responceCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSecureFlag() {
        return secureFlag;
    }

    public void setSecureFlag(String secureFlag) {
        this.secureFlag = secureFlag;
    }
}
