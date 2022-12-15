package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.enums.SensorStatus;
import com.ogunladetaiye.automaticirrigationsystem.respository.TimeSlotRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SensorServiceDeviceImpl {

    private SensorStatus sensorStatus;

    private TimeSlotRepository timeSlotRepository;


    public SensorServiceDeviceImpl(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }





}


