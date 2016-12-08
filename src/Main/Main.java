package Main;

import java.util.ArrayList;

import Controller.FenetreController;
import Model.Complex;
import Model.FFT;
import View.FenetreView;
import View.GraphiqueView;

public class Main {

	public static void main(String[] args) {
		FenetreView fView= new FenetreView();

		GraphiqueView gView=new GraphiqueView();
		FenetreController controller = new FenetreController();
		controller.init(fView,gView);
		controller.displayFViews();
	}

}
