package com.example.demo.service.impl;

import com.example.demo.builder.PersonDtoBuilder;
import com.example.demo.exception.CepNotFoundException;
import com.example.demo.model.CepResponse;
import com.example.demo.model.Person;
import com.example.demo.model.PersonDto;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.ConsultCepService;
import com.example.demo.service.SavePersonFacade;
import com.example.demo.util.CpfCnpjValidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class SavePersonFacadeImpl implements SavePersonFacade {

    private final ConsultCepService consultCepService;
    private final PersonRepository repository;

    public void save(Person person) throws IllegalArgumentException, CepNotFoundException {

        validateCpf(person.getCpf());

        CepResponse cepResponse = consultCepAddress(person.getCep());

    PersonDto personDto = buildPersonDto(person, cepResponse);

    savePersonDto(personDto);

}

    @Override
    public void validateCpf(String cpf) {
        boolean valid = CpfCnpjValidate.isValid(cpf);
        if (!valid) {
            throw new IllegalArgumentException("cpf invalido!");
        }
    }

    @Override
    public CepResponse consultCepAddress(String cep) throws CepNotFoundException {
        return consultCepService.getCepDetails(cep);
    }

    @Override
    public PersonDto buildPersonDto(Person person, CepResponse cepResponse) {
        return PersonDtoBuilder.build(person, cepResponse);
    }

    @Override
    public void savePersonDto(PersonDto person) {
        repository.save(person);
    }

}
