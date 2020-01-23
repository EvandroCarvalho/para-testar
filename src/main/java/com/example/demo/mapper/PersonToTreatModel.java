package com.example.demo.mapper;

import com.example.demo.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("person_model")
public class PersonToTreatModel {

    @JsonProperty(value = "error_description")
    private String error;

    @JsonProperty(value = "person_object")
    private Person person;

}
