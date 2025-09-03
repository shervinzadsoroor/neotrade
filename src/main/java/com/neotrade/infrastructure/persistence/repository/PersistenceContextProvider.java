package com.neotrade.infrastructure.persistence.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PersistenceContextProvider {

    @PersistenceContext
    EntityManager entityManager;
}
