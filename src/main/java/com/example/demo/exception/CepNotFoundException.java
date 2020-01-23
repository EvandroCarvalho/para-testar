package com.example.demo.exception;

/**
 * @author Evandro Carvalho on jan, 2020
 */
public class CepNotFoundException extends Exception {

    public CepNotFoundException(String error, Throwable t) {
        super(error, t);
    }
}
