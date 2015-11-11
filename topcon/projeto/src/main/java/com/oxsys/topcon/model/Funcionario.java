package com.oxsys.topcon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.oxsys.topcon.model.enums.Cargo;
import com.oxsys.topcon.model.enums.UsuarioSituacao;

@Entity
@Table(name="tab_funcionario")
public class Funcionario {
	@Id
	@GeneratedValue
	private long id;
	
	private Cargo cargo;
	
	@Column(nullable = false, unique = true)
	private String login;
	
	@NotNull
	private String senha;
	
	private UsuarioSituacao situcao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioSituacao getSitucao() {
		return situcao;
	}

	public void setSitucao(UsuarioSituacao situcao) {
		this.situcao = situcao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cargo=" + cargo + ", login=" + login + ", senha=" + senha + ", situcao="
				+ situcao + ", pessoa=" + pessoa + "]";
	} 
}
