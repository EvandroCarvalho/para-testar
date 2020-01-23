package com.example.demo.model;

import com.example.demo.util.ObjectMapperCustomSingleton;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * @author Evandro Carvalho on jan, 2020
 */
public class PersonTest {

    @Test
    public void personTest() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperCustomSingleton.INSTANCE;

        String json = "{\"person\":{\"name\":\"junior\"}}";

        Person person = mapper.readValue(json, Person.class);

        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

        System.out.println(s);
    }
}
