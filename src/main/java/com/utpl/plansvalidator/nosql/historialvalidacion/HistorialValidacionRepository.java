package com.utpl.plansvalidator.nosql.historialvalidacion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HistorialValidacionRepository extends MongoRepository<HistorialValidacion, Long> {
}
