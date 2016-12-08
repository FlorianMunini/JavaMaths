package Controller;



import View.FenetreView;
import View.GraphiqueView;

public class FenetreController {

	public FenetreView fenetreView = null;
	
	public GraphiqueView graphView=null;
	
	public FenetreController() {

       
    }
	
		public void init(FenetreView fView,GraphiqueView gView) {
			
	        this.fenetreView = fView;
	     
	        this.graphView=gView;
	    }

	    public void displayFViews() {
	        this.fenetreView.display();
	        
	    }
	    public void displayGViews() {
	    	this.graphView.display();
	    }
	    

	    public void closeFViews() {
	      this.fenetreView.close();    
	    }
	    public void closeGViews() {
		      this.graphView.close();    
		    }
	    
	    public void closeAllViews() {
	    	  this.fenetreView.close();    
		      this.graphView.close();    
		    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
