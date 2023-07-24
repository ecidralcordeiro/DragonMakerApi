package com.uextest.controllers;

import com.uextest.models.ViaCepResponse;
import com.uextest.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/viacep")
public class ViaCepController {
    private final ViaCepService viaCepService;

    @Autowired
    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("/{state}/{city}/{street}")
    public ResponseEntity<ViaCepResponse> getCepDetails(
            @PathVariable String state,
            @PathVariable String city,
            @PathVariable String street
    ) {
        String url = state + "/" + city + "/" + street;
        ViaCepResponse viaCepResponse = viaCepService.getCepDetails(url);
        if (viaCepResponse != null) {
            return ResponseEntity.ok(viaCepResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
