package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.util.ConvertToJson;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Component
public class Validation {

    private static final String MSG_ERROR = "Mensagem: %s \n Descrição do(s) Erro(s): %s";

    public void validate(Person person) throws IllegalArgumentException {
        ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Iterator<ConstraintViolation<Person>> iterator = validator.validate(person).iterator();
        List<String> errorList = new ArrayList<>();

        while (iterator.hasNext()) {
            ConstraintViolation<Person> violation = iterator.next();
            System.out.println(violation.getMessageTemplate());
            errorList.add(violation.getMessageTemplate());
        }

        if (!errorList.isEmpty()) {
            throw new IllegalArgumentException(String.format(MSG_ERROR, ConvertToJson.convert(person), errorList.toString()));
        }
    }
}
