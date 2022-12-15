package com.ogunladetaiye.automaticirrigationsystem.respository;

import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class PlotRepositoryTestShould {

    @Autowired
    private PlotRepository plotRepository;

    @Mock
    private TestEntityManager testEntityManager;

    @Test
    @DisplayName("Retrieve PlotName")
    void confirmThatPlotNameCanBeRetrieved() {
        //when
        Optional<Plot> plot = plotRepository.findPlotByPlotName("Plot 1");

        //then
        assertThat(plot.get().getPlotName()).isEqualTo(plot.get().getPlotName());
    }

    @Test
    @DisplayName("Confirm Size of Persited Plot of Lands")
    void confirmSizeOfDataInSchema() {
        //when
        List<Plot> plot = plotRepository.findAll();

        //then
        assertThat(plot.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("Retrieve entity by PlotId")
    void confirmThatPlotCanBeRetrievedById() {

        //when
        Optional<Plot> plot = plotRepository.findById(1L);

        //then
        assertThat(plot.get().getSoilType()).isEqualTo("LOAMY");
    }

    @Test
    @DisplayName("Persist plot entity")
    void persistDataToPlotEntity() {
          //        Plot newPlot = Plot.builder()
//                .plotName("Plot 8")
//                .length(23.4)
//                .width(45.6)
//                .soilType("CLAY")
//                .cropType("cereal")
//                .soilMoisture(33.5)
//                .longitude(56.5)
//                .latitude(47.4).build();
//
//        //when
//        Plot plot = plotRepository.save(newPlot);
//
//        assertThat(plot.getPlotName()).isEqualTo(newPlot.getPlotName());
    }
}