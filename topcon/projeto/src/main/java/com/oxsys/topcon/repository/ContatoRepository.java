package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Contato;

@RepositoryRestResource(collectionResourceRel = "contato", path = "contato", exported = true)
public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long>{

}
