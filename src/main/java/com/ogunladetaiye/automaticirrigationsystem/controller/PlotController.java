package com.ogunladetaiye.automaticirrigationsystem.controller;


import com.ogunladetaiye.automaticirrigationsystem.dto.request.PlotRequest;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.PlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.exception.PlotOfLandNotFoundException;
import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@RestController
@Validated
@RequestMapping("api/v1/plots")
@Tag(name = "Plot Controller", description = "This REST controller provides services to manage plots of land an Automatic Irrigation System")
public class PlotController {

    private PlotService plotService;

    public PlotController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Returns a list of plots")
    public List<PlotResponse> getAllPlots() {
        var allPlots = plotService.getAllPlots();
        if (allPlots.isEmpty()) {
            return Collections.emptyList();
        }else{
            return plotService.getAllPlots();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Returns a Plot by Id")
    public Optional<PlotResponse> getPlotById(@PathVariable("id") Long id) {
        var plot = plotService.getPlotById(id);
        if (plot.isEmpty()) {
            throw new PlotOfLandNotFoundException("Can't find a plot of land "+ " with id "+ id);
        } else {
            return plot;
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Creates a plot of land")
    public PlotResponse createPlotOfLand(@Valid @RequestBody PlotRequest plotRequest) {
        var response = plotService.createPlot(plotRequest);
        if (Objects.isNull(response)) {
            throw new PlotOfLandNotFoundException("Can't create a plot of land");
        }
        return response;
    }

    @PutMapping("/{id}")
    public PlotResponse editPlotOfLand(@PathVariable("id") Long id, @Valid @RequestBody PlotRequest plotRequest) {
        var response = plotService.updatePlotOfLand(id, plotRequest);
        if (Objects.isNull(response)) {
            throw new PlotOfLandNotFoundException("Can't update a plot of land "+ " with id "+ id);
        }
        return response;
    }

    @PutMapping("/{id}/configure")
    public PlotResponse configureOfLand(@PathVariable("id") Long id, @Valid @RequestBody PlotRequest plotRequest) {
        return plotService.configurePlotOfLand(id, plotRequest);
    }

}
