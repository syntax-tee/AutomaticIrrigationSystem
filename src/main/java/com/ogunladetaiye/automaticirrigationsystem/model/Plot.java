package com.ogunladetaiye.automaticirrigationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "plots")
@Entity
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "length")
    private double length;

    @Column(name = "width")
    private double width;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "plot_name")
    private String plotName;

    @Column(name = "soil_type")
    private String soilType;

    @Column(name = "soil_moisture")
    private double soilMoisture;

    @Column(name = "cropType")
    private String cropType;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "plot_id")
    private List<TimeSlot> timeSlots;

}
