package Model;

public class FonctionUsuelle {

	String fonctionActuel;
	public FonctionUsuelle(String fonctionActuel) {
		this.fonctionActuel=fonctionActuel;
	}
	
	public void  traitementSignal(double pas, int puissanceDe2, double intervalleDebut, double intervalleFin)
	{
			Echantillonage ech = new Echantillonage(pas, puissanceDe2, intervalleDebut, intervalleFin);
			ech.prepareFenetre(fonctionActuel);
			ech.showVecteurAj();
	}
	
	//getters and setters
	public String getFonctionActuel() {
		return fonctionActuel;
	}

	public void setFonctionActuel(String fonctionActuel) {
		this.fonctionActuel = fonctionActuel;
	}
	
	
}
