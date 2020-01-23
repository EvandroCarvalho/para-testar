package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSON")
@Entity
public class PersonDto {

    @Id
    @Column(name = "ID_PERSON", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    @Column(name = "NOME_CLIENTE", nullable = false)
    private String name;
    @Column(name = "CPF_CLIENTE", nullable = false)
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "ID_ADDRESS", name = "ADDRESS_ID")
    private Address address;
}
