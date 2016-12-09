package Model;

import java.util.ArrayList;
import java.util.Observable;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/******************************************************************************
	 *  Compilation:  javac FFT.java
	 *  Execution:    java FFT n
	 *  Dependencies: Complex.java
	 *
	 *  Compute the FFT and inverse FFT of a length n complex sequence.
	 *  Bare bones implementation that runs in O(n log n) time. Our goal
	 *  is to optimize the clarity of the code, rather than performance.
	 *
	 *  Limitations
	 *  -----------
	 *   -  assumes n is a power of 2
	 *
	 *   -  not the most memory efficient algorithm (because it uses
	 *      an object type for representing complex numbers and because
	 *      it re-allocates memory for the subarray, instead of doing
	 *      in-place or reusing a single temporary array)
	 *  
	 ******************************************************************************/

	public class FFT extends Observable{
		
		
		private static final Logger LOGGER= LoggerFactory.getLogger(FFT.class);
		
		//// constructeur par defaut ////
		public FFT(){
			
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	    // FFT prenant en compte une taille fenetre de 2^n
	    public ArrayList<Complex> fft(ArrayList<Complex> x) {
	        int n = x.size();
	        // base case
	        if (n == 1){
	        	ArrayList<Complex> back =new ArrayList<Complex>();
	        	back.add(x.get(0));
	        	return back;
	        }

	        // test le 2^n
	        if (n % 2 != 0) { throw new RuntimeException("n is not a power of 2"); }

	        // fft valeur pair
	        ArrayList<Complex> even = new ArrayList<Complex>();
	        for (int k = 0; k < n/2; k++) {
	            even.add(x.get(2*k));
	        }
	        ArrayList<Complex> q = new ArrayList<Complex>();
	        q=fft(even);

	        // fft valeur impair
	        ArrayList<Complex> odd = new ArrayList<Complex>();
	        for (int k = 0; k < n/2; k++) {
	            odd.add(x.get(2*k+1));
	        }
	        ArrayList<Complex> r = new ArrayList<Complex>();
	        r=fft(odd);

	        
	        ArrayList<Complex> y = new ArrayList<Complex>();
	        ArrayList<Complex> v = new ArrayList<Complex>();
	        
	        // remonte de la recursion avec l'application des Wk
	        for (int k = 0; k < n/2; k++) {
	            double kth = -2 * k * Math.PI / n;
	            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
	            // range coef de 1->N/2
	            y.add( q.get(k).plus( wk.times( r.get(k) ) ) );
	            // range coef de N/2->
	            v.add( q.get(k).minus( wk.times( r.get(k) ) ) );
	   	        }
	        // ajoute les N/2 à N valeur dans y 
	        // => y de 1 à N
	        y.addAll(v);
	        
	        return y;
	    }


	    // compute the inverse FFT of x[], assuming its length is a power of 2
	    public ArrayList<Complex> ifft(ArrayList<Complex> x) {
	        int n = x.size();
	        ArrayList<Complex> y = new ArrayList<Complex>();

	        // take conjugate
	        for (int i = 0; i < n; i++) {
	            y.add(x.get(i).conjugate());
	        }

	        // compute forward FFT
	        y = fft(y);

	        // take conjugate again
	        for (int i = 0; i < n; i++) {
	            y.add(x.get(i).conjugate());
	        }
	        
	        ArrayList<Complex> z = new ArrayList<Complex>();
	        // divide by n
	        for (int i = 0; i < n; i++) {
	           z.add(x.get(i).scale(1.0 / n));
	        }

	        return z;

	    }
	    
	    // renvoie un exemple de FFT
	    public ArrayList<Complex> fftExemple(){
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
	        return x;
	    }

	    // display an array of Complex numbers to standard output
	    public void show(ArrayList<Complex> x, String title) {
	        LOGGER.info(title.toString());
	        LOGGER.info("-----------------------------");
	        for (int i = 0; i < x.size(); i++) {
	        	   System.out.println(x.get(i));
	        }
	    }

}