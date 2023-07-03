package com.dav.giochino;

/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */

public class SlotMachine {


	public static void main(String[] args) {
		
		Grid grid = null;
		int tenMillionCoin =10000000;
		
		//impostazione della partita con dieciMilioni di gettoni
		StatoPartita stato = new StatoPartita(tenMillionCoin);
		
		//gioco
		while(stato.getCredits()>0) {
			Round r = new Round();
			grid = r.giocaround(stato);
			
			stato.setGamesInARound(stato.getGamesInARound()-1);
			if(stato.getGamesInARound()<=0) {
				stato.setGamesInARound(10);
			}
			
		}
		
		//fratto 10 per ogni round
		int round = 10;
		
		double totalWin = grid.getStato().getWin()/(float)tenMillionCoin;
		
		double hitfreq=((double)tenMillionCoin / grid.getStato().getAmountOfTimesOfBonus()/(double)round);
		
		double averageBonWin=(float)grid.getStato().getTotalOfCoinGainedWithBonus()/hitfreq;
		
		double averageDice = grid.getStato().getDiceSum()/grid.getStato().getAmountOfTimesOfBonus();
		
		double bonusGameAverageWin = averageDice * averageBonWin * round;
		
		double bonusGameReturn = bonusGameAverageWin /hitfreq / round;
		
		System.out.println("Starting with an amount of coin of :\t\t" + tenMillionCoin);	//percentuale

		System.out.println("Base Game return :\t\t\t\t" + totalWin * 100 + " %" );

		System.out.println("Average Bonus Game return :\t\t\t" + averageBonWin + " %" );
		
		System.out.println("Coins won with a Bonus Game :\t\t\t" + bonusGameAverageWin);

		System.out.println("Hit frequency in Bonus Games : \t\t\t" + hitfreq);

		System.out.println("Bonus Game return :\t\t\t\t" + (bonusGameReturn *100) + " %");	//percentuale

		System.out.println("Total of hits :\t\t\t\t\t" + stato.getHit());

		System.out.println("Total of coins lost :\t\t\t\t" + ( tenMillionCoin-grid.getStato().getWin()));
	

	}
}
