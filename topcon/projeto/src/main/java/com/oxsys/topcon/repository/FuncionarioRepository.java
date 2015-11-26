package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Funcionario;

@RepositoryRestResource(collectionResourceRel="funcionario",path="funcionario",exported=true)
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long>{

}
