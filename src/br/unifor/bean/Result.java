package br.unifor.bean;

public class Result {

	private int qtdDeslocamentos;
	private float tempoTotalDeExec;
	private float tempoMedioDeDesloc;
	private String nomeAlgoritmo;
	private Integer[] saidaArquivo;
	private double variancia;
	private double desvioPadrao;
	
	public Result() {}
	
	public String toString() {
		
//		String string = "";
		StringBuilder string = new StringBuilder();
		
//		string += "SIMULA��O DO ATENDIMENTO DE REQUISI��ES";
//		string += "\n";
//		string += "\n";
//		string += "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
//		string += "Algoritmo: "+this.getNomeAlgoritmo()+"\n";
//		string += "Deslocamentos: "+this.getQtdDeslocamentos()+"\n";
//		string += "Tempo Total Execu��o: "+this.getTempoTotalDeExec()+"\n";
//		string += "Tempo M�dio Deslocamento: "+this.getTempoMedioDeDesloc()+"\n";
//		string += "Vari�ncia: "+this.getVariancia()+"\n";
//		string += "Desvio Padr�o: "+this.getDesvioPadrao()+"\n";
//		string += "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
//		string += "\n";
//		string += "SA�DA: \n\n";
		
		string.append("SIMULA��O DO ATENDIMENTO DE REQUISI��ES");
		string.append("\n");
		string.append("\n");
		string.append("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		string.append("Algoritmo: "+this.getNomeAlgoritmo()+"\n");
		string.append("Deslocamentos: "+this.getQtdDeslocamentos()+"\n");
		string.append("Tempo Total Execu��o: "+this.getTempoTotalDeExec()+"\n");
		string.append("Tempo M�dio Deslocamento: "+this.getTempoMedioDeDesloc()+"\n");
		string.append("Vari�ncia: "+this.getVariancia()+"\n");
		string.append("Desvio Padr�o: "+this.getDesvioPadrao()+"\n");
		string.append("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		string.append("\n");
		string.append("SA�DA: \n\n");
		
//		for (int i = 0 ; i < this.getSaidaArquivo().length ; i++) {
//			string += this.getSaidaArquivo()[i]+" ";
//		}
		
		for (int i = 0 ; i < this.getSaidaArquivo().length ; i++) {
			string.append(this.getSaidaArquivo()[i]+" ");
		}
		
		return string.toString();
	}

	public int getQtdDeslocamentos() {
		return qtdDeslocamentos;
	}

	public void setQtdDeslocamentos(int qtdDeslocamentos) {
		this.qtdDeslocamentos = qtdDeslocamentos;
	}

	public float getTempoTotalDeExec() {
		return tempoTotalDeExec;
	}
	
	public void setTempoTotalDeExec(float tempoTotalDeExec) {
		this.tempoTotalDeExec = tempoTotalDeExec;
	}

	public float getTempoMedioDeDesloc() {
		return tempoMedioDeDesloc;
	}

	public void setTempoMedioDeDesloc(float tempoMedioDeDesloc) {
		this.tempoMedioDeDesloc = tempoMedioDeDesloc;
	}

	public String getNomeAlgoritmo() {
		return nomeAlgoritmo;
	}

	public void setNomeAlgoritmo(String nomeAlgoritmo) {
		this.nomeAlgoritmo = nomeAlgoritmo;
	}
	
	public Integer[] getSaidaArquivo() {
		return saidaArquivo;
	}
	
	public void setSaidaArquivo(Integer[] saidaArquivo) {
		this.saidaArquivo = saidaArquivo;
	}

	public double getVariancia() {
		return variancia;
	}

	public void setVariancia(double variancia) {
		this.variancia = variancia;
	}

	public double getDesvioPadrao() {
		return desvioPadrao;
	}

	public void setDesvioPadrao(double desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	
}
