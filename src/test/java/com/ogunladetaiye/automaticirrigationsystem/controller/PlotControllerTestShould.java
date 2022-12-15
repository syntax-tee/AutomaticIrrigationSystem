package com.ogunladetaiye.automaticirrigationsystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.ogunladetaiye.automaticirrigationsystem.model.Plot;
import com.ogunladetaiye.automaticirrigationsystem.services.PlotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class PlotControllerTestShould {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlotService plotService;


//    INSERT INTO plots (id, plot_name, length, width, soil_type,crop_type,longitude,latitude,soil_moisture)
//    VALUES (1, 'Plot 1', 56.74, 95.74, 'LOAMY','cereal',34.5,39.8,13.8);
    @Test
    void createPlot_ofLand() throws Exception {
        Plot newPlot = Plot.builder()
                .id(1L)
                .plotName("Plot 1")
                .length(23.4)
                .width(45.6)
                .soilType("CLAY")
                .cropType("cereal")
                .soilMoisture(33.5)
                .longitude(56.5)
                .latitude(47.4).build();
        ObjectMapper objectMapper = new ObjectMapper();

        MockHttpServletResponse response = mockMvc.perform(post("/api/v1/plots")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newPlot)))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.plotName").value("Plot 1"))
                .andExpect(jsonPath("$.length").value(23.4))
                .andExpect(jsonPath("$.width").value(45.6))
                .andExpect(status().isOk()).andReturn().getResponse();

        Long id = JsonPath.parse(response.getContentAsString()).read("$.id");
        assertNotNull(plotService.getPlotById(id));
    }
}