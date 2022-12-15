package com.ogunladetaiye.automaticirrigationsystem.dto.response;

import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

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
    private double longitude;
    private double latitude;
    private double soilMoisture;
    private String cropType;


    public static PlotResponse fromEntity(Plot plot) {
        return PlotResponse.builder()
                .id(plot.getId())
                .plotName(plot.getPlotName())
                .width(plot.getWidth())
                .length(plot.getLength())
                .soilType(plot.getSoilType())
                .cropType(plot.getCropType())
                .soilMoisture(plot.getSoilMoisture())
                .latitude(plot.getLatitude())
                .longitude(plot.getLongitude())
                .build();
    }

    public static Plot toEntity(PlotResponse plot) {
        return Plot.builder()
                .id(plot.getId())
                .plotName(plot.getPlotName())
                .width(plot.getWidth())
                .length(plot.getLength())
                .soilType(plot.getSoilType())
                .cropType(plot.getCropType())
                .soilMoisture(plot.getSoilMoisture())
                .latitude(plot.getLatitude())
                .longitude(plot.getLongitude())
                .build();
    }

}