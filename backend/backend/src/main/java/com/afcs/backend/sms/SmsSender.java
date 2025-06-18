package com.afcs.backend.sms;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Collections;

@Service
public class SmsSender {

    private final AfricaTalkingProperties config;

    public SmsSender(AfricaTalkingProperties config) {
        this.config = config;
    }

    public void sendSms(String phone, String plate, double fee) {
        String message = "Habari,\n" +
                "Basi lako lenye usajili " + plate + ", ambalo limepita NaneNane Bus Terminal limeandikiwa deni la Tsh " + fee + " kama ushuru. \n" +
                "Hakikisha unalipa kiasi hicho kupitia namba ya simu " + config.getPaymentPhone() + " ndani ya siku 30 kutoka leo. \n" +
                "Ahsante.";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("apiKey", config.getApiKey());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", config.getUsername());
        map.add("to", phone);
        map.add("message", message);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(config.getSmsUrl(), request, String.class);
            System.out.println("SMS sent. Response: " + response.getBody());
        } catch (Exception e) {
            System.err.println("SMS sending failed: " + e.getMessage());
        }
    }
}
