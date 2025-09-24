package org.katyperry;

public class Sacola_Plastica 
{
	
	private String cor = "";
	private int tamanho = 0;
	private boolean rasgada = false;


	public Sacola_Plastica(String cor, int tamanho, boolean rasgada) {
		this.cor = cor;
		this.tamanho = tamanho;
		this.rasgada = rasgada;
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

	public boolean isRasgada() {
		return rasgada;
	}

	public void setRasgada(boolean rasgada) {
		this.rasgada = rasgada;
	}

	public void Consertar(Boolean rasgada) 
	{
		if(rasgada != true) 
		{
			System.out.println("Não precisa de conserto");
		}
		else 
		{
			System.out.println("Consertada");
            rasgada = false;
		}		
	}
	
}