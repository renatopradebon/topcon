package com.oxsys.topcon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.oxsys.topcon.model.Pessoa;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>  {
	
}
