package com.example.demo.service;

import com.example.demo.exception.CepNotFoundException;
import com.example.demo.model.CepResponse;
import com.example.demo.model.Person;
import com.example.demo.util.ConvertToJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultCepService {

    private static final String MSG_ERROR = "##Erro na consulta do cep: %s";

    private final RestTemplate restTemplate;
    @Value("${url.viacep}")
    public String urlService;

    public CepResponse getCepDetails(String cepNumber) throws CepNotFoundException {

        try {
            ResponseEntity<CepResponse> response = restTemplate.getForEntity(urlService, CepResponse.class, cepNumber);
            CepResponse cepResponse = response.getBody();
            log.info("Response consult cep: " + ConvertToJson.convert(cepResponse));
            return cepResponse;
        } catch (HttpStatusCodeException e) {
            String error = String.format(String.format(MSG_ERROR, cepNumber));
            log.info(error, e);
            throw new CepNotFoundException(error, e);
        }
    }

}
