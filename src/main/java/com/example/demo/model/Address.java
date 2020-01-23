package com.example.demo.model;

import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ENDERECO")
@Entity
public class Address {

    @Id
    @Column(name = "ID_ADDRESS", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAddress;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "RUA")
    private String rua;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;
}
