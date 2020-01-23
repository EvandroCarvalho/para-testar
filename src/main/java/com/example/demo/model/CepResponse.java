package com.example.demo.model;

import lombok.*;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CepResponse {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemente;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;

}
