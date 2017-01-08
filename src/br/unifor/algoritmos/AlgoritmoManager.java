package br.unifor.algoritmos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.unifor.bean.Algoritmo;
import br.unifor.bean.Result;
import br.unifor.listener.ExecutionListener;
import br.unifor.listener.ResultListener;

public class AlgoritmoManager {

	private List<Algoritmo> algoritmos;
	private List<ResultListener> resultListeners;
	private ExecutionListener executionListener;
	
	public AlgoritmoManager() {
		this.algoritmos = new ArrayList<Algoritmo>();
		this.resultListeners = new ArrayList<ResultListener>();
	}
	
	public void setExecutionListener(ExecutionListener executionListener) {
		this.executionListener = executionListener;
	}
	
	public void updateExecution(boolean executing, Algoritmo algoritmo) {
		this.executionListener.updateExecution(executing, algoritmo);
	}
	
	public void addAlgoritmo(Algoritmo algoritmo) {
		this.algoritmos.add(algoritmo);
	}

	public void setAlgoritmos(List<Algoritmo> algoritmos) {
		this.algoritmos = algoritmos;
	}

	public List<Algoritmo> getAlgoritmos() {
		return algoritmos;
	}
	
	public void clearAlgoritmos() {
		this.algoritmos.clear();
	}
	
	public void addResultListener(ResultListener resultListener) {
		this.resultListeners.add(resultListener);
	}
	
	public void updateResultListeners(Result result) {
		for (int i = 0 ; i < resultListeners.size() ; i++) {
			resultListeners.get(i).updateResult(result);
		}
	}
	
	public void gerarArquivoDeSaida(Result result, String fileName) throws IOException {
		this.updateResultListeners(result);
	}

	public void executeAlgoritmos() throws Exception {
		for (int i = 0 ; i < algoritmos.size() ; i++) {
			this.updateExecution(true, algoritmos.get(i));
			this.gerarArquivoDeSaida(algoritmos.get(i).execute(), algoritmos.get(i).getName());
			this.updateExecution(false, algoritmos.get(i));
		}	
	}
	
	public void executeAlgoritmo(String name) throws IOException, Exception {
		for (int i = 0 ; i < algoritmos.size() ; i++) {
			if (algoritmos.get(i).getName().equalsIgnoreCase(name)) {
				this.updateExecution(true, algoritmos.get(i));
				this.gerarArquivoDeSaida(algoritmos.get(i).execute(), algoritmos.get(i).getName());
				this.updateExecution(false, algoritmos.get(i));
			}
		}
	}
	
}
