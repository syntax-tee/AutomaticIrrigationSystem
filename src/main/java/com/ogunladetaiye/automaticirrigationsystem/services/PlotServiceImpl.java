package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.request.PlotRequest;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.PlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.TimeSlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.exception.PlotOfLandNotFoundException;
import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import com.ogunladetaiye.automaticirrigationsystem.respository.PlotRepository;
import com.ogunladetaiye.automaticirrigationsystem.respository.TimeSlotRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ogunladetaiye.automaticirrigationsystem.dto.response.PlotResponse.fromEntity;

@Log4j2
@Service
public class PlotServiceImpl implements PlotService {

    private PlotRepository plotRepository;
    private TimeSlotRepository timeSlotRepository;

    public PlotServiceImpl(PlotRepository plotRepository, TimeSlotRepository timeSlotRepository) {
        this.plotRepository = plotRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public List<PlotResponse> getAllPlots() {
        if (plotRepository.findAll().isEmpty()) {
            return Collections.emptyList();
        } else {
            return plotRepository.findAll().stream().map(PlotResponse::fromEntity).collect(Collectors.toList());
        }
    }

    @Override
    public Optional<PlotResponse> getPlotById(Long id) {
        var plot = plotRepository.findById(id).map(PlotResponse::fromEntity).orElseThrow(() -> new PlotOfLandNotFoundException(String.format("No plot of land with id %s  is found", id)));
        if (plot != null) {
            return Optional.of(plot);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PlotResponse configurePlotOfLand(Long id, @Valid PlotRequest plotRequest) {
        PlotResponse existingPlotOfland = plotRepository.findById(id).map(PlotResponse::fromEntity).orElseThrow(() -> new PlotOfLandNotFoundException(String.format("No plot of land with id %s is found", id)));

        existingPlotOfland.setPlotName(plotRequest.getPlotName());
        existingPlotOfland.setWidth(plotRequest.getWidth());
        existingPlotOfland.setSoilType(plotRequest.getSoilType());
        existingPlotOfland.setLength(plotRequest.getLength());

        plotRepository.editPlot(id, existingPlotOfland.getLength(), existingPlotOfland.getWidth(), existingPlotOfland.getPlotName(), existingPlotOfland.getSoilType());
        Plot plot = plotRepository.findPlotById(id);
        return fromEntity(plot);
    }

    @Override
    public PlotResponse createPlot(@Valid PlotRequest plotRequest) {
        Plot plot = plotRepository.save(plotRequest.toEntity());
        return fromEntity(plot);
    }

    @Override
    public PlotResponse updatePlotOfLand(Long id, @Valid  PlotRequest plotRequest) {

        PlotResponse existingPlotOfland = plotRepository.findById(id).map(PlotResponse::fromEntity).orElseThrow(() -> new PlotOfLandNotFoundException(String.format("No plot of land with id %s ", id)));

        existingPlotOfland.setPlotName(plotRequest.getPlotName());
        existingPlotOfland.setWidth(plotRequest.getWidth());
        existingPlotOfland.setSoilType(plotRequest.getSoilType());
        existingPlotOfland.setLength(plotRequest.getLength());

        plotRepository.editPlot(id, existingPlotOfland.getLength(), existingPlotOfland.getWidth(), existingPlotOfland.getPlotName(), existingPlotOfland.getSoilType());
        Plot plot = plotRepository.findPlotById(id);
        return fromEntity(plot);
    }

    @Override
    public List<TimeSlotResponse> getTimeSlotsByPlotId(Long id) {
        var plot = plotRepository.findPlotById(id);
        return plot.getTimeSlots().stream().map(TimeSlotResponse::fromEntity).collect(Collectors.toList());
    }

}
