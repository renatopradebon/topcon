package com.oxsys.topcon.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oxsys.topcon.model.enums.TipoUnidade;

@Entity
@Table(name="tab_unidade")
public class Unidade {

	@Id
	@GeneratedValue
	private long id;
	
	private TipoUnidade tipounidade;
	
	private String quadra;
	
	private String bloco;
	
	private String rua;
	
	private String numero;
	
	private String andar;
	
	private long numeroQuartos;
	
	@ElementCollection
	@CollectionTable(name = "tab_unidade_garagem")
	private Set<String> vagaGaragem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoUnidade getTipounidade() {
		return tipounidade;
	}

	public void setTipounidade(TipoUnidade tipounidade) {
		this.tipounidade = tipounidade;
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

	public long getNumeroQuartos() {
		return numeroQuartos;
	}

	public void setNumeroQuartos(long numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}

	public Set<String> getVagaGaragem() {
		return vagaGaragem;
	}

	public void setVagaGaragem(Set<String> vagaGaragem) {
		this.vagaGaragem = vagaGaragem;
	}

	@Override
	public String toString() {
		return "Unidade [id=" + id + ", tipounidade=" + tipounidade + ", quadra=" + quadra + ", bloco=" + bloco
				+ ", rua=" + rua + ", numero=" + numero + ", andar=" + andar + ", numeroQuartos=" + numeroQuartos
				+ ", vagaGaragem=" + vagaGaragem + "]";
	}
	
	
	
}
