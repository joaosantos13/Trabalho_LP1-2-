package org.vikmuniz;

public class Carro 
{
	
	private  String cor	 = "";
	private int velocidade = 0;
	private int preco = 0;

	

	public Carro(String cor, int velocidade, int preco) {
		this.cor = cor;
		this.velocidade = velocidade;
		this.preco = preco;
	}


	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public int getVelocidade() {
		return velocidade;
	}



	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}



	public int getPreco() {
		return preco;
	}



	public void setPreco(int preco) {
		this.preco = preco;
	}


	public void Freiar(int velocidade) 
	{
		for(int i = 0; i < velocidade;i++)
		{
			velocidade = velocidade - i;
			if(velocidade == 0) 
			{
				break;
			}
		}
	}
}
