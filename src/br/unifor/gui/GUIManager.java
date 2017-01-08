package br.unifor.gui;

import br.unifor.core.Controller;

public class GUIManager {
	
	PrincipalUI principalUI;
	Controller controller;
	
	public GUIManager() {
		this.principalUI = new PrincipalUI();
	}
	
	public GUIManager(Controller controller) {
		this.controller = controller;
		this.principalUI = new PrincipalUI(controller);
	}
	
	
	public void init() {
		principalUI.init();
	}
	
	public PrincipalUI getPrincipalUI() {
		return principalUI;
	}

}
