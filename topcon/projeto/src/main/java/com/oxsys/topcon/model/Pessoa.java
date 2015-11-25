package com.oxsys.topcon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oxsys.topcon.model.enums.PessoaSituacao;
import com.oxsys.topcon.model.enums.Sexo;


@Entity
@Table(name="tab_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private PessoaSituacao situacao;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@ JsonManagedReference 
	@OneToMany(mappedBy="pessoa",fetch=FetchType.LAZY)
	private List<Contato> contatos;
	
	
	
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
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

	public PessoaSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(PessoaSituacao situacao) {
		this.situacao = situacao;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Pessoa(long id, String nome, PessoaSituacao situacao, Sexo sexo, Date nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
		this.sexo = sexo;
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", situacao=" + situacao + ", sexo=" + sexo + ", nascimento="
				+ nascimento + "]";
	}

 public Pessoa(){
	 
	
}
 
 
	
}
