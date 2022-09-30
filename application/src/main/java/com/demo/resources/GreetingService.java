package com.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {
    @Autowired
    RestTemplate restClient;

    @Value("${message.provider.url}")
    private String remoteServerBaseUrl;

    public Greeting getGreeting(String name) {
        Message message = restClient.getForObject(remoteServerBaseUrl + "/message" + "?name=" + name, Message.class);
        return new Greeting(message.getId(), message.getMessage());
    }
}
