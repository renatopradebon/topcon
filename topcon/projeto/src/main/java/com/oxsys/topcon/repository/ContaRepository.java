package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Conta;

@RepositoryRestResource(collectionResourceRel = "conta", path = "conta", exported = true)
public interface ContaRepository extends PagingAndSortingRepository<Conta, Long>{

}
