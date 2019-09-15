package com.fileconverter.fileconverter.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="portfolio")
public class PortfolioRequest {


    String portfolioName;
    String portfolioOwnerId;
    String portfolioNumber;

    List<Account> accounts;
    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getPortfolioOwnerId() {
        return portfolioOwnerId;
    }

    public void setPortfolioOwnerId(String portfolioOwnerId) {
        this.portfolioOwnerId = portfolioOwnerId;
    }

    public String getPortfolioNumber() {
        return portfolioNumber;
    }

    public void setPortfolioNumber(String portfolioNumber) {
        this.portfolioNumber = portfolioNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
