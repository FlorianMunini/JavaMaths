package Model;

import java.util.ArrayList;

public class FonctionUsuelle {

	//// attribut ////
	String fonctionActuel;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//// Constructeur ////
	public FonctionUsuelle(String fonctionActuel) {
		this.fonctionActuel=fonctionActuel;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//// Methodes ////
	
	// fait une analyse du signal
	public ArrayList<ArrayList<Complex>>  traitementSignal(double pas, int puissanceDe2, double intervalleDebut, double intervalleFin)
	{
			
			Echantillonage ech = new Echantillonage(pas, puissanceDe2, intervalleDebut, intervalleFin);
			ArrayList<ArrayList<Complex>> f = new ArrayList<ArrayList<Complex>>();
			f=ech.prepareFenetre(fonctionActuel);
			for(int i = 0; i<f.size(); i++){
				for(int j=0; j<f.get(i).size(); j++){
					f.get(i).get(j).module();
				}
			}
			return f;
	}
	
	 // renvoie un exemple de FFT
    public ArrayList<Complex> fftExemple(){
    	FFT ftt = new FFT();
        ArrayList<Complex> x = new ArrayList<Complex>();

        // original data
        Complex n1 = new Complex(1,0);
        Complex n2 = new Complex(2,0);
        Complex n3 = new Complex(3,0);
        Complex n4 = new Complex(4,0);
        
        x.add(n1);
        x.add(n2);
        x.add(n3);
        x.add(n4);
	
        x=ftt.fft(x);
        return x;
    }
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	////getters and setters////
	public String getFonctionActuel() {
		return fonctionActuel;
	}

	public void setFonctionActuel(String fonctionActuel) {
		this.fonctionActuel = fonctionActuel;
	}
	
	
}
