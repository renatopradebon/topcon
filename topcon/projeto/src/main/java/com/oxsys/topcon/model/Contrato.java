package com.oxsys.topcon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.oxsys.topcon.model.enums.ContratoTipo;

@Entity
@Table(name="tab_contrato")
public class Contrato {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String numeroContrato;
	
	private Date dataContrato;
	
	private ContratoTipo tipo;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioVigencia;
	
	@Temporal(TemporalType.DATE)
	private Date dataFinalVigencia;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unidade_id")
	private Unidade unidade;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
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
	

}
