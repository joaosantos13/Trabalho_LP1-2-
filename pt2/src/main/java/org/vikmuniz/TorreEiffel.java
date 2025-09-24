package org.vikmuniz;

public class TorreEiffel 
{
	
	private  String material = "";
	private String tamanho = "";
	private boolean luzes = false;

	

	public TorreEiffel(String material, String tamanho, boolean luzes) {
		super();
		this.material = material;
		this.tamanho = tamanho;
		this.luzes = luzes;
	}

	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public String getTamanho() {
		return tamanho;
	}



	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}



	public boolean isLuzes() {
		return luzes;
	}



	public void setLuzes(boolean luzes) {
		this.luzes = luzes;
	}


	public void LigarLuzes() 
	{
		luzes = true;
	}
}
