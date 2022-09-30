package com.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GreetingController {
    @Autowired
    GreetingService service;

    @GetMapping(value = "/greeting", produces = APPLICATION_JSON_VALUE)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return service.getGreeting(name);
    }
}
