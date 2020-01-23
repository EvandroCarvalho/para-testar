package com.example.demo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * @author Evandro Carvalho on jan, 2020
 */
public class ConvertToJson {

    private static final ObjectMapper mapper = ObjectMapperCustomSingleton.INSTANCE;

    @SneakyThrows
    public static String convert(Object object) {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }
}
