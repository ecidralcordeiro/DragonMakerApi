package com.uextest.services;

import com.uextest.models.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    public ViaCepResponse getCepDetails(String cep) {
        String url = viaCepUrl + cep + "/json";
        return restTemplate.getForObject(url, ViaCepResponse.class);
    }
}
