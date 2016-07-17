package br.com.wamais.houseCare.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	private String valor;

	public Parametro() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}