package com.example.demo.repository;

import com.example.demo.model.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evandro Carvalho on jan, 2020
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonDto, Long> {
}
