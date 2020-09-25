package com.nathanodong.nationaltrainhunterws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldbsv.LDBSVServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldbsv.Ldbsv;
import com.thalesgroup.rtti._2017_10_01.ldbsv.ObjectFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
public class AppConfiguration {

    @Value("${nationalrail.ldbsv.token}")
    private String LDBSV_TOKEN;

    @Value("${nationalrail.ldbsv.url}")
    private String NR_WS_URL;

    @Bean
    public URL nrUrl() throws Exception {
        return new URL(NR_WS_URL + "wsdl.aspx?refver=2015-05-14");
    }

    @Bean
    public AccessToken accessToken() {
        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue(LDBSV_TOKEN);

        return accessToken;
    }

    @Bean
    public Ldbsv ldbsv() throws Exception {
        Ldbsv ldbsv = new Ldbsv(nrUrl());
        return new Ldbsv();
    }

    @Bean
    public LDBSVServiceSoap ldbsvServiceSoap(Ldbsv ldbsv) {
        return ldbsv.getLDBSVServiceSoap12();
    }

    @Bean
    public Client client(LDBSVServiceSoap ldbServiceSoap) {
        Client client = ClientProxy.getClient(ldbServiceSoap);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        return client;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }
}
