package br.unifor.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import br.unifor.util.LocalVariables;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ConfigUI extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField armPosition;
	private JLabel hdArm;
	private JButton cancelButton;
	private JButton saveButton;
	private JLabel configLabel;
	private JLabel jLabel1;
	private JTextField diskSeek;
	private static ConfigUI instance;

	public static ConfigUI getInstance(JFrame dad) {
//		JDialog.setDefaultLookAndFeelDecorated(true);
		if (instance == null) {
			instance = new ConfigUI(dad);
			instance.setSize(287, 191);
			instance.setLocationRelativeTo(null);
			instance.setResizable(false);
			instance.setTitle("Configurações");
			instance.setIconImage(instance.getToolkit().getImage(instance.getClass().getResource("/br/unifor/resources/hd.png")));
		}
		instance.setVisible(true);
		return instance;
	}
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ConfigUI inst = new ConfigUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private ConfigUI() {
		super();
		initGUI();
	}
	
	private ConfigUI(JFrame dad) {
		super(dad, true);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				armPosition = new JTextField();
				armPosition.setText(LocalVariables.DISK_ARM_INIT.toString());
				getContentPane().add(armPosition);
				armPosition.setBounds(171, 70, 59, 21);
			}
			{
				diskSeek = new JTextField();
				diskSeek.setText(LocalVariables.DISK_SEEK_TIME.toString());
				getContentPane().add(diskSeek);
				diskSeek.setBounds(171, 44, 59, 21);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Tempo de SEEK: ");
				jLabel1.setBounds(0, 47, 159, 14);
				jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
				jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				hdArm = new JLabel();
				getContentPane().add(hdArm);
				hdArm.setText("Posição Inicial do Braço:");
				hdArm.setBounds(0, 73, 159, 14);
				hdArm.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				configLabel = new JLabel();
				getContentPane().add(configLabel);
				configLabel.setText("Configurações");
				configLabel.setBounds(106, 12, 140, 14);
			}
			{
				saveButton = new JButton();
				saveButton.addActionListener(this);
				saveButton.setActionCommand("SAVE");
				getContentPane().add(saveButton);
				saveButton.setText("Salvar");
				saveButton.setBounds(27, 115, 97, 21);
			}
			{
				cancelButton = new JButton();
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("CANCEL");
				getContentPane().add(cancelButton);
				cancelButton.setText("Cancelar");
				cancelButton.setBounds(153, 115, 98, 21);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if (command.equalsIgnoreCase("SAVE")) {
			
			LocalVariables.DISK_ARM_INIT = Integer.parseInt(armPosition.getText());
			LocalVariables.DISK_SEEK_TIME = Integer.parseInt(diskSeek.getText());
			
			this.dispose();
			
		} else if (command.equalsIgnoreCase("CANCEL")) {
			
			this.dispose();
			
		}
		
	}

}
