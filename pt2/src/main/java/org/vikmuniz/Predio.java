package org.vikmuniz;

public class Predio 
{
	
	private String cor = "";
	private boolean portaPrincipal = false;
	private int qntdpessoas = 0;
	
	public Predio(String cor, boolean portaPrincipal, int qntdpessoas)
	{
		this.cor = cor;
		this.portaPrincipal = portaPrincipal;
		this.qntdpessoas = qntdpessoas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public boolean isPortaPrincipal() {
		return portaPrincipal;
	}

	public void setPortaPrincipal(boolean portaPrincipal) {
		this.portaPrincipal = portaPrincipal;
	}

	public int getQntdpessoas() {
		return qntdpessoas;
	}

	public void setQntdpessoas(int qntdpessoas) {
		this.qntdpessoas = qntdpessoas;
	}
	
	
}
