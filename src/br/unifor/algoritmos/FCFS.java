package br.unifor.algoritmos;

import br.unifor.bean.Algoritmo;
import br.unifor.bean.Result;
import br.unifor.business.Calc;
import br.unifor.util.LocalVariables;

public class FCFS extends Algoritmo {

	public FCFS() {}
	
	@Override
	public Result execute() throws Exception {
		
//		StringBuilder saida = new StringBuilder();
		
		Integer[] requisicoes = getRequisicoesOriginal();
		if (requisicoes == null) {
			requisicoes = readRequestsFromFile(LocalVariables.FILE_PATH, 2000000);
			setRequisicoes(requisicoes.clone());
		}
		int qtDesloc = 0;
		
		qtDesloc += Math.abs(requisicoes[0]-getHardDisk().getPosicaoBraco());
		for (int i = 0 ; i < requisicoes.length ; i++ ) {
			// o braço somente percorre pelas trilhas e espera a latência rotacional
			if (i+1 != requisicoes.length)
			qtDesloc += Math.abs(requisicoes[i+1] - requisicoes[i]);
//			saida.append(requisicoes[i]+LocalVariables.SEPARADOR);
		}
		
		
		Result result = new Result();
		result.setNomeAlgoritmo(getName());
		result.setSaidaArquivo(requisicoes);
		result.setQtdDeslocamentos(qtDesloc);
		result.setTempoTotalDeExec(Calc.getTempoTotalDeslocamento(qtDesloc, getHardDisk().getTimeOfSeek()));
		result.setTempoMedioDeDesloc(Calc.getTempoMedioDeslocamento(result.getTempoTotalDeExec(), requisicoes.length));
		result.setVariancia(Calc.getVariancia(getHardDisk().getPosicaoBraco(), result.getTempoMedioDeDesloc(), requisicoes));
		result.setDesvioPadrao(Calc.getDesvioPadrao(result.getVariancia()));
		
		requisicoes = null;
//		saida = null;
		
		return result;
		
	}

}
