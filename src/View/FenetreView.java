package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



public class FenetreView extends JFrame{

	
	public FenetreView()  {
	  this.setMenu();
	  this.display();
	  
	  }
	
public void setMenu(){
 		
		JMenuBar m=new JMenuBar();
		JMenu menu1=new JMenu ("Fichier");
		JMenu menu2=new JMenu ("Edition");
		// separe d'un trait
		
		JMenu nouveau= new JMenu ("Nouveau");
		JMenuItem nouveauSon= new JMenuItem("A partir d'un fichier son");
		nouveau.add(nouveauSon);
		JMenuItem nouveauUsuel= new JMenuItem("A partir d'une fonction usuelle");
		nouveau.add(nouveauUsuel);
		JMenuItem nouvelleFonction= new JMenuItem("A partir d'une fonction non définie");
		nouveau.add(nouvelleFonction);
		menu1.add(nouveau);
		JMenuItem annuler= new JMenuItem("Annuler");
		menu2.add(annuler);
	//	annuler.addActionListener(test);
		JMenuItem enregistrer= new JMenuItem("Enregistrer en .png");
		menu1.add(enregistrer);
		menu1.addSeparator();
		JMenuItem save= new JMenuItem("Enregistrer en .txt");
		menu1.add(save);
		JMenuItem load= new JMenuItem("Charger les .txt");
		menu1.add(load);
		menu1.addSeparator();
		JMenuItem quitter = new JMenuItem("Quitter");
		menu1.add(quitter);
		m.add(menu1);
		m.add(menu2);
		
		setJMenuBar(m);
		
		
	
		quitter.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent arg0) {
		      System.exit(0);
		    }      
		  });
		 enregistrer.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent arg0) {
			
			    }      
			  });
		/* nouveaudessin.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent arg0) {
			      draw.delete();
			    }      
			  });
		
		 save.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent arg0) {
			    	Save s=new Save();
		 			s.main(draw.liste);
			    }      
			  });
	 			load.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent arg0) {
					Load l=new Load();
		 			l.main(draw.liste);
		 			
		 			draw.repaint();
		 			}      
			  });
		*/
		 
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
	//	nouveaudessin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		
 	}

public void display (){
	    this.setTitle("Ma première fenêtre Java");
	    this.setSize(800, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.setMenu();          
	    this.setVisible(true);
}
	
	
	
}
