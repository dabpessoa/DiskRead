package br.unifor.core;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.unifor.algoritmos.AlgoritmoManager;
import br.unifor.algoritmos.C_Scan;
import br.unifor.algoritmos.FCFS;
import br.unifor.algoritmos.SSF;
import br.unifor.algoritmos.Scan;
import br.unifor.bean.Algoritmo;
import br.unifor.bean.HardDisk;
import br.unifor.bean.Result;
import br.unifor.gui.GUIManager;
import br.unifor.listener.ExecutionListener;
import br.unifor.listener.ResultListener;
import br.unifor.util.FileUtils;
import br.unifor.util.LocalVariables;

public class Controller implements ResultListener, ExecutionListener {

	private AlgoritmoManager algoritmoManager;
	private GUIManager guiManager;
//	private List<Result> results;
	private String pathOut;
	
	public Controller() {
		this.algoritmoManager = new AlgoritmoManager();
		this.guiManager = new GUIManager(this);
//		this.results = new ArrayList<Result>();
	}
	
	public void run() {
		algoritmoManager.addResultListener(this);
		algoritmoManager.setExecutionListener(this);
		guiManager.init();
	}
	
	public void criar(String path, String... algs) {
		
		// Atributos de entrada
		// String teste = "23 1 68 23 33 2";	
		
		this.pathOut = path;
		
		HardDisk hd = new HardDisk();
		hd.setPosicaoBraco(LocalVariables.DISK_ARM_INIT);
		hd.setTimeOfSeek(LocalVariables.DISK_SEEK_TIME);
		
		try {
			
			algoritmoManager.clearAlgoritmos();
			
			for (int i = 0 ; i < algs.length ; i++) {
				
				if (algs[i] != null) {
					if (algs[i].equalsIgnoreCase(Algoritmo.FCFS)) {
						algoritmoManager.addAlgoritmo(this.prepareFCFS(hd));
					} else if (algs[i].equalsIgnoreCase(Algoritmo.SSF)) {
						algoritmoManager.addAlgoritmo(this.prepareSSF(hd));
					} else if (algs[i].equalsIgnoreCase(Algoritmo.SCAN)) {
						algoritmoManager.addAlgoritmo(this.prepareSCAN(hd));
					} else if (algs[i].equalsIgnoreCase(Algoritmo.C_SCAN)) {
						algoritmoManager.addAlgoritmo(this.prepareC_SCAN(hd));	
					}
				}
			}
			
			algoritmoManager.executeAlgoritmos();
				
			JOptionPane.showMessageDialog(guiManager.getPrincipalUI(), "Algoritmos Executados Com Sucesso!");
			
		} catch (Exception e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public Algoritmo prepareSSF(HardDisk hd) throws Exception {
		SSF ssf = new SSF();
		ssf.setName(Algoritmo.SSF);
		ssf.setHardDisk(hd);
		return ssf;
	}
	
	public Algoritmo prepareFCFS(HardDisk hd) throws Exception {
		FCFS fcfs = new FCFS();
		fcfs.setName(Algoritmo.FCFS);
		fcfs.setHardDisk(hd);
		return fcfs;
	}
	
	public Algoritmo prepareSCAN(HardDisk hd) throws Exception {
		Scan scan = new Scan();
		scan.setName(Algoritmo.SCAN);
		scan.setHardDisk(hd);
		return scan;
	}
	
	public Algoritmo prepareC_SCAN(HardDisk hd) throws Exception {
		C_Scan cScan = new C_Scan();
		cScan.setName(Algoritmo.C_SCAN);
		cScan.setHardDisk(hd);
		return cScan;
	}

	@Override
	public void updateResult(Result result) {
		
//		this.results.add(result);
		
		// Aqui gera o arquivo de saída após executar determinado algoritmo
		
		File fileOut = null;
		if (pathOut != null) fileOut = new File(pathOut + File.separator + result.getNomeAlgoritmo() + ".txt");
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println();
		System.out.println("Algoritmo: "+result.getNomeAlgoritmo());
		System.out.println("Deslocamentos: "+result.getQtdDeslocamentos());
		System.out.println("Tempo Total Execução: "+result.getTempoTotalDeExec());
		System.out.println("Tempo Médio Deslocamento: "+result.getTempoMedioDeDesloc());
		System.out.println("Variância: "+result.getVariancia());
		System.out.println("Desvio Padrão: "+result.getDesvioPadrao());
		System.out.println();
		System.out.println("SAÍDA: ");
		System.out.println();
		
		for (int i = 0 ; i < result.getSaidaArquivo().length ; i++) {
			System.out.print(result.getSaidaArquivo()[i]+" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		try {
			if (fileOut != null) FileUtils.write(fileOut, result.toString());
		} catch (IOException e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateExecution(boolean executing, Algoritmo algoritmo) {
		
//		UpdateImagesThread thread = new UpdateImagesThread(guiManager.getPrincipalUI());
		
		if (executing) {
			
			System.out.println("Executing "+algoritmo.getName()+" ...");
			this.guiManager.getPrincipalUI().logAppend("Executing "+algoritmo.getName()+" ...");
			// Implementar Alternância entre imagens
//			UpdateImagesThread.setRunFlag(true);
//			thread.start();
			
			
			
		} else {
			
			System.out.println("Finishing "+algoritmo.getName()+" ...");
			this.guiManager.getPrincipalUI().logAppend("Finishing "+algoritmo.getName()+" ...");
//			UpdateImagesThread.setRunFlag(false);
//			thread = null;
		
//			guiManager.getPrincipalUI().setImageOriginal();
			
		}
		
		
		
	}
	
	public GUIManager getGuiManager() {
		return guiManager;
	}
	
}
