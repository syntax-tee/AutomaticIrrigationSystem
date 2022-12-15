package com.ogunladetaiye.automaticirrigationsystem.dto.response;

import com.ogunladetaiye.automaticirrigationsystem.model.TimeSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TimeSlotResponse {

    private Long id;

    private LocalTime startTime;

    private Integer duration;

    private double waterQuantity;

    private String status;

    public static TimeSlotResponse fromEntity(TimeSlot timeSlot) {
        return TimeSlotResponse.builder()
                .id(timeSlot.getId())
                .startTime(timeSlot.getStartTime())
                .duration(timeSlot.getDuration())
                .waterQuantity(timeSlot.getWaterQuantity())
                .status(timeSlot.getStatus())
                .build();
    }

}
