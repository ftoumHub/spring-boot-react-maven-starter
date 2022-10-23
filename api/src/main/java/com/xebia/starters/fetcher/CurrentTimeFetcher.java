package com.xebia.starters.fetcher;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CurrentTimeFetcher {

    @QueryMapping()
    public String currentTime() {
        System.out.println("currentTime");
        final LocalTime now = LocalTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(dtf2);
    }
}
