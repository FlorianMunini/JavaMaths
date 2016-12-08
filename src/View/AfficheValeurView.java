package View;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.FenetreController;
import Model.FFT;

import Main.Main;
import Model.Complex;

public class AfficheValeurView implements ActionListener, Observer {

	// Mon Controller
	protected FFT fft;
	private JFrame frame=null;
	private FenetreController controller = null;
	private JPanel fPane=null;
	private NumberFormat format = null;
	private JSpinner spinner=null;
	private JButton button=null;
	
	
	public AfficheValeurView() {
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
		tPane.setLayout(new GridLayout(2, 1));

		JPanel bPane = new JPanel();
		bPane.setLayout(new GridLayout(1, 1));
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
		JLabel label2 = new JLabel("Quelle fonction usuelle voulez vous?");
		tPane.add(label2, BorderLayout.CENTER);

		String[] pow = { "cos(x)","sin(x)"};
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
		frame.setTitle("Ma deuxieme fenêtre Java");
		frame.setSize(300, 200);
		frame.setLocation(300, 100);
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
	
	

