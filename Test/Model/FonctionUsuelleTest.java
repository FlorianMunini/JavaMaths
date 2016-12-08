package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FonctionUsuelleTest {

	@Test
	public void test() {
		double PI = Math.PI;
		FonctionUsuelle fonction = new FonctionUsuelle("sin(x)");
		fonction.traitementSignal(PI/4, 4, -PI, PI);
	}

}
