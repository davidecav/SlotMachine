package com.dav.giochino;


/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */
public class StatoPartita{
	
	private int punteggio = 0;
	private double bonusCoin = 0;
	private int credits = 0;
	private double totaleBonus =0;
	private int hit =0;
	private int partiteNelRound =10;

	private double diceSum =0;

	
	
	
	public double getDiceSum() {
		return diceSum;
	}
	public void setDiceSum(double diceSum) {
		this.diceSum = diceSum;
	}
	public int getPartiteNelRound() {
		return partiteNelRound;
	}
	public void setPartiteNelRound(int partiteNelRound) {
		this.partiteNelRound = partiteNelRound;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getTotaleBonus
	() {
		return totaleBonus;
	}
	public void setTotaleBonus(double totaleBonus) {
		this.totaleBonus = totaleBonus;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public double getBonusCoin() {
		return bonusCoin;
	}
	public void setBonusCoin(double d) {
		this.bonusCoin = d;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	

	public StatoPartita(int credits){
		this.credits=credits;
	}

}