package com.ogunladetaiye.automaticirrigationsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "time_slots")
@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "schedule_time")
    private LocalTime scheduleTime;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "water_quantity")
    private double waterQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plot_id")
    @JsonIgnore
    private Plot plot;

    @Column(name = "status")
    private String status;
}
