package com.ogunladetaiye.automaticirrigationsystem.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(cron = "*/10 * * * * *")
    public void sendUpdate() {
        logger.info("We have {} a task");
    }

}