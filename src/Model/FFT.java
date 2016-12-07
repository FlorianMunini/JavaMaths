package Model;

import java.util.ArrayList;
import java.util.Observable;

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

	    // compute the FFT of x[], assuming its length is a power of 2
	    public ArrayList<Complex> fft(ArrayList<Complex> x) {
	        int n = x.size();
	        System.out.println("entre");
	        // base case
	        if (n == 1){
	        	ArrayList<Complex> back =new ArrayList<Complex>();
	        	back.add(x.get(0));
	        	return back;
	        }

	        // radix 2 Cooley-Tukey FFT
	        if (n % 2 != 0) { throw new RuntimeException("n is not a power of 2"); }

	        // fft of even terms
	        ArrayList<Complex> even = new ArrayList<Complex>();
	        for (int k = 0; k < n/2; k++) {
	            even.add(x.get(2*k));
	        }
	        ArrayList<Complex> q = new ArrayList<Complex>();
	        q=fft(even);

	        // fft of odd terms
	        ArrayList<Complex> odd = new ArrayList<Complex>();
	        for (int k = 0; k < n/2; k++) {
	            odd.add(x.get(2*k+1));
	        }
	        ArrayList<Complex> r = new ArrayList<Complex>();
	        r=fft(odd);

	        // combine
	        ArrayList<Complex> y = new ArrayList<Complex>();
	        ArrayList<Complex> v = new ArrayList<Complex>();
	        for (int k = 0; k < n/2; k++) {
	            double kth = -2 * k * Math.PI / n;
	            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
	            y.add( q.get(k).plus( wk.times( r.get(k) ) ) );
	            v.add( q.get(k).minus( wk.times( r.get(k) ) ) );
	   	        }
	        y.addAll(v);
	        /*for(int k=n/2; k<n; k++) {
	        	double kth = ((-2 * k * Math.PI)-(n/2)) / n;
	            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
	            System.out.println(kth);
	            y.add( q.get(k-(n/2)).minus( wk.times( r.get(k-(n/2)) ) ) );
	        }*/
	        
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

	        // divide by n
	        for (int i = 0; i < n; i++) {
	           y.add(x.get(i).scale(1.0 / n));
	        }

	        return y;

	    }

	    // compute the circular convolution of x and y
	   /* public static Complex[] cconvolve(Complex[] x, Complex[] y) {

	        // should probably pad x and y with 0s so that they have same length
	        // and are powers of 2
	        if (x.length != y.length) { throw new RuntimeException("Dimensions don't agree"); }

	        int n = x.length;

	        // compute FFT of each sequence
	        Complex[] a = fft(x);
	        Complex[] b = fft(y);

	        // point-wise multiply
	        Complex[] c = new Complex[n];
	        for (int i = 0; i < n; i++) {
	            c[i] = a[i].times(b[i]);
	        }

	        // compute inverse FFT
	        return ifft(c);
	    }


	    // compute the linear convolution of x and y
	    public static Complex[] convolve(Complex[] x, Complex[] y) {
	        Complex ZERO = new Complex(0, 0);

	        Complex[] a = new Complex[2*x.length];
	        for (int i = 0;        i <   x.length; i++) a[i] = x[i];
	        for (int i = x.length; i < 2*x.length; i++) a[i] = ZERO;

	        Complex[] b = new Complex[2*y.length];
	        for (int i = 0;        i <   y.length; i++) b[i] = y[i];
	        for (int i = y.length; i < 2*y.length; i++) b[i] = ZERO;

	        return cconvolve(a, b);
	    } */ 

	    // display an array of Complex numbers to standard output
	    public void show(ArrayList<Complex> x, String title) {
	        System.out.println(title);
	        System.out.println("-------------------");
	        for (int i = 0; i < x.size(); i++) {
	            System.out.println(x.get(i));
	        }
	        System.out.println();
	    }

}