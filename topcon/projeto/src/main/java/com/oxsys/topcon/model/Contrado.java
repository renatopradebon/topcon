package com.oxsys.topcon.model;

import java.util.Date;

import javax.persistence.Column;
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

import com.oxsys.topcon.model.enums.ContratoTipo;

@Entity
@Table(name = "tab_contrato")
public class Contrado {

	@Id
	@GeneratedValue
	private long id;

	@Column(length=20,nullable=false)
	private String numeroControle;

	@Enumerated(EnumType.STRING)
	private ContratoTipo tipo;

	@Temporal(TemporalType.DATE)
	private Date dataInicioVigencia;

	@Temporal(TemporalType.DATE)
	private Date dataFinalVigencia;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Pessoa proprietario;

	@ManyToOne
	@JoinColumn(name="unidade_id")
	private Unidade unidade;

	
	
	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(String numeroControle) {
		this.numeroControle = numeroControle;
	}

	public ContratoTipo getTipo() {
		return tipo;
	}

	public void setTipo(ContratoTipo tipo) {
		this.tipo = tipo;
	}

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Date getDataFinalVigencia() {
		return dataFinalVigencia;
	}

	public void setDataFinalVigencia(Date dataFinalVigencia) {
		this.dataFinalVigencia = dataFinalVigencia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Contrado(long id, String numeroControle, ContratoTipo tipo, Date dataInicioVigencia, Date dataFinalVigencia,
			Pessoa pessoa, Pessoa proprietario, Unidade unidade) {
		super();
		this.id = id;
		this.numeroControle = numeroControle;
		this.tipo = tipo;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFinalVigencia = dataFinalVigencia;
		this.pessoa = pessoa;
		this.proprietario = proprietario;
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return "Contrado [id=" + id + ", numeroControle=" + numeroControle + ", tipo=" + tipo + ", dataInicioVigencia="
				+ dataInicioVigencia + ", dataFinalVigencia=" + dataFinalVigencia + ", pessoa=" + pessoa
				+ ", proprietario=" + proprietario + ", unidade=" + unidade + "]";
	}

	public Contrado(){
		
	}
	
}
