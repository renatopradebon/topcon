package com.oxsys.topcon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(length=20, nullable=false)
	private String numeroControle;
	
	@Temporal(TemporalType.DATE)
	private Date dataContrato;
	
	@Enumerated(EnumType.STRING)
	private ContratoTipo tipo;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicioVigencia;
	
	@Temporal(TemporalType.DATE)
	private Date dataFinalVigencia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unidade_id")
	private Unidade unidade;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "proprietario_id")
	private Pessoa proprietario;

	public long getId() {
		return id;
	}
	
	public Contrato(){
		// to do
	}
	
	public Contrato(long id, String numeroControle, Date dataContrato, ContratoTipo tipo, Date dataInicioVigencia,
			Date dataFinalVigencia, Pessoa pessoa, Unidade unidade, Pessoa proprietario) {
		super();
		this.id = id;
		this.numeroControle = numeroControle;
		this.dataContrato = dataContrato;
		this.tipo = tipo;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFinalVigencia = dataFinalVigencia;
		this.pessoa = pessoa;
		this.unidade = unidade;
		this.proprietario = proprietario;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(String numeroControle) {
		this.numeroControle = numeroControle;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", numeroControle=" + numeroControle + ", dataContrato=" + dataContrato
				+ ", tipo=" + tipo + ", dataInicioVigencia=" + dataInicioVigencia + ", dataFinalVigencia="
				+ dataFinalVigencia + ", pessoa=" + pessoa + ", unidade=" + unidade + ", proprietario=" + proprietario
				+ "]";
	}
	

}
