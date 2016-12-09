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
<<<<<<< HEAD
		fonction.traitementSignal(PI/4, 8, -PI, PI);
=======
		ArrayList<ArrayList<Complex>> f = new ArrayList<ArrayList<Complex>>();
		f=fonction.traitementSignal(PI/4, 4, -PI, PI);
		for(int i=0; i<f.size(); i++){
			for(int j=0; j<f.get(i).size(); j++){
			LOGGER.info("Re :"+f.get(i).get(j).getRe()+" Im :"+f.get(i).get(j).getIm());
			}
		}
>>>>>>> 94ffc73624bced0234a1144cbd0dd89c16debba6
	}
}
