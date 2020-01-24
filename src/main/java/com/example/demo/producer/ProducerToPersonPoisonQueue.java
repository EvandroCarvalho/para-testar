package com.example.demo.producer;

import com.example.demo.mapper.PersonToTreatModel;
import com.example.demo.model.Person;
import com.example.demo.util.ConvertToJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Slf4j
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProducerToPersonPoisonQueue {

    private JmsTemplate jmsTemplate;

    public void sendToPersonPoisonQueue(final String errorDescription, final Person person) {
        final PersonToTreatModel personToTreatModel = createPersonToTreatModel(errorDescription, person);
        final String message = ConvertToJson.convert(personToTreatModel);

        log.info("send to poison queue: {}", message);
        jmsTemplate.convertAndSend("queue.poisonQueuePerson", message);
    }

    private PersonToTreatModel createPersonToTreatModel(final String errorDescription, final Person person) {
        return new PersonToTreatModel(errorDescription, person);
    }
}
