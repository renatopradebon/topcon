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
import com.oxsys.topcon.model.enums.SituacaoCorrespondencia;
import com.oxsys.topcon.model.enums.TipoCorrespondencia;

@Entity
@Table(name="tab_correspondencia")
public class Correspondencia {
	
	@Id
	@GeneratedValue
	private long id;	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;	
	
	@Enumerated(EnumType.STRING)
	private TipoCorrespondencia tipo;
	
	@Temporal(TemporalType.DATE)
	private Date dataRecebimento;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "usuarioRecebimento_id")
	private Usuario usuarioRecebimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataRetirada;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "usuarioRetirada_id")
	private Usuario usuarioRetirada;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pessoaRetirada_id")
	private Pessoa pessoaRetirada;
	
	@Enumerated(EnumType.STRING)
	private SituacaoCorrespondencia situacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoCorrespondencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoCorrespondencia tipo) {
		this.tipo = tipo;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Usuario getUsuarioRecebimento() {
		return usuarioRecebimento;
	}

	public void setUsuarioRecebimento(Usuario usuarioRecebimento) {
		this.usuarioRecebimento = usuarioRecebimento;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Usuario getUsuarioRetirada() {
		return usuarioRetirada;
	}

	public void setUsuarioRetirada(Usuario usuarioRetirada) {
		this.usuarioRetirada = usuarioRetirada;
	}

	public Pessoa getPessoaRetirada() {
		return pessoaRetirada;
	}

	public void setPessoaRetirada(Pessoa pessoaRetirada) {
		this.pessoaRetirada = pessoaRetirada;
	}

	public SituacaoCorrespondencia getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCorrespondencia situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Correspondencia [id=" + id + ", pessoa=" + pessoa + ", tipo=" + tipo + ", dataRecebimento="
				+ dataRecebimento + ", usuarioRecebimento=" + usuarioRecebimento + ", dataRetirada=" + dataRetirada
				+ ", usuarioRetirada=" + usuarioRetirada + ", pessoaRetirada=" + pessoaRetirada + ", situacao="
				+ situacao + "]";
	}
	
	

}
