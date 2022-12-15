package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.request.PlotRequest;
import com.ogunladetaiye.automaticirrigationsystem.dto.response.PlotResponse;
import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import com.ogunladetaiye.automaticirrigationsystem.respository.PlotRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PlotServiceTestShould {


    @Autowired
    private PlotService plotService;

    @Autowired
    PlotRepository plotRepository;

    @DisplayName("Create  Plot of Land")
    @Test
    void createPlot() {

        //given
        PlotRequest plotRequest = PlotRequest.builder()
                .plotName("Plot 8")
                .length(23.4)
                .width(45.6)
                .soilType("CLAY")
                .cropType("cereal")
                .soilMoisture(33.5)
                .longitude(56.5)
                .latitude(47.4).build();

        //when
        PlotResponse plotResponse = plotService.createPlot(plotRequest);

        //then
        assertNotNull(plotResponse);
    }

    @DisplayName("Get  Plot By Id")
    @Test
    void getPlotById() {

        Plot newPlot = Plot.builder()
                .plotName("Plot 8")
                .length(23.4)
                .width(45.6)
                .soilType("CLAY")
                .cropType("cereal")
                .soilMoisture(33.5)
                .longitude(56.5)
                .latitude(47.4).build();

        //given
        Plot savedPlot = plotRepository.save(newPlot);

        //when
        Optional<PlotResponse> plot = plotService.getPlotById(savedPlot.getId());

        //then
        assertThat(savedPlot.getId()).isEqualTo(plot.get().getId());
    }

    @DisplayName("Get  Size of Plot")
    @Test
    void confirmPlotSize() {
        //when
        List<PlotResponse> plots = plotService.getAllPlots();

        //then
        assertThat(plots.size()).isEqualTo(4);
    }
}