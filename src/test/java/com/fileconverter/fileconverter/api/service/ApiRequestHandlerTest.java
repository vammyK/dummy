package com.fileconverter.fileconverter.api.service;


import com.fileconverter.fileconverter.FileconverterApplicationTests;
import com.fileconverter.fileconverter.model.PortfolioRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

import static org.junit.Assert.*;


public class ApiRequestHandlerTest extends FileconverterApplicationTests {
    @Autowired
    ApiRequestHandler apiRequestHandler;

    @Test
    public void process() {
        InputStream is = this.getClass().getResourceAsStream("/portfolio.xml");
        JAXBContext jaxbContext     = null;
        Unmarshaller jaxbUnmarshaller = null;
        try {
            jaxbContext = JAXBContext.newInstance( PortfolioRequest.class );
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            PortfolioRequest portfolioRequest = (PortfolioRequest) jaxbUnmarshaller.unmarshal( is );
            String response=apiRequestHandler.process(portfolioRequest);
            assertEquals(portfolioRequest.getPortfolioName(),response);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
