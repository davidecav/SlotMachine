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

		System.out.println("il totale era di :\t\t\t\t" + dieciMilioni);

		System.out.println("la media di vittorie e di :\t\t\t" + (grid.getStato().getPunteggio()/(float)dieciMilioni) * 100 + " %" );

		System.out.println("la media di bonus game a partita e di :\t\t" + ((float)dieciMilioni / grid.getStato().getBonusCoin()/10));

		System.out.println("i gettoni guadagnati con i bonus sono:\t\t" + stato.getTotaleBonus());
		
		System.out.println("si sono persi :\t\t\t\t\t" + ( dieciMilioni-grid.getStato().getPunteggio()));

		System.out.println("il totale di hit e di :\t\t\t\t" + stato.getHit());

	

	}
}
