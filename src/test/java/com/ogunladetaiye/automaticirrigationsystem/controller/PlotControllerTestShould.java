package com.ogunladetaiye.automaticirrigationsystem.controller;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


class PlotControllerTestShould {

    private Integer port = 8081;
    private String CONTEXT_PATH = "/irrigation/";
    private String API_PATH = "api/v1/plots/";

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void getPlotByReturnSuccessfully() {
        int id = 2;
        var response =
                given()
                        .pathParam("id", id)
                        .when()
                        .get(CONTEXT_PATH + API_PATH + "{id}")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("id", equalTo(2))
                        .body("length", equalTo(76.78F))
                        .body("width", equalTo(25.94F))
                        .body("plotName", equalTo("Plot 2"))
                        .body("soilType", equalTo("CLAY"))
                        .body("longitude", equalTo(34.5F))
                        .body("latitude", equalTo(39.8F))
                        .body("soilMoisture", equalTo(13.8F))
                        .body("cropType", equalTo("vegetable"));
    }

    @Test
    void getAllPlotSizeReturnSuccessfully() {
        var response =
                given().when()
                        .get(CONTEXT_PATH + API_PATH).then()
                        .statusCode(HttpStatus.OK.value());
        Assertions.assertThat(response.body("size()", is(4)));
    }


}