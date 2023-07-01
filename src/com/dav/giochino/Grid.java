package com.dav.giochino;


/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */
public class Grid {


	private StatoPartita stato;
	
	int n=3;
	Casella[][] griglia=new Casella[n][n];
	Strisce str;

	public StatoPartita getStato() {
		return stato;
	}

	public void setStato(StatoPartita stato) {
		this.stato = stato;
	}

	public Casella[][] getGriglia() {
		return griglia;
	}

	public void setGriglia(Casella[][] griglia) {
		this.griglia = griglia;
	}

	public Grid(StatoPartita stato){
		this.stato=stato;
	}

	public Casella [][] start(int start1,int start2,int start3) {
		 str= new Strisce();
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(i==0)this.griglia[j][i] = str.arr1[(j+start1)%(str.arr1.length)];
				if(i==1)this.griglia[j][i] = str.arr2[(j+start2)%(str.arr2.length)];
				if(i==2)this.griglia[j][i] = str.arr3[(j+start3)%(str.arr3.length)];
			}
		}
		
		return griglia;
		
	}

	
}
