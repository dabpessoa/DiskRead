package br.unifor.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Algoritmo {

	public static final String SCAN = "SCAN";
	public static final String C_SCAN = "C_SCAN";
	public static final String FCFS = "FCFS";
	public static final String SSF = "SSF";
	
	private HardDisk hardDisk;
	private static Integer[] requisicoes;
	
	private String name;
	
	public Algoritmo() {}
	
	public Algoritmo(String name) {
		this.setName(name);
	}
	
	public abstract Result execute() throws Exception;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	public static void setRequisicoes(Integer[] requisicoes) {
		Algoritmo.requisicoes = requisicoes;
	}

	public static Integer[] getRequisicoesOriginal() {
		return requisicoes;
	}
	
	public Integer[] getRequisicoesClone() {
		if (requisicoes != null)
			return requisicoes.clone();
		else return null;
	}
	
	public static Integer[] readRequestsFromFile(String path, int tamanho) throws Exception {
		Integer[] vet = new Integer[tamanho];
		
			FileReader reader = new FileReader(new File(path));
			BufferedReader leitor = new BufferedReader(reader);

			String t = null;
			int i = 0;
			while ((t = leitor.readLine()) != null) {
				
				Integer[] linha = split(t);
				int tamanhoLinha = linha.length;
				
				for ( int j = 0 ; j < tamanhoLinha ; j++) {
					vet[j + i] = linha[j];
				}
				
				i++;
			}
			
			return fitArray(vet);
			
	}
		
		public static Integer[] split(String linha) {
			
			int pos = 0;
			int count = 0;
			Integer[] vet = new Integer[(linha.length()/2) +1];
			
			int index = 0;
			String string;
			while(index != -1)  {
				try{
					
				
					index = linha.indexOf(" ", pos);
					if (index != -1) string = linha.substring(pos, index);
					else string = linha.substring(pos, linha.length());
					if (!string.isEmpty())
					vet[count] = Integer.parseInt(string);
					pos = index+1;
					count++;
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} 
			
			vet = fitArray(vet);

			return vet;
			
		}
		
		public static Integer[] fitArray(Integer[] vet) {
			
			int count = 0;
			for (int i = 0 ; i < vet.length ; i++) {
				if (vet[i] != null) count++;
				else break;
			}
			
			Integer[] v = new Integer[count];
			for (int i = 0 ; i < v.length ; i++) {
				v[i] = vet[i];
			}
			
			return v;
			
		}
		
		public Integer originalIndexOf(Integer number) {
			
			for (int i = 0 ; i < requisicoes.length ; i++) {
				if (requisicoes[i] == number) {
					return i;
				}
			}
			
			return null;
			
		}
	
}
