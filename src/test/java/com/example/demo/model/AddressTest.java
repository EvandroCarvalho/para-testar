package com.example.demo.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressTest {

    @Test
    public void pojoTest() {
        assertPojoMethodsFor(Address.class)
                .testing(Method.GETTER, Method.SETTER,
                        Method.CONSTRUCTOR)
                .areWellImplemented();
    }

}