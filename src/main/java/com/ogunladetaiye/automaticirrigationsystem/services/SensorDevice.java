package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.enums.SensorStatus;
import com.ogunladetaiye.automaticirrigationsystem.respository.TimeSlotRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SensorDevice {

    private SensorStatus sensorStatus;

    private TimeSlotRepository timeSlotRepository;


    public SensorDevice(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }





}


