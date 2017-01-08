package br.unifor.business;

import javax.swing.ImageIcon;

import br.unifor.gui.PrincipalUI;

public class UpdateImagesThread extends Thread {

	private PrincipalUI principalUI;
	private static boolean runFlag = false;
	
	public UpdateImagesThread(PrincipalUI principalUI) {
		this.principalUI = principalUI;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		this.alternarImagens();
		
		
	}
	
	public void alternarImagens() {
		
		while (runFlag) {
			principalUI.getHdIconLabel().setIcon(new ImageIcon(getClass().getClassLoader().getResource("br/unifor/resources/hd1.png")));
			principalUI.getChecksPanel().updateUI();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			principalUI.getHdIconLabel().setIcon(new ImageIcon(getClass().getClassLoader().getResource("br/unifor/resources/hd2.png")));
			principalUI.getChecksPanel().updateUI();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public boolean isRunFlag() {
		return runFlag;
	}

	public static void setRunFlag(boolean runFlag) {
		UpdateImagesThread.runFlag = runFlag;
	}
	
}
