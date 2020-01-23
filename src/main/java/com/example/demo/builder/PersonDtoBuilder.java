package com.example.demo.builder;

import com.example.demo.model.Address;
import com.example.demo.model.CepResponse;
import com.example.demo.model.Person;
import com.example.demo.model.PersonDto;

/**
 * @author Evandro Carvalho on jan, 2020
 */
public class PersonDtoBuilder {

    public static PersonDto build(Person person, CepResponse cepResponse) {
        return PersonDto.builder()
                .name(person.getName())
                .cpf(person.getCpf())
                .address(
                        Address.builder()
                        .cep(cepResponse.getCep())
                        .estado(cepResponse.getUf())
                        .cidade(cepResponse.getLocalidade())
                        .bairro(cepResponse.getBairro())
                        .rua(cepResponse.getLogradouro())
                        .build()
                )
                .build();
    }
}
