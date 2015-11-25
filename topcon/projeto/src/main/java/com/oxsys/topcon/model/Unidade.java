package com.oxsys.topcon.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oxsys.topcon.model.enums.UnidadeTipo;

@Entity
@Table(name="tab_unidade")
public class Unidade {

	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.STRING)
	private UnidadeTipo tipo;
	
	private String quadra;

	private String bloco;
	
	private String rua;
	
	private String numero;
	
	private String andar;
	
	private long quarto;
	
	@ JsonIgnore 
	@OneToMany(mappedBy = "unidade", fetch = FetchType.LAZY)
	private List<Vaga> vagas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UnidadeTipo getTipo() {
		return tipo;
	}

	public void setTipo(UnidadeTipo tipo) {
		this.tipo = tipo;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}

	public long getQuarto() {
		return quarto;
	}

	public void setQuarto(long quarto) {
		this.quarto = quarto;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Unidade(long id, UnidadeTipo tipo, String quadra, String bloco, String rua, String numero, String andar,
			long quarto, List<Vaga> vagas) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.quadra = quadra;
		this.bloco = bloco;
		this.rua = rua;
		this.numero = numero;
		this.andar = andar;
		this.quarto = quarto;
		this.vagas = vagas;
	}

	@Override
	public String toString() {
		return "Unidade [id=" + id + ", tipo=" + tipo + ", quadra=" + quadra + ", bloco=" + bloco + ", rua=" + rua
				+ ", numero=" + numero + ", andar=" + andar + ", quarto=" + quarto + ", vagas=" + vagas + "]";
	}


	public Unidade(){
		
	}
	
}
