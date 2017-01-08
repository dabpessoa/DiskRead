package br.unifor.gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import br.unifor.bean.Algoritmo;
import br.unifor.business.Generator;
import br.unifor.core.Controller;
import br.unifor.util.FileUtils;
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
public class PrincipalUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton requestsButton;
	private JTextField requestText;
	private JLabel requisicoesLabel;
	private JTextArea logTextArea;
	private JButton generatorButton;
	private JCheckBox checkAll;
	private JMenu jMenu1;
	private JMenuBar menu;
	private JButton exitButton;
	private JLabel hdIconLabel;
	private JCheckBox algCSCANCheck;
	private JCheckBox algSCANCheck;
	private JCheckBox algSSFCheck;
	private JCheckBox algFCFSCheck;
	private JButton startButton;
	private JPanel checksPanel;
	private JSeparator separator;
	private Controller controller;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				PrincipalUI inst = new PrincipalUI("");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PrincipalUI() {}
	
	public PrincipalUI(Controller controller) {
		this.controller = controller;
	}
	
	public PrincipalUI(String a) {
		super();
		iniciarInterface();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void init() {		
		iniciarInterface();
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("br/unifor/resources/hd.png")).getImage());
		this.setLocationRelativeTo(null);
		this.setTitle("Simulador De Atendimento De Requisições");
		this.setVisible(true);
	}
	
//	this.setSize(653, 343);
	private void iniciarInterface() {
		try {
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			this.setSize(653, 343);
			{
				menu = new JMenuBar();
				setJMenuBar(menu);
				{
					jMenu1 = new JMenu("Menu");
					
					JMenuItem config = new JMenuItem("Configurar");
					config.addActionListener(this);
					config.setActionCommand("CONFIG");
				    jMenu1.add(config);
					
				    JMenuItem menuSair = new JMenuItem("Sair");
				    menuSair.addActionListener(this);
				    menuSair.setActionCommand("SAIR");
				    jMenu1.add(menuSair);
				    
				    JMenu jMenu2 = new JMenu("Ajuda");
				    
				    JMenuItem menuAbout = new JMenuItem("Sobre");
				    menuAbout.addActionListener(this);
				    menuAbout.setActionCommand("ABOUT");
				    jMenu2.add(menuAbout);
				    
				    menu.add(jMenu1);
				    menu.add(jMenu2);
				}
			}
			{
				requestsButton = new JButton();
				requestsButton.addActionListener(this);
				requestsButton.setActionCommand("ADD_FILE");
				getContentPane().add(requestsButton);
				requestsButton.setText("Adicionar Arquivo");
				requestsButton.setBounds(259, 43, 173, 21);
			}
			{
				requestText = new JTextField();
				getContentPane().add(requestText);
				requestText.setBounds(91, 17, 539, 21);
				requestText.setText("23;1;68;23;33;2");
			}
			{
				requisicoesLabel = new JLabel();
				getContentPane().add(requisicoesLabel);
				requisicoesLabel.setText("Requisições:");
				requisicoesLabel.setBounds(13, 19, 84, 14);
			}
			{
				checksPanel = new JPanel();
				checksPanel.setLayout(null);
				checksPanel.setBorder(BorderFactory.createTitledBorder(null, "Algoritmos", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
				getContentPane().add(checksPanel);
				checksPanel.setBounds(10, 64, 621, 178);
				{
					algFCFSCheck = new JCheckBox();
					checksPanel.add(algFCFSCheck);
					algFCFSCheck.setText("FCFS (First Come First Served)");
					algFCFSCheck.setBounds(20, 30, 201, 18);
				}
				{
					algSSFCheck = new JCheckBox();
					checksPanel.add(algSSFCheck);
					algSSFCheck.setText("SSF (Shortest Seek First)");
					algSSFCheck.setBounds(20, 57, 194, 18);
				}
				{
					algSCANCheck = new JCheckBox();
					checksPanel.add(algSCANCheck);
					algSCANCheck.setText("SCAN (Elevator)");
					algSCANCheck.setBounds(20, 84, 194, 18);
				}
				{
					algCSCANCheck = new JCheckBox();
					checksPanel.add(algCSCANCheck);
					algCSCANCheck.setText("C-SCAN (Cyclic Elevator)");
					algCSCANCheck.setBounds(20, 111, 194, 18);
				}
				{
					separator = new JSeparator();
					checksPanel.add(separator);
					separator.setBounds(228, 24, 10, 132);
					separator.setOrientation(SwingConstants.VERTICAL);
				}
				{
					hdIconLabel = new JLabel();
					checksPanel.add(hdIconLabel);
					hdIconLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("br/unifor/resources/hd1.png")));
					hdIconLabel.setBounds(264, 21, 145, 150);
				}
				{
					checkAll = new JCheckBox();
					checksPanel.add(checkAll);
					checkAll.setText("Todos");
					checkAll.setBounds(20, 138, 194, 18);
					checkAll.addActionListener(this);
					checkAll.setActionCommand("CHECK_ALL");
				}
				{
					logTextArea = new JTextArea();
					logTextArea.setEditable(false);
					logTextArea.setBorder(BorderFactory.createTitledBorder("Log"));
					{
						JScrollPane scroll = new JScrollPane(logTextArea);
						scroll.setBounds(413, 26, 190, 126);
						scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY));
						checksPanel.add(scroll);
					}
				}
			}
			{
				startButton = new JButton();
				startButton.addActionListener(this);
				startButton.setActionCommand("start");
				getContentPane().add(startButton);
				startButton.setText("Iniciar Simulação");
				startButton.setBounds(319, 251, 153, 21);
			}
			{
				exitButton = new JButton();
				exitButton.addActionListener(this);
				exitButton.setActionCommand("sair");
				getContentPane().add(exitButton);
				exitButton.setText("Sair");
				exitButton.setBounds(483, 251, 148, 21);
			}
			{
				generatorButton = new JButton();
				generatorButton.addActionListener(this);
				generatorButton.setActionCommand("GERAR_ARQUIVO");
				getContentPane().add(generatorButton);
				generatorButton.setText("Gerar Arquivo Aleatório");
				generatorButton.setBounds(443, 44, 186, 19);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if (command.equalsIgnoreCase("SAIR")) {
			System.exit(0);
		} else if (command.equalsIgnoreCase("START")) {
			
			String requests = this.requestText.getText();
			
			if (requests.indexOf(";") != -1) {
				
				String[] aux = requests.split(";");
				Integer[] vet = new Integer[aux.length];
				for (int i = 0 ; i < aux.length ; i++) {
					vet[i] = Integer.parseInt(aux[i]);
				}
				
				Algoritmo.setRequisicoes(vet);
				
			} else {
				LocalVariables.FILE_PATH = requests;
			}
			
			String[] algoritmos = new String[4];
			if (algFCFSCheck.isSelected()) algoritmos[0] = Algoritmo.FCFS;
			if (algSSFCheck.isSelected()) algoritmos[1] = Algoritmo.SSF;
			if (algSCANCheck.isSelected()) algoritmos[2] = Algoritmo.SCAN;
			if (algCSCANCheck.isSelected()) algoritmos[3] = Algoritmo.C_SCAN;
				
			File file = this.createFileChooser(this, "Selecione o Local Onde Deseja Salvar os Resultados");
			if (file != null) controller.criar(file.getAbsolutePath(), algoritmos);
			
		} else if (command.equalsIgnoreCase("ADD_FILE")) {
			
			String[] extensions = {"txt","properties"};
			File file = FileUtils.createFileChooser(this, "Selecione o arquivo de Requisições", extensions, null, FileUtils.OPEN);
			
			if (file != null) {
				this.requestText.setText(file.getAbsolutePath());
				this.requestText.setEnabled(false);
				this.requestsButton.setText("Habilitar Requisições");
			} else {
				this.requestText.setEnabled(true);
				this.requestsButton.setText("Adicionar Arquivo");
				this.requestText.setText("");
			}
			
		} else if(command.equalsIgnoreCase("GERAR_ARQUIVO")) {
			
			Generator g = new Generator();
			StringBuilder content = g.gerarArquivo(1000000);
			
			String[] extensions = {".txt",".properties"};
			FileUtils.createFileChooser(this, "Gerar Arquivo Aleatório", extensions, content.toString(), FileUtils.SAVE);
			
		} else if (command.equalsIgnoreCase("CHECK_ALL")) {
			
			if (checkAll.isSelected()) {
				
				algFCFSCheck.setSelected(true);
				algSSFCheck.setSelected(true);
				algSCANCheck.setSelected(true);
				algCSCANCheck.setSelected(true);
				
			} else {
				
				algFCFSCheck.setSelected(false);
				algSSFCheck.setSelected(false);
				algSCANCheck.setSelected(false);
				algCSCANCheck.setSelected(false);
				
			}
			
		} else if (command.equalsIgnoreCase("CONFIG")) {
			
			
			ConfigUI.getInstance(this);
			
			
		} else if (command.equalsIgnoreCase("ABOUT")) {
			
			About.getInstance(this);
			
		}
		
		
		
	}
	
	 private File createFileChooser(JFrame dad, String title) {
			
		 JFileChooser fc = new JFileChooser();
         
         // restringe a amostra a diretorios apenas
         fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         fc.setDialogTitle(title);
         
         int res = fc.showOpenDialog(dad);
         
         File diretorio = null;
         
         if(res == JFileChooser.APPROVE_OPTION){
             diretorio = fc.getSelectedFile();
         } 
         
         return diretorio;
         
	}
	 
	 public JLabel getHdIconLabel() {
		return hdIconLabel;
	}
	 
	 public JPanel getChecksPanel() {
		return checksPanel;
	}
	 
	public void setImageOriginal() {
		getHdIconLabel().setIcon(new ImageIcon(getClass().getClassLoader().getResource("br/unifor/resources/hd1.png")));
		getChecksPanel().updateUI();
	}
	
	public void logAppend(String text) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String hora = sdf.format(new Date());
		this.logTextArea.append("<"+hora+"> "+text+"\n");
		getChecksPanel().updateUI();
	}

}
