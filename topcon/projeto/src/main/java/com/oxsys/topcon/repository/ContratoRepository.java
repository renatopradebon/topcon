package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Contrado;

@RepositoryRestResource(collectionResourceRel = "contrato", path = "contrato", exported = true)
public interface ContratoRepository extends PagingAndSortingRepository<Contrado, Long> {

}
