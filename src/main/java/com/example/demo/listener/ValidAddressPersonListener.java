package com.example.demo.listener;

import com.example.demo.exception.CepNotFoundException;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.producer.ProducerToPersonPoisonQueue;
import com.example.demo.service.SavePersonFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Component
@Slf4j
@RequiredArgsConstructor
@Validated
public class ValidAddressPersonListener {

    private final SavePersonFacade savePersonFacade;
    private final PersonMapper personMapper;
    private final ProducerToPersonPoisonQueue producer;

    @JmsListener(destination = "${queue.person}")
    public void receiver(String message) {
        Person person = null;
        try {
             person = personMapper.from(message);
            savePersonFacade.save(person);

        } catch (IOException | IllegalArgumentException e) {
            log.info(String.valueOf(e));
            producer.sendToPersonPoisonQueue(e.getMessage(), person);

        } catch (CepNotFoundException e) {
            log.info("cep informado é invalido");
            producer.sendToPersonPoisonQueue(e.getMessage(), person);
        }
    }
}
