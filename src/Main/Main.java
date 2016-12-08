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
		AfficheValeurView aView= new AfficheValeurView();
		FenetreController controller = new FenetreController();
		controller.init(fView,aView);
		controller.displayFViews();
		
	}

}
