package com.oxsys.topcon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab_veiculo")
public class Veiculo {
	

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", placa=" + placa + "]";
	}

	@Id
	@GeneratedValue
	private long id;
	
	private String placa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
}
