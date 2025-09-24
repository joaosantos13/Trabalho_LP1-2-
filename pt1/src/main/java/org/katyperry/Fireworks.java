package org.katyperry;

public class Fireworks 
{
	
	private String cor = "";
	private int tamanho = 0;
	private int potencia = 0;

	public Fireworks(String cor, int tamanho, int potencia) {
		this.cor = cor;
		this.tamanho = tamanho;
		this.potencia = potencia;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public void Acender(String cor, int tamanho, int potencia)
	{
		int altura = 10 * (potencia/tamanho);
		System.out.println("Seu fogo de artifício" + cor + " chegou aos " + altura + " metros!");
	}
	
}
