package org.deftones;

public class Tubarao 
{
	
	private String cor = "";
	private String tamanho = "";
	private String especie = "";
	
	public Tubarao(String cor, String tamanho, String especie) {
		this.cor = cor;
		this.tamanho = tamanho;
		this.especie = especie;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	
	
}
