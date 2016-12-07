package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FFTTest {

	@Test
	public void test() {
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
        System.out.println("FFT");
        System.out.println("-------------------");
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
	}


}