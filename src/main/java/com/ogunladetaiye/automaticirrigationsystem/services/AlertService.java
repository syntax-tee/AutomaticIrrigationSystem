package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.AlertMessage;

public interface AlertService {
    void sendSMSAlert(AlertMessage alertMessage);
}
