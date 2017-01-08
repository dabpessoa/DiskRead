package br.unifor.bean;

public class HardDisk {

	private int qtdTrilhas;
	private int posicaoBraco;
	private float timeOfSeek;
	
	public HardDisk() {
		// TODO Auto-generated constructor stub
	}

	public int getQtdTrilhas() {
		return qtdTrilhas;
	}

	public void setPosicaoBraco(int posicaoBraco) {
		this.posicaoBraco = posicaoBraco;
	}

	public int getPosicaoBraco() {
		return posicaoBraco;
	}

	public float getTimeOfSeek() {
		return timeOfSeek;
	}
	
	public void setTimeOfSeek(float timeOfSeek) {
		this.timeOfSeek = timeOfSeek;
	}
	
}
