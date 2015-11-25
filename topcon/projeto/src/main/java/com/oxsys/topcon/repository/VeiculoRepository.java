package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Veiculo;

@RepositoryRestResource(collectionResourceRel="veiculo",path="veiculo",exported=true)
public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Long>{

}
