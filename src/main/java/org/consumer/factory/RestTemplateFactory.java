package org.consumer.factory;

import org.springframework.web.client.RestTemplate;

public class RestTemplateFactory {

    private final RestTemplate restTemplate;

    private RestTemplateFactory(){
        restTemplate = new RestTemplate();
    }

    public final static RestTemplateFactory INSTANCE= new RestTemplateFactory();

    public RestTemplate getInstance(){
        return restTemplate;
    }

}
