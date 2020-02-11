package com.utpl.plansvalidator.sql.componente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponenteRepository extends CrudRepository<Componente, Integer> {
    Optional<Componente> findByCodigo(String codigo);
}
