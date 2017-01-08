package br.unifor.business;

public class Calc {

	public static Integer getQuantidadeDeslocamentos() {
		return null;
	}
	
	public static float getTempoTotalDeslocamento(Integer qtdDesloc, float tempoMinDesloc) {
		return qtdDesloc * tempoMinDesloc;
	}
	
	public static float getTempoMedioDeslocamento(float tempoTotalDesloc, Integer tamanhoVet) {
		return tempoTotalDesloc / tamanhoVet;
	}
	
	public static double getVariancia(Integer posicaoInicialBraco, float tempoMedioDeslocamento, Integer[] saida) {
		
		double variancia = 0;
		variancia += Math.pow((tempoMedioDeslocamento - (Math.abs(posicaoInicialBraco - saida[0]))), 2);
		for (int i = 0 ; i < saida.length ; i++) {
			if (i+1 != saida.length)
			variancia += Math.pow((tempoMedioDeslocamento - (Math.abs(saida[i] - saida[i+1]))), 2);
		}
		return variancia / (saida.length);
		
	}
	
	public static double getDesvioPadrao(double variancia) {
		return Math.sqrt(variancia);
	}
	
}
