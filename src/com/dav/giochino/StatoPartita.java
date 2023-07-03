package com.dav.giochino;


/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */
public class StatoPartita{
	
	private int win = 0;
	private double amountOfTimesOfBonus = 0;	//total of time of bonus
	private int credits = 0;		
	private double totalOfCoinGainedWithBonus =0;	//gain from bonus
	private int hit =0;
	private int gamesInARound =10;

	private double diceSum =0;

	
	
	
	public double getDiceSum() {
		return diceSum;
	}
	public void setDiceSum(double diceSum) {
		this.diceSum = diceSum;
	}
	public int getGamesInARound() {
		return gamesInARound;
	}
	public void setGamesInARound(int partiteNelRound) {
		this.gamesInARound = partiteNelRound;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getTotalOfCoinGainedWithBonus() {
		return totalOfCoinGainedWithBonus;
	}
	public void setTotalOfCoinGainedWithBonus(double totaleBonus) {
		this.totalOfCoinGainedWithBonus = totaleBonus;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public double getAmountOfTimesOfBonus() {
		return amountOfTimesOfBonus;
	}
	public void setAmountOfTimesOfBonus(double d) {
		this.amountOfTimesOfBonus = d;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int punteggio) {
		this.win = punteggio;
	}
	

	public StatoPartita(int credits){
		this.credits=credits;
	}

}