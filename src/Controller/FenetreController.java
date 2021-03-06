package Controller;



import java.util.ArrayList;

import Model.Complex;
import Model.FonctionUsuelle;
import View.FenetreView;
import View.GraphiqueView;
import View.ListeView;

public class FenetreController {
	
	private FonctionUsuelle fonctionU=null;
	public FenetreView fenetreView = null;
	public ListeView listeView=null;
	public GraphiqueView graphView=null;
	private ArrayList<ArrayList<Complex>> AA=null;
	
	public FenetreController() {

       
    }
	
		public void init(FenetreView fView,GraphiqueView gView,FonctionUsuelle fctU,ListeView lView) {
			
	        this.fenetreView = fView;
	        this.fonctionU=fctU;
	        this.graphView=gView;
	        this.listeView=lView;
	    }

	    public void displayFViews() {
	        this.fenetreView.display();
	        
	    }
	    public void displayGViews() {
	    	this.graphView.display();
	    }
	    public void displayLViews() {
	    	this.listeView.display();
	    }
	    

	    public void closeFViews() {
	      this.fenetreView.close();    
	    }
	    public void closeLViews() {
		      this.listeView.close();    
		    }
	    
	    public void closeGViews() {
		      this.graphView.close();    
		    }
	    
	    public void closeAllViews() {
	    	  this.fenetreView.close();    
		      this.graphView.close();    
		    }
	    
	    public void notifyFonctionSet(int pas, String fct, int nbEch){
	    	// Probleme de récupération manque de temps pour passer en attributs
	    	fonctionU.setFonctionActuel(fct);
	    	AA=fonctionU.traitementSignal(pas,nbEch, -Math.PI, Math.PI);
	    	
	    }


}
