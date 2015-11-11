package com.oxsys.topcon.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.oxsys.topcon.model.enums.ContatoTipo;


@Entity
@Table(name="tab_contato")
public class Contato {

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	private ContatoTipo tipo;
	
	private String telefone;
	
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa; 
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ContatoTipo getTipo() {
		return tipo;
	}

	public void setTipo(ContatoTipo tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", telefone=" + telefone + ", email=" + email
				+ ", pessoa=" + pessoa + "]";
	}

	
	
	
}
