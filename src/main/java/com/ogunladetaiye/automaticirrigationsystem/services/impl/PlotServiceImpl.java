package com.ogunladetaiye.automaticirrigationsystem.services.impl;

import com.ogunladetaiye.automaticirrigationsystem.dto.PlotRequest;
import com.ogunladetaiye.automaticirrigationsystem.dto.PlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.exception.PlotOfLandNotFoundException;
import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import com.ogunladetaiye.automaticirrigationsystem.respository.PlotRepository;
import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ogunladetaiye.automaticirrigationsystem.dto.PlotResponse.fromEntity;

@Service
public class PlotServiceImpl implements PlotService {

    private PlotRepository plotRepository;

    public PlotServiceImpl(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    @Override
    public List<PlotResponse> getAllPlots() {
        return plotRepository.findAll().stream().map(PlotResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<PlotResponse> getPlotById(Long id) {
        var plot = plotRepository.findById(id).map(PlotResponse::fromEntity).orElseThrow(() -> new PlotOfLandNotFoundException(String.format("No plot of land with id %s  is found", id)));
        System.out.println("plot"+plot);
        if (plot != null) {
            return Optional.of(plot);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PlotResponse configurePlotOfLand(Long id, PlotRequest plotRequest) {
        PlotResponse plotTobeConfigured = plotRepository.findById(id).map(PlotResponse::fromEntity).orElseThrow(() -> new PlotOfLandNotFoundException(String.format("No plot of land with id %s  is found", id)));

        plotTobeConfigured.setPlotName(plotRequest.getPlotName());
        plotTobeConfigured.setWidth(plotRequest.getWidth());
        plotTobeConfigured.setSoilType(plotRequest.getSoilType());
        plotTobeConfigured.setLength(plotRequest.getLength());

        Plot plot = plotRepository.save(PlotResponse.toEntity(plotTobeConfigured));
        return fromEntity(plot);
    }

    @Override
    public PlotResponse createPlot(PlotRequest plotRequest) {
        Plot plot = plotRepository.save(plotRequest.toEntity());
        return fromEntity(plot);
    }

    @Override
    public PlotResponse updatePlotOfLand(Long id, PlotRequest plotRequest) {

        PlotResponse existingPlotOfland = plotRepository.findById(id).map(PlotResponse::fromEntity).orElseThrow(() -> new PlotOfLandNotFoundException(String.format("No plot of land with id %s ", id)));

        existingPlotOfland.setPlotName(plotRequest.getPlotName());
        existingPlotOfland.setWidth(plotRequest.getWidth());
        existingPlotOfland.setSoilType(plotRequest.getSoilType());
        existingPlotOfland.setLength(plotRequest.getLength());

        Plot plot = plotRepository.save(PlotResponse.toEntity(existingPlotOfland));
        return fromEntity(plot);
    }
}
