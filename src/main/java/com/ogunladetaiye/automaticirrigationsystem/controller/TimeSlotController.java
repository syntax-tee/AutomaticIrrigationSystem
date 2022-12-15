package com.ogunladetaiye.automaticirrigationsystem.controller;


import com.ogunladetaiye.automaticirrigationsystem.dto.enums.TimeSlotStatus;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.TimeSlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.respository.TimeSlotRepository;
import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/time_slots")
@Tag(name = "TimeSlot Controller", description = "")
public class TimeSlotController {


    private PlotService plotService;
    private TimeSlotRepository timeSlotRepository;

    public TimeSlotController(PlotService plotService, TimeSlotRepository timeSlotRepository) {
        this.plotService = plotService;
        this.timeSlotRepository = timeSlotRepository;
    }

    @GetMapping("/{id}")
    List<TimeSlotResponse> getTimeSlotsById(@PathVariable Long id) {
        return plotService.getTimeSlotsByPlotId(id);
    }

    @PutMapping("/{id}")
    TimeSlotResponse sendIrrigationNotice(@PathVariable Long id) {
       // timeSlotRepository.updateTimeSlotStatus(id, TimeSlotStatus.IRRIGATION_DONE.name());
        return TimeSlotResponse.fromEntity(timeSlotRepository.findTimeSlotByPlotId(id));
    }
}
