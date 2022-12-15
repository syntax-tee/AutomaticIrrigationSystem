package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.request.PlotRequest;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.PlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.TimeSlotResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlotService {

    List<PlotResponse> getAllPlots();

    Optional<PlotResponse> getPlotById(Long id);

    PlotResponse configurePlotOfLand(Long id,PlotRequest request);

    PlotResponse createPlot(PlotRequest request);

    PlotResponse updatePlotOfLand(Long id,PlotRequest request);

    List<TimeSlotResponse> getTimeSlotsByPlotId(Long id);

    TimeSlotResponse getTimeSlotByPlotId(Long id);

}
