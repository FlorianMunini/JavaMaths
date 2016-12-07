package Controller;


import View.FenetreView;

public class FenetreController {

	public FenetreView fenetreView = null;
	
	public FenetreController() {

       
    }
	
	 public void init(FenetreView fView) {
	        this.fenetreView = fView;
	    }

	    public void displayViews() {
	        this.fenetreView.display();
	    }

	    public void closeViews() {
	     //   this.fenetreView.close();    
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
