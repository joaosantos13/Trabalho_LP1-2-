package org.deftones;

public class Guitarra 
{
	
	private String cor = " ";
	private String marca = "";
	private int qntdCordas = 0;

	public Guitarra(String cor, String marca, int qntdCordas) {
		this.cor = cor;
		this.marca = marca;
		this.qntdCordas = qntdCordas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public int getQntdCordas() {
		return qntdCordas;
	}

	public void setQntdCordas(int qntdCordas) {
		this.qntdCordas = qntdCordas;
	}
	
}