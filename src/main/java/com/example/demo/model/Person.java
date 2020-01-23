package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.constraints.*;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Getter
@Setter
@NoArgsConstructor
@JsonRootName(value = "person")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Person {

    @JsonProperty(value = "name", required = true)
    @NotBlank(message = "Campo name é obrigatório")
    private String name;

    @EqualsAndHashCode.Include
    @JsonProperty(value = "cpf", required = true)
    @NotBlank(message = "Campo cpf é obrigatorio")
    @Size(max = 11, message = "cep invalido")
    private String cpf;

    @JsonProperty(value = "cep")
    @Size(max = 8, message = "cep invalido ")
    @NotBlank(message = "Campo cep é obrigadorio")
    private String cep;


//    @JsonCreator
//    public Person(@JsonProperty(value = "name",required = true) String name,
//                  @JsonProperty(value = "cpf", required = true) String cpf,
//                  @JsonProperty(value = "cep", required = true) String cep) {
//
//        this.name = name;
//        this.cpf = cpf;
//        this.cep = cep;
//    }

}

