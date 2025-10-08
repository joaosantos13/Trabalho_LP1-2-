package org.deftones;

public class Bateria 
{
	
	private String cor = "";
	private int qntdPratos = 0;
	private String marca = "";

	public Bateria(String cor, int qntdPratos, String marca) {
		this.cor = cor;
		this.qntdPratos = qntdPratos;
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getQntdPratos() {
		return qntdPratos;
	}

	public void setQtndPratos(int qntdPratos) {
		this.qntdPratos = qntdPratos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
