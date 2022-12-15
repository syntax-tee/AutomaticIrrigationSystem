package com.ogunladetaiye.automaticirrigationsystem.respository;

import com.ogunladetaiye.automaticirrigationsystem.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = """
             UPDATE time_slots t
             SET 
             current_status=:current_status   
             WHERE  t.plot_id =:id
            """)
    void updateTimeSlotStatus(@Param(value = "id") Long id, @Param(value = "current_status") String current_status);

    TimeSlot findTimeSlotByPlotId(Long id);


}