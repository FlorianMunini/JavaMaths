package Main;


import Controller.FenetreController;
import Model.FonctionUsuelle;
import View.FenetreView;
import View.GraphiqueView;
import View.ListeView;

public class Main {

	public static void main(String[] args) {
		FonctionUsuelle model=new FonctionUsuelle(null);
		FenetreView fView= new FenetreView();
		ListeView lView=new ListeView();
		GraphiqueView gView=new GraphiqueView();
		FenetreController controller = new FenetreController();
		controller.init(fView,gView,model,lView);
		controller.displayFViews();
	}

}
