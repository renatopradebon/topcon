package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Aviso;

@RepositoryRestResource(collectionResourceRel="aviso",path="aviso",exported=true)
public interface AvisoRepository extends PagingAndSortingRepository<Aviso, Long>{

}
