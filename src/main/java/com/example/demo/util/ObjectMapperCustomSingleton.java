package com.example.demo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author Evandro Carvalho on jan, 2020
 */
public enum ObjectMapperCustomSingleton {;

    ObjectMapperCustomSingleton() {

    }

    public static final ObjectMapper INSTANCE;

    static {
        INSTANCE = Jackson2ObjectMapperBuilder.json().build()
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

}
