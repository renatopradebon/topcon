package com.oxsys.topcon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oxsys.topcon.model.enums.Situacao;

@Entity
@Table(name="tab_aviso")
public class Aviso {
	@Id
	@GeneratedValue
	private long id;
	
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraExpiracao;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHoraExpiracao() {
		return dataHoraExpiracao;
	}

	public void setDataHoraExpiracao(Date dataHoraExpiracao) {
		this.dataHoraExpiracao = dataHoraExpiracao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Aviso [id=" + id + ", descricao=" + descricao + ", dataHoraExpiracao=" + dataHoraExpiracao + ", pessoa="
				+ pessoa + ", situacao=" + situacao + "]";
	}
}
