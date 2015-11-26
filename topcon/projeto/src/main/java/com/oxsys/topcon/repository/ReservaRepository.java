package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oxsys.topcon.model.Reserva;

@RepositoryRestResource(collectionResourceRel="reserva", path="reserva", exported=true)
public interface ReservaRepository extends PagingAndSortingRepository<Reserva, Long>{

}
