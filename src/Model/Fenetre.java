package Model;

import java.util.ArrayList;

public class Fenetre {

	int ptX1;
	int ptX2;
	ArrayList<Complex> u;
	public Fenetre(ArrayList<Complex>u,int ptX1, int ptX2) {
		this.ptX1=ptX1;
		this.ptX2=ptX2;
		this.u=u;
	}
	
	
	
	// Getters and Setters
	public int getPtX1() {
		return ptX1;
	}
	public void setPtX1(int ptX1) {
		this.ptX1 = ptX1;
	}
	public int getPtX2() {
		return ptX2;
	}
	public void setPtX2(int ptX2) {
		this.ptX2 = ptX2;
	}
	
	
}
