package com.oxsys.topcon.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.oxsys.topcon.model.enums.TipoConta;

public class Contas {
	
	@Id
	@GeneratedValue
	private long id;
	
	private TipoConta tipo;
	
	private String nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Contas [id=" + id + ", tipo=" + tipo + ", nome=" + nome + "]";
	}
	
	
	
}
