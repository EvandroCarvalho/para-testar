package com.example.demo.controller;

import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@RestController
@RequestMapping(path = "/person")
@Slf4j
public class GetPerson {

    @PostMapping
    public String test(@Valid @RequestBody Person person) {
        log.info(person.toString());
        return "ok";
    }

    @GetMapping
    public String test2() {
        return "get";
    }
}
