package com.ogunladetaiye.automaticirrigationsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "sensor_devices")
@Entity
public class SensorDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String deviceName;

    @Column(name="device_id", unique = true)
    private String deviceId;

    @OneToOne
    @JoinColumn(name = "plot_id", unique = true)
    @JsonIgnore
    private Plot plot;
}
