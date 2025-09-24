package org.vikmuniz;

public class Jornal 
{
	
	private int tamanho = 0;
	private int preco = 0;
	private boolean aberto = false;
	
	public Jornal(int tamanho, int preco, boolean aberto) {
		this.tamanho = tamanho;
		this.preco = preco;
		this.aberto = aberto;
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	public boolean isAberto() {
		return aberto;
	}
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}


	public void Abrir() 
	{
		aberto = true;
	}
	
}
