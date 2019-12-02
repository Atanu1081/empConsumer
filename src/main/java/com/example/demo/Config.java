package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config
{
    @Bean
    public Jaxb2Marshaller marshaller()
    {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("pojoClasses");
        return marshaller;
    }

    @Bean
    public SOAPConnector soapConnector (Jaxb2Marshaller marshaller)
    {
        SOAPConnector connector = new SOAPConnector();
        connector.setDefaultUri("");
        connector.setMarshaller(marshaller);
        connector.setUnmarshaller(marshaller);
        return connector;
    }

}
