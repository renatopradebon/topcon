package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Vaga;

@RepositoryRestResource(collectionResourceRel="vaga",path="vaga",exported=true)
public interface VagaRepository extends PagingAndSortingRepository<Vaga, Long> {

}
