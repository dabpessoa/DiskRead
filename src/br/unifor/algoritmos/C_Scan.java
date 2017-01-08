package br.unifor.algoritmos;

import br.unifor.bean.Algoritmo;
import br.unifor.bean.HardDisk;
import br.unifor.bean.Result;
import br.unifor.business.Calc;
import br.unifor.util.LocalVariables;
import br.unifor.util.HeapSort;

public class C_Scan extends Algoritmo {

	private static final int SUBINDO = 0;
	
	public C_Scan() {}

	@Override
	public Result execute() throws Exception {
		
//		System.out.println("EXECUTING C_SCAN...");
		
//		StringBuilder saida = new StringBuilder();
		
		Integer[] requisicoes = getRequisicoesClone();
		if (requisicoes == null) {
			requisicoes = readRequestsFromFile(LocalVariables.FILE_PATH, 2000000);
			setRequisicoes(requisicoes.clone());
		}
		Integer saida[] = new Integer[requisicoes.length];
		
		HardDisk hd = getHardDisk();
		int qtDesloc = 0;

		HeapSort.sort(requisicoes);
		
		int braco = hd.getPosicaoBraco();
		int estado = C_Scan.SUBINDO;
		
		if (estado == C_Scan.SUBINDO) {
			
			int posicao = -1;
			
			// Procura em qual posição está o braço do disco
			for (int i = 0 ; i < requisicoes.length ; i++) {
				
				int requisicao = requisicoes[i];
				
				if (requisicao >= braco) {
					posicao = i;
					break;
				}
				
			}
			
			qtDesloc += Math.abs(requisicoes[posicao] - hd.getPosicaoBraco());
			int saidaCount = 0;
			for (int i = posicao ; i < requisicoes.length ; i++) {
				
				if (i+1 != requisicoes.length)
					qtDesloc += Math.abs(requisicoes[i+1] - requisicoes[i]);
//				saida.append(requisicoes[i]+" ");
				saida[saidaCount++] = requisicoes[i];
				
				
			}
			
			qtDesloc += Math.abs(requisicoes[requisicoes.length -1] - requisicoes[0]);
			saidaCount = requisicoes.length - posicao;
			for (int i = 0 ; i < posicao  ; i++) {
				
				if (i+1 != posicao)
					qtDesloc += Math.abs(requisicoes[i+1] - requisicoes[i]);
//				saida.append(requisicoes[i]+" ");
				saida[saidaCount++] = requisicoes[i];
				
			}
			
		}
		
		Result result = new Result();
		result.setNomeAlgoritmo(getName());
		result.setSaidaArquivo(saida);
		result.setQtdDeslocamentos(qtDesloc);
		result.setTempoTotalDeExec(Calc.getTempoTotalDeslocamento(qtDesloc, getHardDisk().getTimeOfSeek()));
		result.setTempoMedioDeDesloc(Calc.getTempoMedioDeslocamento(result.getTempoTotalDeExec(), requisicoes.length));
		result.setVariancia(Calc.getVariancia(getHardDisk().getPosicaoBraco(), result.getTempoMedioDeDesloc(), saida));
		result.setDesvioPadrao(Calc.getDesvioPadrao(result.getVariancia()));
		
		requisicoes = null;
		saida = null;
		
		return result;
		
	}
	
}
