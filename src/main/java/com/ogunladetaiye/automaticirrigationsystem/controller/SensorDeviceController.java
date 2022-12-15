package com.ogunladetaiye.automaticirrigationsystem.controller;


import com.ogunladetaiye.automaticirrigationsystem.dto.response.TimeSlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("api/v1/time_slots")
@Tag(name = "Sensor Controller", description = "")
public class SensorDeviceController {


    private PlotService plotService;

    public SensorDeviceController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping("/{id}")
    List<TimeSlotResponse> getTimeSlotsById(@PathVariable Long id) {
        return plotService.getTimeSlotsByPlotId(id);
    }

}
