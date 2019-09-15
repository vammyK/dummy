package com.fileconverter.fileconverter.api.service;

import com.fileconverter.fileconverter.model.PortfolioRequest;
import org.springframework.stereotype.Service;

@Service
public class ApiRequestHandler {

    public String process(PortfolioRequest pr){
        //TO OFS Message Ka logic
        return pr.getPortfolioName();
    }
}
