package it.edu.iisvolta;

import java.util.ArrayList;
import java.util.Random;

public class Mazzo {
	private String tipologia;
	private ArrayList<Carta> elencoCarte=new ArrayList<>();
	private String[] semiNapoletani= {"Bastoni","Coppe","Denari","Spade"};
	private String[] semiFrancesi= {"Quadri","Fiori","Picche","Cuori"};
	
	public Mazzo(String tipologia) throws Exception {
		super();
		this.tipologia = tipologia;
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
		do {
			pos=r.nextInt(elencoCarte.size());	//posizione casuale tra 0 e posizione massima	
			c=elencoCarte.get(pos);
		} while (c.isEstratta());  //se è già estratta torno indietro
		
		c.setEstratta(true);	
		return c;
	}

	public String getTipologia() {
		return tipologia;
	}

	
}
