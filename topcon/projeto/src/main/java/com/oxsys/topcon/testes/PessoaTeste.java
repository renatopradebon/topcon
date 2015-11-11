package com.oxsys.topcon.testes;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxsys.topcon.model.Pessoa;
import com.oxsys.topcon.repository.PessoaRepository;

@RestController
public class PessoaTeste {

	private PessoaRepository repo;
	
	@RequestMapping("/api/pessoa")
	public Iterable<Pessoa> listaPessoas(){
		return repo.findAll();
	}
	
 	@RequestMapping( value="/api/pessoa", method = RequestMethod.POST)
	public Pessoa addPessoa(@RequestBody final  Pessoa pessoa ){
		Pessoa p = repo.save(pessoa);	
		return p;
	}


}