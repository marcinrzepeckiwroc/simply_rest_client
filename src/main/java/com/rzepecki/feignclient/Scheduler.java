package com.rzepecki.feignclient;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private final FallbackSupportService fallbackSupportService;


    public Scheduler(FallbackSupportService fallbackSupportService) {
        this.fallbackSupportService = fallbackSupportService;
    }

    @Scheduled(fixedDelay = 10000)
    public void logAllUsersTasks() {
        fallbackSupportService.getUsersAndPrint();
    }
}
