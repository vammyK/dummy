package com.fileconverter.fileconverter.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="account")
public class Account {


    String currency;
    String accountId;
    String accountOwnerId;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountOwnerId() {
        return accountOwnerId;
    }

    public void setAccountOwnerId(String accountOwnerId) {
        this.accountOwnerId = accountOwnerId;
    }
}
