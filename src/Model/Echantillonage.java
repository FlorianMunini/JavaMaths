package Model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echantillonage {
	
	// initialisation logger
	private static final Logger LOGGER= LoggerFactory.getLogger(Echantillonage.class);
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//// Attribut //// 
	
	// Echantillon
	protected double pas;
	// domaine de definition
	protected double debutIntervalle;
	protected double finIntervalle;
	//  taille de la fenetre en 2^n
	protected int tailleFenetre;
	//vecteur de complex
	protected ArrayList<Complex> u;
	// tableau de vecteur  u
	protected ArrayList<ArrayList<Complex>> f;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//// Constructeur ////
	
	public Echantillonage( double pas, int taille, double debutIntervalle, double finIntervalle) {
		this.tailleFenetre=taille;
		this.debutIntervalle=debutIntervalle;
		this.finIntervalle=finIntervalle;
		this.pas=pas;
		u = new ArrayList<Complex>();
		f = new ArrayList< ArrayList<Complex>>();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Methods ////
	
	public ArrayList<ArrayList<Complex>> prepareFenetre(String fonction){
		
		Complex cplx = new Complex(0,0);
		ArrayList<Complex> v= new ArrayList<Complex>();
		FFT fenetre = new FFT();
		
		if(fonction.equals("sin(x)")){
			LOGGER.info(" fonction sin(x) detectée ");
			double i;
			for(i=debutIntervalle; i<=finIntervalle; i=i+pas ){
				Complex complex = new Complex(Math.sin(i),0);
				u.add(complex);
			}
		}
			if(fonction.equals("cos(x)")){
				LOGGER.info(" fonction cos(x) detectée ");
				double i;
				for(i=debutIntervalle; i<=finIntervalle; i=i+pas ){
					Complex complex = new Complex(Math.cos(i),0);
					u.add(complex);
				}
			}
			
			// indice
			int j;
			// flag de premiere boucle
			int flag;
			// decalage d indice
			int c;
			
			j=0;
			c=0;
			flag=0;
			
			LOGGER.debug(" fft ");
			// parcour le vecteur u 
			while(j<u.size()){
				// range le vecteur tampon v 
				// et en crée un nouveau
				if( ( j%(tailleFenetre+c) == 0 ) && ( flag ==1 )){
					// fft du vecteur v
					v=fenetre.fft(v);
					// ajoute v dans le tableau de f
					f.add(v);
					// reinitialise le vecteur v 
					v = new ArrayList<Complex>();
					// cree le decalage d indice
					c=c+(tailleFenetre/2);
					j=j-(tailleFenetre/2);
				}
				// ajoute un point au vecteur v
				v.add(u.get(j));
				j=j+1;
				// premiere boucle initialise
				flag=1;
			}
			
			
			// si la derneire fenetre n est pas en 2^n on la remplit de 0
			if(v.size()!=tailleFenetre){
				for(j=v.size();j<tailleFenetre; j++){
					v.add(cplx);
				}
				v=fenetre.fft(v);
				f.add(v);
			}
			return f;
		}
	
	
	public  void showVecteurAj(){
		int i;
		int j;
		ArrayList<Complex> v =new ArrayList<Complex>();
		
		for(i=0; i<f.size();i++){
			v=f.get(i);
			LOGGER.info("----------------------- Fenetre "+i+" ---------------------------");
			for(j=0; j<v.size();j++){
				LOGGER.info("---- :  "+v.get(j));
			}
		}
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	////Getters and Setters////
	public double getPas() {
		return pas;
	}

	public void setPas(double pas) {
		this.pas = pas;
	}

	public double getDebutIntervalle() {
		return debutIntervalle;
	}

	public void setDebutIntervalle(double debutIntervalle) {
		this.debutIntervalle = debutIntervalle;
	}

	public double getFinIntervalle() {
		return finIntervalle;
	}

	public void setFinIntervalle(double finIntervalle) {
		this.finIntervalle = finIntervalle;
	}

	public int getTailleFenetre() {
		return tailleFenetre;
	}

	public void setTailleFenetre(int tailleFenetre) {
		this.tailleFenetre = tailleFenetre;
	}

	public ArrayList<Complex> getU() {
		return u;
	}

	public void setU(ArrayList<Complex> u) {
		this.u = u;
	}

	public ArrayList<ArrayList<Complex>> getF() {
		return f;
	}

	public void setF(ArrayList<ArrayList<Complex>> f) {
		this.f = f;
	}
	
}
