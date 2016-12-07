package Main;

import Controller.FenetreController;
import View.FenetreView;

public class Main {

	public static void main(String[] args) {
		FenetreView fView= new FenetreView();
		
		FenetreController controller = new FenetreController();
		controller.init(fView);
		controller.displayViews();
	}

}
