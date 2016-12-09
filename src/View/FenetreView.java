package View;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.FenetreController;

import Model.FFT;
import Model.Load;

public class FenetreView implements ActionListener, Observer {

	protected FFT fft;
	private JFrame frame=null;
	private FenetreController controller = null;
	private JPanel fPane=null;
	private NumberFormat format = null;
	private JSpinner spinner=null;
	private JButton button=null;
	private JFormattedTextField text = null;
	private JComboBox powList2 =null;
	private JComboBox powList =null;
	
	
	
	
	public FenetreView() {
		setFrame();
		

	}
	public void setFrame() {
		
		
		frame = new JFrame();
		JMenuBar m = new JMenuBar();
		JMenu menu1 = new JMenu("Fichier");
		
		// separe d'un trait

		JMenu nouveau = new JMenu("Nouveau");
		JMenuItem nouveauSon = new JMenuItem("A partir d'un fichier son");
		nouveau.add(nouveauSon);
		JMenuItem nouveauUsuel = new JMenuItem("A partir d'une fonction usuelle");
		nouveau.add(nouveauUsuel);
		JMenuItem nouvelleFonction = new JMenuItem("A partir d'une fonction non définie test");
		nouveau.add(nouvelleFonction);
		menu1.add(nouveau);
		JMenuItem load = new JMenuItem("Charger le .wave");
		menu1.add(load);
		menu1.addSeparator();
		JMenuItem quitter = new JMenuItem("Quitter");
		menu1.add(quitter);
		m.add(menu1);

		frame.setJMenuBar(m);

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));

		fPane = new JPanel();
		fPane.setLayout(new GridLayout(2, 1));
		JPanel tPane = new JPanel();
		tPane.setLayout(new GridLayout(3, 2));
		
		JPanel bPane = new JPanel();
		/*
		JLabel label = new JLabel("Nombre d'échantillon par sec");
		tPane.add(label, BorderLayout.CENTER);

		format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(0);
		format.setMaximumIntegerDigits(3);

		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(100),
				new Integer(5));
		spinner = new JSpinner(spinnerModel);
		tPane.add(spinner, BorderLayout.CENTER);
		 */
		
		JLabel label3 = new JLabel("Quelle fonction usuelle voulez vous?");
		tPane.add(label3);

		String[] pow2 = { "cos(x)","sin(x)"};
		powList2 = new JComboBox(pow2);
		tPane.add(powList2);
		
		JLabel label = new JLabel("Pas de la courbe");
		tPane.add(label);
		JTextField text =new JTextField();
		tPane.add(text);

		JLabel label2 = new JLabel("Nombre d'échantillon en puissance de 2");
		tPane.add(label2);

		Integer[] pow = { 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,2048,4096 };
		powList = new JComboBox(pow);
		tPane.add(powList);
		
		

		button = new JButton("Afficher le graphique");
		bPane.add(button, BorderLayout.SOUTH);
		button.addActionListener(this);

		fPane.add(tPane);
		fPane.add(bPane);
		frame.setContentPane(fPane);
		frame.setTitle("Projet Java Maths");
		frame.pack();
		button.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) { 
				
				}
			});
		nouvelleFonction.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) { 
				 ListeView lView=new ListeView();
				 lView.display();
				}
			});
		nouveauUsuel.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent arg0) { 
				 FenetreView fView=new FenetreView();
				 fView.display();
				}
			});
	}

	

	public void display() {
		frame.setTitle("Fonctions usuelles");
		frame.setSize(600, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public JComboBox getPowList() {
		return powList;
	}
	public JComboBox getPowList2() {
		return powList2;
	}
	public void close() {

		frame.dispose();
	}
	
	 public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		
	      Object contenu=e.getActionCommand();
	      if (contenu.equals("Afficher le graphique")){
	    	  GraphiqueView gView=new GraphiqueView();
				
	    	  this.controller.notifyFonctionSet(Integer.parseInt(this.text.getValue().toString()),this.getPowList2().getSelectedItem().toString(),Integer.parseInt(this.getPowList().getSelectedItem().toString()));
	      
	      }
=======
		 Object contenu = e.getActionCommand();
		 if(contenu.equals("Afficher le graphique")){
			 
		 }
>>>>>>> b53a75d01e1323bb7f9868f587755fde4a3d9a27
	    }

	   
	    public void update(Observable o, Object arg) {
	        if (arg instanceof Integer) {
	            
	            System.out.println("[FieldVolumeView] : update");
	        }
	    }

}
