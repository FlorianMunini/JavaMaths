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
        Complex n1 = new Complex(0,0);
        Complex n2 = new Complex(1,0);
        Complex n3 = new Complex(0,0);
        Complex n4 = new Complex(1,0);
        Complex n5 = new Complex(0,0);
        Complex n6 = new Complex(1,0);
        Complex n7 = new Complex(1,0);
        Complex n8 = new Complex(1,0);
        
        x.add(n1);
        x.add(n2);
        x.add(n3);
        x.add(n4);
        x.add(n5);
        x.add(n6);
        x.add(n7);
        x.add(n8);
	
        x=ftt.fft(x);
        System.out.println("FFT");
        System.out.println("-------------------");
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
	}


}