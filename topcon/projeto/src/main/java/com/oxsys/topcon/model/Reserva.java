package com.oxsys.topcon.model;

import java.util.Date;

import javax.persistence.Entity;
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
	
	
	private ReservaSituacao situacao;

}
