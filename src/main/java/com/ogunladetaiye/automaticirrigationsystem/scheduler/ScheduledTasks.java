package com.ogunladetaiye.automaticirrigationsystem.scheduler;

import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Log4j2
@Component
@Configuration
@EnableAsync
//@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private PlotService plotService;

    /**
     * TODO
     * Trigger an event when time slot is found
     */
    @Async
    @Scheduled(cron = "*/10 * * * * *")
    public void sendUpdate() {
        var timeSlots = plotService.getTimeSlotsByPlotId(1L);
        System.out.println("TimeSlots" + timeSlots.size());
        timeSlots.stream().forEach(System.out::println);
        log.info("Scheduling task");
    }


}