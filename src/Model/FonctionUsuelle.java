package Model;

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
	public void  traitementSignal(double pas, int puissanceDe2, double intervalleDebut, double intervalleFin)
	{
			
			Echantillonage ech = new Echantillonage(pas, puissanceDe2, intervalleDebut, intervalleFin);
			// prepare les fenetres et fais la FFT de chacune d elle
			ech.prepareFenetre(fonctionActuel);
			// affiche en console le resultat obtenu
			ech.showVecteurAj();
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
