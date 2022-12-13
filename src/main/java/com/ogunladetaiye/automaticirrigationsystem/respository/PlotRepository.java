package com.ogunladetaiye.automaticirrigationsystem.respository;

import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<Plot,Long> {
}
