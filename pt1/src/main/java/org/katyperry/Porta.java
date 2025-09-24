package org.katyperry;

public class Porta 
{
	
	private String cor = "";
	private String tamanho = "";
	private boolean aberta = false;

	public Porta(String cor, String tamanho, boolean aberta) {
		this.cor = cor;
		this.tamanho = tamanho;
		this.aberta = aberta;
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

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

	public void Abrir() 
	{
		aberta = true;
	}
}