package com.example.demo.listener;

import com.example.demo.exception.CepNotFoundException;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.producer.ProducerToPersonPoisonQueue;
import com.example.demo.service.SavePersonFacade;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidAddressPersonListenerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @InjectMocks
    private ValidAddressPersonListener validAddressPersonListener;
    @Mock
    private SavePersonFacade savePersonFacade;
    @Mock
    private PersonMapper personMapper;
    @Spy
    private ProducerToPersonPoisonQueue producer;

    @Test
    public void erroAoMapperQuandoMensagemForInvalida() throws CepNotFoundException {
        doThrow(CepNotFoundException.class)
                .when(savePersonFacade).save(any());

        doNothing().when(producer).sendToPersonPoisonQueue(any(), any());

        validAddressPersonListener.receiver("error");

        verify(producer, times(1))
                .sendToPersonPoisonQueue(any(), any());
    }
}
