package com.example.demo.mapper;

import com.example.demo.model.Person;
import com.example.demo.service.Validation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Component
@RequiredArgsConstructor
@Validated
public class PersonMapper {

    private final ObjectMapper mapper;
    private final Validation validation;

    private Person person;

    public Person from(String message) throws JsonProcessingException, IllegalArgumentException {
        person = mapper.readValue(message, Person.class);
        validation.validate(person);

        return person;
    }
}
