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
import com.oxsys.topcon.model.enums.ReservaSituacao;

@Entity
@Table(name="tab_reserva")
public class Reserva {	
	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataReserva;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;
	
	@Enumerated(EnumType.STRING)
	private ReservaSituacao situacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
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

	public ReservaSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(ReservaSituacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", dataReserva=" + dataReserva + ", pessoa=" + pessoa + ", unidade=" + unidade
				+ ", situacao=" + situacao + "]";
	}

	public Reserva(long id, Date dataReserva, Pessoa pessoa, Unidade unidade, ReservaSituacao situacao) {
		super();
		this.id = id;
		this.dataReserva = dataReserva;
		this.pessoa = pessoa;
		this.unidade = unidade;
		this.situacao = situacao;
	}

}
