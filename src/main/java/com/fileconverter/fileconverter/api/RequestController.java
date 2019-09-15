package com.fileconverter.fileconverter.api;

import com.fileconverter.fileconverter.api.service.ApiRequestHandler;
import com.fileconverter.fileconverter.model.Account;
import com.fileconverter.fileconverter.model.PortfolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
@RestController("portfolio/")
public class RequestController {

    @Autowired
    ApiRequestHandler apiRequestHandler;

    @GetMapping(name = "getDummyPortfolio", produces = "application/xml")
    PortfolioRequest getPortfolioRequest(){
        PortfolioRequest pr= new PortfolioRequest();
        pr.setPortfolioName(UUID.randomUUID().toString());
        pr.setPortfolioNumber(UUID.randomUUID().toString());
        pr.setPortfolioOwnerId(UUID.randomUUID().toString());
        List<Account> accounts= new ArrayList<>();
        IntStream.range(0,4).forEach(i->{
            Account a= new Account();
            a.setAccountId(String.valueOf(i));
            a.setAccountOwnerId(UUID.randomUUID().toString());
            a.setCurrency(UUID.randomUUID().toString());
            accounts.add(a);
        });
        pr.setAccounts(accounts);

        return pr;
    }

    @PostMapping(name="create", consumes="application/xml",produces = "application/json")
    ResponseEntity<String> createPortfolio(PortfolioRequest portfolioRequest){

        return new ResponseEntity<String>(apiRequestHandler.process(portfolioRequest),HttpStatus.CREATED);
    }
}
