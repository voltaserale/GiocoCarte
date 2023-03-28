package it.edu.iisvolta;

import java.util.ArrayList;
import java.util.Random;

public class Mazzo {
	private String tipologia;
	private ArrayList<Carta> elencoCarte=new ArrayList<>();
	private String[] semiNapoletani= {"Bastoni","Coppe","Denari","Spade"};
	private String[] semiFrancesi= {"Quadri","Fiori","Picche","Cuori"};
	private int numeroEstratte;
	
	public Mazzo(String tipologia) throws Exception {
		super();
		this.tipologia = tipologia;
		numeroEstratte=0;
		switch(tipologia) {
			case "napoletane":
				for (int seme=0;seme<4;seme++)
					for(int valore=1;valore<=10;valore++) {	
						Carta c=new Carta(valore, semiNapoletani[seme]);
						elencoCarte.add(c);						
					}
				break;
			case "francesi":
				for (int seme=0;seme<4;seme++)
					for(int valore=1;valore<=13;valore++) {	
						Carta c=new Carta(valore, semiFrancesi[seme]);
						elencoCarte.add(c);						
					}						
				break;
			default:	//errore personalizzato
				throw new Exception("Tipo di mazzo non valido");
			
		}
	}
	
	public Carta estraiCarta() {
		Random r=new Random();
		int pos;
		Carta c;
		if (numeroEstratte<elencoCarte.size())
		{
			//c'è ancora qualcosa da estrarre
			do {
				pos=r.nextInt(elencoCarte.size());	//posizione casuale tra 0 e posizione massima	
				c=elencoCarte.get(pos);
			} while (c.isEstratta());  //se è già estratta torno indietro
			
			c.setEstratta(true);
			numeroEstratte++;
		} else
			//tutte le carte sono state estratte => ritorno una carta nulla
			c=null;
		
		return c;
	}

	public String getTipologia() {
		return tipologia;
	}

	
}
