package com.uextest.services;

import com.uextest.models.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    @Value("${viaCep.url}")
    private String viaCepUrl;

    private final RestTemplate restTemplate;

    public ViaCepService(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponse getCepDetails(String text) {
        String url = viaCepUrl + text + "/json";
        ResponseEntity<ViaCepResponse[]> responseEntity = restTemplate.getForEntity(url, ViaCepResponse[].class);
        ViaCepResponse[] responses = responseEntity.getBody();
        if (responses != null && responses.length > 0) {
            return responses[0];
        } else {
            return null;
        }
    }
}
