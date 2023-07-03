package com.dav.giochino;

/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */

public class SlotMachine {


	public static void main(String[] args) {
		
		Grid grid = null;
		int dieciMilioni =10000000;
		
		//impostazione della partita con dieciMilioni di gettoni
		StatoPartita stato = new StatoPartita(dieciMilioni);
		
		//gioco
		while(stato.getCredits()>0) {
			Round r = new Round();
			grid = r.giocaround(stato);
			
			stato.setPartiteNelRound(stato.getPartiteNelRound()-1);
			if(stato.getPartiteNelRound()<=0) {
				stato.setPartiteNelRound(10);
			}
			
		}
		
		//fratto 10 per ogni round
		int round = 10;
		double hitfreq=((double)dieciMilioni / grid.getStato().getBonusCoin()/(double)round);
		double averageBonWin=(float)grid.getStato().getTotaleBonus()/hitfreq;
		double averageDice = grid.getStato().getDiceSum()/grid.getStato().getBonusCoin();
		
		double bonusGameAverageWin = averageDice * averageBonWin * round;
		double bonusGameReturn = bonusGameAverageWin /hitfreq / round;
		
		
		System.out.println("Starting with an amount of coin of :\t\t" + dieciMilioni);

		System.out.println("Base Game return :\t\t\t\t" + (grid.getStato().getPunteggio()/(float)dieciMilioni) * 100 + " %" );

		System.out.println("Average Bonus Game return :\t\t\t" + averageBonWin + " %" );
		
		System.out.println("Coins won with a Bonus Game :\t\t\t" + bonusGameAverageWin);

		System.out.println("Hit frequency in Bonus Games : \t\t\t" + hitfreq);

		System.out.println("Bonus Game return :\t\t\t\t" + bonusGameReturn);


//		System.out.println("Total of hits :\t\t\t\t\t" + stato.getHit());
//		System.out.println("Total of coins lost :\t\t\t\t" + ( dieciMilioni-grid.getStato().getPunteggio()));
	

	}
}
