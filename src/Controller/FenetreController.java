package Controller;


import View.AfficheValeurView;
import View.FenetreView;

public class FenetreController {

	public FenetreView fenetreView = null;
	public AfficheValeurView afficheView=null;
	
	public FenetreController() {

       
    }
	
		public void init(FenetreView fView, AfficheValeurView aView) {
			
	        this.fenetreView = fView;
	        this.afficheView=aView;
	    }

	    public void displayViews() {
	        this.fenetreView.display();
	    }

	    public void closeViews() {
	      this.fenetreView.close();    
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
