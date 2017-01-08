package br.unifor.algoritmos;

import br.unifor.bean.Algoritmo;
import br.unifor.bean.HardDisk;
import br.unifor.bean.Result;
import br.unifor.business.Calc;
import br.unifor.util.LocalVariables;
import br.unifor.util.HeapSort;

public class SSF extends Algoritmo {

	public SSF() {}
	
	@Override
	public  Result execute() throws Exception {
		
//		System.out.println("EXECUTING SSF...");
		
		Integer[] requisicoes = getRequisicoesClone();
		if (requisicoes == null) {
			requisicoes = readRequestsFromFile(LocalVariables.FILE_PATH, 2000000);
			setRequisicoes(requisicoes.clone());
		}
//		StringBuilder saida = new StringBuilder();
		Integer saida[] = new Integer[requisicoes.length];
		
		HardDisk hd = getHardDisk();
		
		int braco = hd.getPosicaoBraco();
		int qtDesloc = 0;
		
		HeapSort.sort(requisicoes);
		
		int indice = -1;
		for (int i = 0 ; i < requisicoes.length ; i++) {
			int requisicao = requisicoes[i];
			if (requisicao >= braco) {
				indice = i;
				break;
			}
		} 
		
		int leftPointer;
		if (indice != 0) leftPointer = indice-1;
		else leftPointer = indice;
		int rightPointer = indice;
		int saidaCount = 0; 
		
		for (int i = 0 ; i < requisicoes.length ; i++) {
			
			int req1;
			int req2;
			
			req1 = requisicoes[leftPointer];
			req2 = requisicoes[rightPointer];
			
			while(req1 == -1 && (leftPointer -1 != -1) ) {
				leftPointer--;
				req1 = requisicoes[leftPointer];
			}
			while(req2 == -1 && (rightPointer + 1 != requisicoes.length)) {
				rightPointer++;
				req2 = requisicoes[rightPointer];
			}
			
			int aux = braco - req1;
			int aux2 = req2 - braco;
			
			if (req1 == -1) aux = aux2 + 1;
			if (req2 == -1) aux2 = aux + 1;
			
			if (aux < aux2 && req1 != -1) {
				braco = requisicoes[leftPointer];
				requisicoes[leftPointer] = -1;
//				saida.append(req1+" ");
				saida[saidaCount++] = req1;
				qtDesloc += aux;
			}
			else if (aux2 < aux && req2 != -1){
				braco = requisicoes[rightPointer];
//				saida.append(req2+" ");
				saida[saidaCount++] = req2;
				requisicoes[rightPointer] = -1;
				qtDesloc += aux2;
			} else if (aux == aux2) {
				if (originalIndexOf(requisicoes[leftPointer]) < originalIndexOf(requisicoes[rightPointer])) {
					braco = requisicoes[leftPointer];
					requisicoes[leftPointer] = -1;
//					saida.append(req1+" ");
					saida[saidaCount++] = req1;
				} else {
					braco = requisicoes[rightPointer];
//					saida.append(req2+" ");
					saida[saidaCount++] = req2;
					requisicoes[rightPointer] = -1;
				}
				qtDesloc += aux;
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
	
	/*
	 * Implementação Funcional, porém lenta.
	 */
//	@Override
//	public StringBuilder execute2() {
//		System.out.println("EXECUTING SSF...");
//		
//		StringBuilder saida = new StringBuilder();
//				
//		/*
//		 * Lembrar que tem que setar o atributos (acessos e harddisk) da classe Algoritmo
//		 */
//		// First Come First Served
//		Integer[] requisicoes = getRequisicoes();
//		HardDisk hd = getHardDisk();
//		
//		int braco = hd.getPosicaoBraco();
//		int minDaVez = -1;
//		int minimo = hd.getQtdTrilhas();
//		int requisicao = -1;
//		int aux = -1;
//		int temp = -1;
//		
//		for (int j = 0 ; j < requisicoes.length ; j++) { 
//			
//			minimo = hd.getQtdTrilhas();
//			for (int i = 0 ; i < requisicoes.length ; i++) { 
//				
//				requisicao = requisicoes[i];
//				
//				if (requisicao < braco) minDaVez = braco - requisicao;
//				else minDaVez = requisicao - braco;
//				if (minDaVez < minimo && requisicao != -1) {
//					minimo = minDaVez;
//					aux = requisicao;
//					temp = i;
//				}				
//				
//			}
//			
//			braco = aux;
//			requisicoes[temp] = -1;
//			saida.append(braco+" ");
//			
//		}
//
//		return saida;
//		
//	}

}
