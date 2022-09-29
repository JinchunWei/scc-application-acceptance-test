package com.demo.resources;


import java.time.LocalDateTime;

public class Greeting {
    private final long id;
    private final LocalDateTime dateTime;
    private final String greeting;

    public Greeting(long id, String greeting) {
        this.id = id;
        this.greeting = greeting;
        this.dateTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getGreeting() {
        return greeting;
    }

    @Override
    public String toString() {
        return "Greeting{" +
            "id=" + id +
            ", dateTime=" + dateTime +
            ", greeting='" + greeting + '\'' +
            '}';
    }
}
