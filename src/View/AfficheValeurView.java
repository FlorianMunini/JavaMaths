package View;



import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.FenetreController;
import Model.FFT;

import Main.Main;
import Model.Complex;

public class AfficheValeurView implements ActionListener, Observer {

	// Mon Controller
	private FenetreController myController = null;
	// Mon modèle
	private FFT myfft = null;

	private JFrame frame = null;
	private JPanel contentPane = null;
	private JSpinner spinner = null;
	private JButton button = null;
	private JLabel label = null;
	private JTable table=null;
	private DefaultListModel ContenueList=null;
	private JList list=null;
	private ListSelectionListener l;

	

	public  AfficheValeurView  (FFT model,FenetreController controller,ArrayList<Complex> tab) {
		this.myfft = model;
		this.myfft.addObserver(this);
		this.myController = controller;
		buildFrame(tab);
	}

	private void buildFrame(ArrayList<Complex> tab) {
		frame = new JFrame();
		GridLayout aze =new GridLayout(2, 2);
		contentPane = new JPanel();
		spinner = new JSpinner();
		contentPane.add(spinner);
		button = new JButton("afficher Coeffs");
		button.addActionListener(this);
		contentPane.add(button);
	
		JTable table = new JTable();
		ContenueList =new DefaultListModel();
		
        list = new JList(ContenueList);
     
	list.addListSelectionListener(l);
     
		JLabel cases= new JLabel();
		for (int i=0; i<tab.size(); i++)
		{
			cases.setText("cazahjkzera");
			ContenueList.addElement(tab.get(i));;
			table.add(cases);
		}
		table.setVisible(true);
		list.setVisible(true);
		contentPane.add(cases);
		contentPane.add(list);
		contentPane.add(table);
		frame.setContentPane(contentPane);
		frame.setTitle("FFT");
		frame.pack();
	}
	
	public void setFrameSize(int a, int b)
	{
		this.frame.setSize(a, b);
	}
	
	
	
	

	public void close() {
		frame.dispose();
	}

	public void display() {
		frame.setVisible(true);
	}


	public void update(Observable o, Object arg) {
		// if (arg instanceof Integer)
				// spinner.setValue((Integer) arg);
				// System.out.println("[SpinnerVolumeView] : update");
	}


	public void actionPerformed(ActionEvent e) {
		// this.controller.notifyVolumeChanged(Integer.parseInt(this.spinner.getValue().toString()));
		
	
		Object composant = e.getSource();
		System.out.println(composant.getClass().getName());
		if (composant.getClass().getName()=="javax.swing.JButton")
		{
			
		}
		
	}
	
	
	public void valueChanged(ListSelectionEvent e) {
		
      System.out.println("azerazeraz");
      
  }
	
	
	

}