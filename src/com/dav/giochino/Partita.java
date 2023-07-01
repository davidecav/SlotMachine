package com.dav.giochino;

/**
 * @author Davide Cavalieri 01/07/2023 
 * 
 * */
public class Partita {

	private StatoPartita stato;
	
	Partita(StatoPartita stato){
		this.stato=stato;
	}

	public int controllacaselle(Casella c1, Casella c2, Casella c3){
		
		int punteggio=0;
		if((c1==Casella.W1)&&(c2!=Casella.B1)) {c1=c2;}else if((c1==Casella.W1)&&(c2==Casella.B1)){c1=c3;}
		if((c2==Casella.W1)&&(c1!=Casella.B1)) {c2=c1;}else if((c2==Casella.W1)&&(c1==Casella.B1)){c2=c3;}
		if((c3==Casella.W1)&&(c2!=Casella.B1)) {c3=c2;}
		
		
		if((c1==c2)&&(c2==c3))	 { 
			punteggio = moltiplicatore(c1); 
			stato.setHit(stato.getHit()+1); 
			
	
		}

		return punteggio;
	}
	public void assegnaPunti(Casella[][]griglia) {
		int punteggio=0;
		int bonus=0;
		
		Casella upleft = 	griglia[0][0];
		Casella upmid = 	griglia[0][1];
		Casella upright = 	griglia[0][2];
		Casella halfleft = 	griglia[1][0];
		Casella halfmid = 	griglia[1][1];
		Casella halfright = griglia[1][2];
		Casella downleft = 	griglia[2][0];
		Casella downmid = 	griglia[2][1];
		Casella downright = griglia[2][2];

		

		//stampaGriglia();
		
		punteggio += controllacaselle(upleft, halfmid, downright);
/*
		 			* - -
					- * -
					- - *
*/
		punteggio += controllacaselle(downleft, halfmid, upright);
/*
					- - *
					- * -
			 		* - -
*/
		punteggio += controllacaselle(upleft, upmid, upright);
/*
				* * *
				- - -
				- - -
*/
		punteggio += controllacaselle(halfleft, halfmid, halfright);
/*
				- - -
				* * *
				- - -
*/
		punteggio += controllacaselle(downleft, downmid, downright);
/*
				- - -
				- - -
		 		* * *
*/
		
		for (Casella[] riga : griglia) {
			for (Casella numerobonus : riga) {
				if(numerobonus==Casella.B1) bonus++;
			}
		}
		
		if(bonus>=3) {
			int partitaBonus=(int)Math.round(bonus/3);
			partitaBonus(partitaBonus);
		}
		//stato.setBonus(0);
		this.stato.setPunteggio(this.stato.getPunteggio()+punteggio);
	
	}
	public int moltiplicatore(Casella casella) {
		int moltiplicatore=0;
		
		switch(casella) {
			case W1:
				moltiplicatore += 2000;
				break;
			case L1:
				moltiplicatore += 60;
				break;
			case L2:
				moltiplicatore += 20;
				break;
			case L3:
				moltiplicatore += 16;
				break;
			case L4:
				moltiplicatore += 12;
				break;
			case H1:
				moltiplicatore += 800;
				break;
			case H2:
				moltiplicatore += 400;
				break;
			case H3:
				moltiplicatore += 80;
				break;
		
		}
		
		return moltiplicatore;
	
	}
	public void partitaBonus(int partitaBonus){

		int coins []={100, 50, 30, 20, 10, 5, 4, 3, 2};
		double moltiplicatore = Math.ceil (Math.random()*1401);

		if 		(moltiplicatore>=0		&&	moltiplicatore<10) 		{moltiplicatore=coins[0];}
		else if (moltiplicatore>=10 	&& 	moltiplicatore<30) 		{moltiplicatore=coins[1];}
		else if (moltiplicatore>=30 	&& 	moltiplicatore<70) 		{moltiplicatore=coins[2];}
		else if (moltiplicatore>=70 	&& 	moltiplicatore<120) 	{moltiplicatore=coins[3];}
		else if (moltiplicatore>=120 	&&	moltiplicatore<271) 	{moltiplicatore=coins[4];}
		else if (moltiplicatore>=271 	&& 	moltiplicatore<491) 	{moltiplicatore=coins[5];}
		else if (moltiplicatore>=491 	&& 	moltiplicatore<7511)	{moltiplicatore=coins[6];}
		else if (moltiplicatore>=751 	&& 	moltiplicatore<1051) 	{moltiplicatore=coins[7];}
		else if (moltiplicatore>=1051 	&& 	moltiplicatore<1401) 	{moltiplicatore=coins[8];}

		

		double lancio =Math.ceil(Math.random()*6);

		this.stato.setBonusCoin(this.stato.getBonusCoin()+partitaBonus);
		//10 round
		if(stato.getPartiteNelRound() % 10 != 0){

			double gettoni = lancio * moltiplicatore/1401 *(this.stato.getPartiteNelRound()%10);
		
			this.stato.setTotaleBonus(this.stato.getTotaleBonus() + gettoni);
		}

	}
	
}
