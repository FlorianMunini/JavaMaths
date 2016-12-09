package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;

import Controller.FenetreController;
import Model.Complex;
import Model.FFT;
import Model.FonctionUsuelle;

public class ListeView implements ActionListener, Observer {

	 
		
		protected FFT fft;
		private JFrame frame=null;
		
		private ArrayList<Complex> x =null;
		private FonctionUsuelle fonction =null;
		
		
		//private JList list=null; 
		//private FenetreController controller = null;
		private JPanel fPane=null;
		//private NumberFormat format = null;
		
		private JButton button=null;
		
		private JFormattedTextField text = null;
		
		
		
		public ListeView() {
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
			JMenuItem nouvelleFonction = new JMenuItem("A partir d'une fonction non définie");
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
			fPane.setLayout(new GridLayout(1, 2));
			
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
			fonction = new FonctionUsuelle("Exemple");
			String[] tab1=new String [1000];
			String[] tab2=new String [1000];
			for(int i=1; i<=4; i++){
			tab1[i]= (i+"+"+"   0i   "+"\n");
			
			}
			 x = new ArrayList<Complex>();
			x=fonction.fftExemple();
			for(int i=0; i<x.size(); i++){
				tab2[i]=(x.get(i).getRe()+"+"+x.get(i).getIm()+"\n");
				
			}
		
			
		
			JList list = new JList(tab1); //data has type Object[]
	        JScrollPane listScroller = new JScrollPane(list);
	        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	        list.setVisibleRowCount(-1);
	        

	        listScroller.setPreferredSize(new Dimension(500, 200));
	        fPane.add(listScroller, BorderLayout.CENTER);
			
	        JList list2 = new JList(tab2); //data has type Object[]
	        JScrollPane listScroller2 = new JScrollPane(list2);
	        list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	        list2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	        list2.setVisibleRowCount(-1);


	        listScroller2.setPreferredSize(new Dimension(500, 200));
	        fPane.add(listScroller2, BorderLayout.CENTER);

		

			
			frame.setContentPane(fPane);
			frame.setTitle("Projet Java Maths");
			frame.pack();
			
		}

		

		public void display() {
			frame.setTitle("Liste Test");
			frame.setSize(500, 400);
			frame.setLocation(300,500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}

		public void close() {

			frame.dispose();
		}
		
		 public void actionPerformed(ActionEvent e) {
			// this.controller.notifyFonctionSet(Integer.parseInt(this.text.getValue().toString()));
		      
		    }

		   
		    public void update(Observable o, Object arg) {
		        if (arg instanceof Integer) {
		            
		            System.out.println("[FieldVolumeView] : update");
		        }
		    }

	}


