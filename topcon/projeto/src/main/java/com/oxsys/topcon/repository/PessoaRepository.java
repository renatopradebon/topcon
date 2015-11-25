package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Pessoa;

@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoa", exported = true)
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>  {
	
}
