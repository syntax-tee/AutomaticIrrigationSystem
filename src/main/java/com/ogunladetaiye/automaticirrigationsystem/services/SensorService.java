package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.response.TimeSlotResponse;

import java.util.List;

public interface SensorService {
    List<TimeSlotResponse> sendIrrigationPrompt(Long plotId);
}
