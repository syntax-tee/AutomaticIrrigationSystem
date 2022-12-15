package com.ogunladetaiye.automaticirrigationsystem.dto.request;

import com.ogunladetaiye.automaticirrigationsystem.dto.enums.SoilTypes;
import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlotRequest {

    @NotNull
    private String plotName;

    @NotNull
    private double length;

    @NotNull
    private double width;

    @NotNull
    private String soilType;

    public Plot toEntity() {
        return Plot.builder()
                .plotName(this.plotName)
                .length(this.length)
                .width(this.width)
                .soilType(SoilTypes.valueOf(this.soilType).name())
                .build();
    }
}
