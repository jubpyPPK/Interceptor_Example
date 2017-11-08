package com.example.test2.feature.ppk.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by napat on 9/6/2017 AD.
 */
public class SaveBankAccountRequest {

    @JsonProperty("request_trans")
    private String requestTrans;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    @JsonProperty("bank_account")
    private String bankAccount;

    private String channel;
    private String data;

    public String getRequestTrans() {
        return requestTrans;
    }

    public void setRequestTrans(String requestTrans) {
        this.requestTrans = requestTrans;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
