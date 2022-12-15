package com.ogunladetaiye.automaticirrigationsystem.controller;

import com.ogunladetaiye.automaticirrigationsystem.dto.AlertMessage;
import com.ogunladetaiye.automaticirrigationsystem.services.AlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/alert")
@Tag(name = "Alert Controller", description = "This REST controller provides alert service via Twillio API")
public class AlertController {

    @Autowired
    AlertService alertService;

    @PostMapping("/sms")
    public ResponseEntity<String> sendAlertMessage(@RequestBody AlertMessage alertMessage) {
        alertService.sendSMSAlert(alertMessage);
        return new ResponseEntity<>("Alert Message Sent Successfully!", HttpStatus.OK);
    }
}