package Model;

public class FonctionUsuelle {

	String fonctionActuel;
	public FonctionUsuelle(String fonctionActuel) {
		this.fonctionActuel=fonctionActuel;
	}
	
	public void  traitementSignal()
	{
			Echantillonage ech = new Echantillonage(1024,-Math.PI,Math.PI);
			ech.prepareFenetre(fonctionActuel);
	}
	
	//getters and setters
	public String getFonctionActuel() {
		return fonctionActuel;
	}

	public void setFonctionActuel(String fonctionActuel) {
		this.fonctionActuel = fonctionActuel;
	}
	
	
}
