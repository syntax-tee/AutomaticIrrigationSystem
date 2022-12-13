package com.ogunladetaiye.automaticirrigationsystem.controller;


import com.ogunladetaiye.automaticirrigationsystem.dto.PlotRequest;
import com.ogunladetaiye.automaticirrigationsystem.dto.PlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/plots")
@Tag(name = "Plot Controller", description = "This REST controller provides services to manage plots of land an Automatic Irrigation System")
public class PlotController {

    private PlotService plotService;

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping
    public List<PlotResponse> getAllPlots() {
        return plotService.getAllPlots();
    }

    @GetMapping("/{id}")
    public Optional<PlotResponse> getPlotById(@PathVariable("id") Long id) {
        return plotService.getPlotById(id);
    }

    @PostMapping
    public PlotResponse createPlotOfLand(@Valid @RequestBody PlotRequest plotRequest) {
        return plotService.createPlot(plotRequest);
    }

    @PostMapping("/{id}")
    public PlotResponse editPlotOfLand(@PathVariable("id") Long id, @Valid @RequestBody PlotRequest plotRequest) {
        return plotService.updatePlotOfLand(id, plotRequest);
    }

    @PostMapping("/{id}/configure")
    public PlotResponse configureOfLand(@PathVariable("id") Long id, @Valid @RequestBody PlotRequest plotRequest) {
        return plotService.configurePlotOfLand(id, plotRequest);
    }

}