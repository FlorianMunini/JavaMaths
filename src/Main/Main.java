package Main;

import java.util.ArrayList;

import Controller.FenetreController;
import Model.Complex;
import Model.FFT;
import View.AfficheValeurView;
import View.FenetreView;

public class Main {

	public static void main(String[] args) {
		FenetreView fView= new FenetreView();
		AfficheValeurView aView=new AfficheValeurView(null,null,null);
		
		FenetreController controller = new FenetreController();
		controller.init(fView,aView);
		controller.displayViews();
		// INI Modele
		ArrayList<Complex> tab = new ArrayList<Complex>();
		for ( int i=0; i < 8; i++){
			tab.add(new Complex(i,4-i));
		}
		
		FFT ffttest = new FFT();
		
		// INI Controller-modèle
		FenetreController control = new FenetreController();
		//INI View
		AfficheValeurView view = new AfficheValeurView(ffttest,control,tab);
		// INI Controller-view
		
	
	   
	       
		
		
		
		
	}

}
