package org.vikmuniz;

public class Ponte 
{
	private String material = "";
	private int Largura = 0;
	private String localizacao = "";
	
	public Ponte(String material, int largura, String localizacao) {
		this.material = material;
		Largura = largura;
		this.localizacao = localizacao;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getLargura() {
		return Largura;
	}
	public void setLargura(int largura) {
		Largura = largura;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public void Manutencao() 
	{
		
	}
}