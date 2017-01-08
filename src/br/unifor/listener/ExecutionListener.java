package br.unifor.listener;

import br.unifor.bean.Algoritmo;

public interface ExecutionListener {
	
	void updateExecution(boolean executing, Algoritmo algoritmo); 
	
}
