package com.uextest.controllers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @GetMapping("/{UF}")
    public ResponseEntity<List<String>> getCities(@PathVariable String UF) {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + UF + "/municipios";


        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        if (response != null) {
            return ResponseEntity.ok(Collections.singletonList(response));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
