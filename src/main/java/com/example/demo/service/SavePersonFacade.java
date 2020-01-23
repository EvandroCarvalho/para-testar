package com.example.demo.service;

import com.example.demo.builder.PersonDtoBuilder;
import com.example.demo.exception.CepNotFoundException;
import com.example.demo.model.CepResponse;
import com.example.demo.model.Person;
import com.example.demo.model.PersonDto;

/**
 * @author Evandro Carvalho on jan, 2020
 */
public interface SavePersonFacade {

    void save(Person person) throws CepNotFoundException;

    void validateCpf(String cpf);

    CepResponse consultCepAddress(String cep) throws CepNotFoundException;

    PersonDto buildPersonDto(Person person, CepResponse cepResponse);

    void savePersonDtop(PersonDto person);

}
