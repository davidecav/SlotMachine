package com.dav.giochino;


/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */
public class Round {


	public Grid giocaround(StatoPartita stato) {
			
			Grid grid = new Grid(stato);
			Partita part = new Partita(stato);
		
			//seleziono tre velocita casuali
			int velocita = (int)Math.ceil(Math.random()*3000);
			int velocita2 = (int)Math.ceil(Math.random()*70000);
			int velocita3 = (int)Math.ceil(Math.random()*100000);
			
			Casella [][] griglia = grid.start(velocita,velocita2,velocita3);

			part.assegnaPunti(griglia);
			

			//il round costa 10 gettoni
			stato.setCredits(stato.getCredits()-10);

			grid.setStato(stato);
			
			

	
		return grid;
		
	}
	
}
