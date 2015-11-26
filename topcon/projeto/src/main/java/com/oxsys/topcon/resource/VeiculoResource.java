package com.oxsys.topcon.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oxsys.topcon.model.Veiculo;
import com.oxsys.topcon.repository.VeiculoRepository;

@RestController
public class VeiculoResource {

	@Autowired
	private VeiculoRepository repo;
	
	@RequestMapping("/api/veiculo")
	public Iterable<Veiculo> listaVeiculos(){
		return repo.findAll();
	}
	
 	@RequestMapping( value="/api/veiculo", method = RequestMethod.POST)
	public Veiculo addVeiculo(@RequestBody final  Veiculo veiculo ){
		Veiculo v = repo.save(veiculo);	
		return v;
	}

	
}
