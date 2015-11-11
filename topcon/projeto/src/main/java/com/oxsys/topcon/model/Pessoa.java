package com.oxsys.topcon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.oxsys.topcon.model.enums.PessoaSituacao;
import com.oxsys.topcon.model.enums.Sexo;


@Entity
@Table(name="tab_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	private PessoaSituacao situacao;
	
	private Sexo sexo;
	
	private Date nascimento;
	
	@Column(length = 12, unique = true, nullable = false)
	private String rg;
	
    @OneToMany(mappedBy="pessoa")
	private List<Contato> listaContatos;

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

	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", situacao=" + situacao + ", sexo=" + sexo + ", nascimento="
				+ nascimento + ", listaContatos=" + listaContatos + "]";
	}
	
	
	
}
