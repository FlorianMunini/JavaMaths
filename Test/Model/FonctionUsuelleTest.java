package Model;

import static org.junit.Assert.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.junit.Test;

public class FonctionUsuelleTest {

	private static final Logger LOGGER= LoggerFactory.getLogger(FonctionUsuelle.class);
	
	@Test
	public void test() {
		double PI = Math.PI;
		FonctionUsuelle fonction = new FonctionUsuelle("sin(x)");
	
		ArrayList<ArrayList<Complex>> f = new ArrayList<ArrayList<Complex>>();
		// renvoie le tableau de vecteur aj
		f=fonction.traitementSignal(PI/4, 4, -PI, PI);
		// affiche en console le resultat
		for(int i=0; i<f.size(); i++){
			LOGGER.info("Fenetre "+ i);
			for(int j=0; j<f.get(i).size(); j++){
			LOGGER.info("Re :"+f.get(i).get(j).getRe()+" Im :"+f.get(i).get(j).getIm());
			}
		}
	}
}
