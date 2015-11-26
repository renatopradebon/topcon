package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Correspondencia;

@RepositoryRestResource(collectionResourceRel="correspondencia",path="correspondencia",exported=true)
public interface CorrespondenciaRepository extends PagingAndSortingRepository<Correspondencia, Long>{

}
