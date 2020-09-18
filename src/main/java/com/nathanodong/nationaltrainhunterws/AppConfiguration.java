package com.nathanodong.nationaltrainhunterws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thalesgroup.rtti._2013_11_28.token.types.AccessToken;
import com.thalesgroup.rtti._2017_10_01.ldb.LDBServiceSoap;
import com.thalesgroup.rtti._2017_10_01.ldb.Ldb;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.frontend.ClientProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${nationalrail.ldb.token}")
    private String LDB_TOKEN;

    @Bean
    public AccessToken accessToken(){
        AccessToken accessToken = new AccessToken();
        accessToken.setTokenValue(LDB_TOKEN);

        return accessToken;
    }

    @Bean
    public Ldb ldb() {
        return new Ldb();
    }

    @Bean
    public LDBServiceSoap ldbServiceSoap(Ldb ldb) {
        return ldb.getLDBServiceSoap12();
    }

    @Bean
    public Client client(LDBServiceSoap ldbServiceSoap) {
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
}
