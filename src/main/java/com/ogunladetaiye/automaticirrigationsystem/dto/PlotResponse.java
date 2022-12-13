package com.ogunladetaiye.automaticirrigationsystem.dto;

import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlotResponse {

    private Long id;
    private double length;
    private double width;
    private String plotName;
    private String soilType;


    public static PlotResponse fromEntity(Plot plot) {
        return PlotResponse.builder()
                .id(plot.getId())
                .plotName(plot.getPlotName())
                .width(plot.getWidth())
                .length(plot.getLength())
                .soilType(plot.getSoilType())
                .build();
    }

    public static Plot toEntity(PlotResponse plot) {
        return Plot.builder()
                .id(plot.getId())
                .plotName(plot.getPlotName())
                .width(plot.getWidth())
                .length(plot.getLength())
                .soilType(plot.getSoilType())
                .build();
    }

}