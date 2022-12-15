package com.ogunladetaiye.automaticirrigationsystem.services;

import com.ogunladetaiye.automaticirrigationsystem.dto.AlertMessage;
import com.ogunladetaiye.automaticirrigationsystem.services.AlertService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AlertServiceImpl implements AlertService {

    @Value("${twilio.phone.number}")
    private String phoneNumber;

    @Value("${receiver.phone.number}")
    private String receiverPhoneNumber;

    /**
     * phoneNumber of the receiver as the first param
     * phoneNumber of the sender as the second param (Twilio number)
     * message (or alertMessage) as the third param
     */
    @Override
    public void sendSMSAlert(AlertMessage alertMessage) {
        Message.creator(new PhoneNumber(receiverPhoneNumber),
                new PhoneNumber(phoneNumber), alertMessage.getMessage()).create();
    }
}