package Model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echantillonage {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(Echantillonage.class);
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Echantillon
	int nbPoint;
	// domaine de definition
	double debutIntervalle;
	double finIntervalle;
	//  taille de la fenetre en 2^n
	int tailleFenetre;
	//vecteur de complex
	ArrayList<Complex> u;
	// tableau de vecteur  u
	ArrayList<ArrayList<Complex>> f;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Echantillonage( int nbPoint, double debutIntervalle, double finIntervalle) {
		this.nbPoint=nbPoint;
		this.debutIntervalle=debutIntervalle;
		this.finIntervalle=finIntervalle;
		u=null;
		f=null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void prepareFenetre(String fonction){
		if(fonction.equals("cos(x")){
			double i;
			int j;
			
			double pas;
			pas=(finIntervalle-debutIntervalle)/nbPoint;
			Complex cplx = new Complex(0,0);
			ArrayList<Complex> v= new ArrayList<Complex>();
			FFT fenetre = new FFT();
			
			
			for(i=debutIntervalle; i<finIntervalle; i=i+pas ){
				Complex complex = new Complex(Math.cos(i),0);
				u.add(complex);
			}
			
			
			// parcour le vecteur u est fait des paquet de 2^n quand le vecteur v
			// v est range dans un tableau de vecteur
			for(j=0; j<u.size(); j++){
				if(j%tailleFenetre==0){
					v=fenetre.fft(v);
					f.add(v);
					v = new ArrayList<Complex>(); 
					LOGGER.info(" Fenetre : " + f.size());
					fenetre.show(v,"aj");
				}
				v.add(u.get(j));
			}
			
			// si la derneire fenetre n est pas en 2^n on la remplit de 0
			if(v.size()!=tailleFenetre){
				for(j=v.size();j<=tailleFenetre; j++){
					v.add(cplx);
				}
				v=fenetre.fft(v);
				f.add(v);
				fenetre.show(v, "aj ");
			}
			
			
		}
	}
	
	
	
	
}
