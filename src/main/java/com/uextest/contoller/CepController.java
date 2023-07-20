package com.uextest.contoller;

import com.uextest.model.ViaCepResponse;
import com.uextest.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

    private ViaCepService viaCepService;

    public CepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("/cep/{cep}")
    public ViaCepResponse getCepDetails(@PathVariable String cep) {
        return viaCepService.getCepDetails(cep);
    }
}
