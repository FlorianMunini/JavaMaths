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
	
	
	public FenetreView() {
		setFrame();
		

	}
	public void setFrame() {
		
		frame = new JFrame();
		JMenuBar m = new JMenuBar();
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Edition");
		// separe d'un trait

		JMenu nouveau = new JMenu("Nouveau");
		JMenuItem nouveauSon = new JMenuItem("A partir d'un fichier son");
		nouveau.add(nouveauSon);
		JMenuItem nouveauUsuel = new JMenuItem("A partir d'une fonction usuelle");
		nouveau.add(nouveauUsuel);
		JMenuItem nouvelleFonction = new JMenuItem("A partir d'une fonction non définie");
		nouveau.add(nouvelleFonction);
		menu1.add(nouveau);
		JMenuItem annuler = new JMenuItem("Annuler");
		menu2.add(annuler);
		/*
		 * annuler.addActionListener(test); JMenuItem enregistrer= new
		 * JMenuItem("Enregistrer en .png"); menu1.add(enregistrer);
		 * menu1.addSeparator(); JMenuItem save= new
		 * JMenuItem("Enregistrer en .txt"); menu1.add(save);
		 */
		JMenuItem load = new JMenuItem("Charger le .txt");
		menu1.add(load);
		menu1.addSeparator();
		JMenuItem quitter = new JMenuItem("Quitter");
		menu1.add(quitter);
		m.add(menu1);
		m.add(menu2);

		frame.setJMenuBar(m);

		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		/*
		 * load.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent arg0) { Load l=new Load();
		 * l.main(fft.liste);
		 * 
		 * 
		 * } });
		 */
		/*
		 * enregistrer.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent arg0) {
		 * 
		 * } });
		 * 
		 * nouveaudessin.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent arg0) { draw.delete(); } });
		 * 
		 * save.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent arg0) { Save s=new Save();
		 * s.main(draw.liste); } });
		 * 
		 * 
		 */

		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		// nouveaudessin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
		// KeyEvent.CTRL_DOWN_MASK));
		// enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
		// KeyEvent.CTRL_DOWN_MASK));
		// annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
		// KeyEvent.CTRL_DOWN_MASK));

		
		
		
		
		fPane = new JPanel();

		fPane.setLayout(new GridLayout(2, 1));
		JPanel tPane = new JPanel();
		tPane.setLayout(new GridLayout(2, 2));

		JPanel bPane = new JPanel();
		bPane.setLayout(new GridLayout(3, 3));

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

		JLabel label2 = new JLabel("Nombre d'échantillon");
		tPane.add(label2, BorderLayout.CENTER);

		Integer[] pow = { 2, 4, 8, 16, 32, 64, 128, 256, 512 };
		JComboBox powList = new JComboBox(pow);
		tPane.add(powList, BorderLayout.CENTER);

		button = new JButton("Mettre à jour");
		bPane.add(button);
		button.addActionListener(this);

		fPane.add(tPane);
		fPane.add(bPane);
		frame.setContentPane(fPane);
		frame.setTitle("Projet Java Maths");
		frame.pack();
	

	
		
	}

	

	public void display() {
		frame.setTitle("Ma première fenêtre Java");
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void close() {

		frame.dispose();
	}
	
	 public void actionPerformed(ActionEvent e) {

	      
	    }

	   
	    public void update(Observable o, Object arg) {
	        if (arg instanceof Integer) {
	            
	            System.out.println("[FieldVolumeView] : update");
	        }
	    }

}
