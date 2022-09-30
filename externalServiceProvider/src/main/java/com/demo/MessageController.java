package com.demo;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MessageController {

    private final String[] statuses = {"STARTING", "RUNNING", "STOPPING", "STOPPED"};
    private final AtomicInteger id = new AtomicInteger();

    @GetMapping(value = "/message", produces = APPLICATION_JSON_VALUE)
    public Message message(@RequestParam(value = "name", defaultValue = "World") String name) {
        String messageTemplate = "Hello, %s!!";
        return new Message(id.incrementAndGet(), String.format(messageTemplate, name));
    }

    @GetMapping(value = "/healthcheck", produces = APPLICATION_JSON_VALUE)
    public Map<String, String> healthCheck() {
        AtomicInteger counter = new AtomicInteger();
        Map<String, String> map = new HashMap<>();
        map.put("status", statuses[counter.incrementAndGet() % 4]);
        return map;
    }

    @PostMapping(value = "/echo", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Map<String, String> echo(@RequestBody Map<String, String> reqBody) {
        Map<String, String> body = new HashMap<>();
        body.put("name", reqBody.get("name"));
        body.put("city", reqBody.get("city"));
        return body;
    }

    @PostMapping(value = "/check", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Map<String, String> check(@RequestBody Person person) {
        Map<String, String> map = new HashMap<>();
        map.put("status", person.getAge() > 19 ? "OK" : "NOT_OK");
        return map;
    }
}
