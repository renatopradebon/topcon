package com.oxsys.topcon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_vaga")
public class Vaga {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name="unidade_id")
	private Unidade unidade;
	
	private String numeracao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Vaga(long id, Unidade unidade, String numeracao) {
		super();
		this.id = id;
		this.unidade = unidade;
		this.numeracao = numeracao;
	}

	@Override
	public String toString() {
		return "Vaga [id=" + id + ", unidade=" + unidade + ", numeracao=" + numeracao + "]";
	}
	
	public Vaga(){
		
	}
	
}
