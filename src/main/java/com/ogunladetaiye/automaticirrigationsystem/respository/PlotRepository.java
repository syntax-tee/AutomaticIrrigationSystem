package com.ogunladetaiye.automaticirrigationsystem.respository;

import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlotRepository extends JpaRepository<Plot, Long> {

    Plot findPlotById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = """
             UPDATE plots p
             SET 
             length=:length,width=:width,plot_name=:plot_name,soil_type=:soil_type                
             WHERE  p.id =:id
            """)
    void editPlot(@Param(value = "id") Long id, @Param(value = "length") Double length, @Param(value = "width") Double width, @Param(value = "plot_name") String plot_name, @Param(value = "soil_type") String soil_type);

}
