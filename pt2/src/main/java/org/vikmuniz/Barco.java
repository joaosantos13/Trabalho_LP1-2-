package org.vikmuniz;

public class Barco 
{
	
	private String cor = "";
	private int tamanho = 0;
	private int velocidade = 0;

	public Barco(String cor, int tamanho, int velocidade) {
		this.cor = cor;
		this.tamanho = tamanho;
		this.velocidade = velocidade;
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

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public void Acelerar(int tempo, int velocidade)
	{
		for(int i = 0; i < tempo;i++) 
		{
			velocidade++;
		}
	}
	
}
