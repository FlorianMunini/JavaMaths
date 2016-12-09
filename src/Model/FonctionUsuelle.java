package Model;

import java.util.ArrayList;

public class FonctionUsuelle {

	String fonctionActuel;
	public FonctionUsuelle(String fonctionActuel) {
		this.fonctionActuel=fonctionActuel;
	}
	
	public ArrayList<ArrayList<Complex>>  traitementSignal(double pas, int puissanceDe2, double intervalleDebut, double intervalleFin)
	{
			Echantillonage ech = new Echantillonage(pas, puissanceDe2, intervalleDebut, intervalleFin);
			return ech.prepareFenetre(fonctionActuel);
	}
	
	//getters and setters
	public String getFonctionActuel() {
		return fonctionActuel;
	}

	public void setFonctionActuel(String fonctionActuel) {
		this.fonctionActuel = fonctionActuel;
	}
	
	
}
